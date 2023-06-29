package template.modules.admin.presentations.users;

import com.undecided.primitive.list.Lists2;
import com.undecided.primitive.longs.Longs;
import com.undecided.primitive.misc.NodeIdGenerator;
import com.undecided.primitive.misc.SnowflakeIdGenerator;
import com.undecided.primitive.string.Strings2;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import template.modules.admin.command.users.AddUserCommand;
import template.modules.admin.command.users.DeleteUserCommand;
import template.modules.admin.command.users.UpdateUserCommand;
import template.modules.admin.domain.users.User;
import template.modules.admin.presentations.ErrorMessage;
import template.modules.admin.query.users.UserFetcher;

@Component
@AllArgsConstructor
@Slf4j
public class UserHandler {
    private final AddUserCommand addUserCommand;
    private final UpdateUserCommand updateUserCommand;
    private final DeleteUserCommand deleteUserCommand;
    private final UserFetcher userFetcher;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userFetcher.findAll(), User.class);
    }

    public Mono<ServerResponse> search(ServerRequest request) {
        MultiValueMap<String, String> criteria = request.queryParams();
        if (criteria.isEmpty()) {
            return ServerResponse
                    .badRequest()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new ErrorMessage("Search must have query params"), ErrorMessage.class);
        }
        if (criteria.containsKey("email")) {
            return ServerResponse
                    .badRequest()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new ErrorMessage("Search must have query params"), ErrorMessage.class);
        }

        var criteriaValue = Lists2.getFirst(criteria.get("email"));
        if (Strings2.isBlank(criteriaValue)) {
            return ServerResponse
                    .badRequest()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new ErrorMessage("Incorrect search criteria value"), ErrorMessage.class);
        } else {
            return ServerResponse
                    .ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(userFetcher.findByEmail(criteriaValue), User.class);
        }

    }

    public Mono<ServerResponse> findUser(ServerRequest request) {
        Long id = Longs.toLongOrNull(request.pathVariable("id"));
        if (id == null) {
            return ServerResponse
                    .badRequest()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new ErrorMessage("`id` must be numeric"), ErrorMessage.class);
        } else {
            var user = userFetcher.findById(id);
            if (user == null) {
                return ServerResponse
                        .notFound()
                        .build();
            } else {
                return ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(user, User.class);
            }
        }
    }

    public Mono<ServerResponse> addUser(ServerRequest request) {

        Mono<UserDto> newUser;
        try {
            newUser = request.bodyToMono(UserDto.class);
        } catch (Exception e) {
            log.error("Decoding body error", e);
            return ServerResponse
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(e, ErrorMessage.class);
        }
        if (newUser == null) {
            return ServerResponse
                    .badRequest()
                    .body(new ErrorMessage("Invalid body"), ErrorMessage.class);
        } else {
            Long id = new SnowflakeIdGenerator(NodeIdGenerator.generateNodeId()).generateID();
            User newUser2 = newUser.block().convertToModel(id);
            Mono<User> user = addUserCommand.execute(newUser2);
            if (user.block() == null) {
                return ServerResponse
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(new ErrorMessage("Internal error"), ErrorMessage.class);
            } else {
                return ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(user, User.class);
            }
        }
    }

    public Mono<ServerResponse> updateUser(ServerRequest request) {
        Long id = Longs.toLongOrNull(
                request.pathVariable("id"));

        if (id == null) {
            return ServerResponse
                    .badRequest()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new ErrorMessage("`id` must be numeric"), ErrorMessage.class);
        } else {
            Mono<UserDto> updateUser;
            try {
                updateUser = request.bodyToMono(UserDto.class);
            } catch (Exception e) {
                log.error("Decoding body error", e);
                updateUser = null;
            }
            if (updateUser == null) {
                return ServerResponse
                        .badRequest()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(new ErrorMessage("Invalid body"), ErrorMessage.class);
            } else {

                Mono<User> user = updateUserCommand.execute(updateUser.block().convertToModel(id));
                if (user == null) {
                    return ServerResponse
                            .status(HttpStatus.NOT_FOUND)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(new ErrorMessage("Resource $id not found"), ErrorMessage.class);
                } else {
                    return ServerResponse
                            .ok()
                            .body(user, User.class);
                }
            }
        }
    }

    public Mono<ServerResponse> deleteUser(ServerRequest request) {
        var id = request.pathVariable("id");
        if (id == null) {
            return ServerResponse
                    .badRequest()
                    .body(new ErrorMessage("`id` must be numeric"), ErrorMessage.class);
        } else {
            if (deleteUserCommand.execute(Long.valueOf(id))) {
                return ServerResponse.noContent().build();
            } else {
                return ServerResponse
                        .notFound()
                        .build();
//                        .build(new ErrorMessage("Resource $id not found"),ErrorMessage.class);
            }
        }

    }
}