package template.modules.resource.presentation.api.actors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import template.modules.project.domain.model.project.Project;
import template.modules.story.appl.command.actor.RegisterActorCommand;
import template.modules.story.domain.model.actor.Actor;
import template.shared.entity.id.SnowflakeId;

import java.net.URI;

@RestController
@RequestMapping("api")
public class ActorsRestController {

    private final RegisterActorCommand registerActorCommand;

    public ActorsRestController(RegisterActorCommand registerActorCommand) {
        this.registerActorCommand = registerActorCommand;
    }

    @GetMapping("v1.0/actors")
    Project[] getAll() {
        return new Project[]{};

    }

    @GetMapping("v1.0/actors/{id}")
    Project get(@PathVariable("id") SnowflakeId projectId) {
        return Project.empty();

    }

    @PostMapping("v1.0/actors")
    ResponseEntity<Project> post(@RequestBody Actor actor, UriComponentsBuilder uriBuilder) {
        Actor createdActor = registerActorCommand.insert(actor);

        // Locationで設定するURLを作成する
        URI location = uriBuilder.path("v1.0/actors/{id}")    // c
                .buildAndExpand(createdActor.getId().asString())    // d
                .toUri();

        // レスポンス情報を作成
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("v1.0/actors/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") SnowflakeId actorId) {

        // レスポンス情報を作成
        return ResponseEntity.noContent().build();
    }

    @PutMapping("v1.0/actors/{id}")
    public ResponseEntity<Actor> update(@PathVariable SnowflakeId id,
                                        @RequestBody Actor sourceActor) {

        return ResponseEntity.ok(sourceActor);

    }
}
