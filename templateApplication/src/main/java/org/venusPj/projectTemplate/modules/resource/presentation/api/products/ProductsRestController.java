package org.venusPj.projectTemplate.modules.resource.presentation.api.products;

import java.net.URI;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.venusPj.projectTemplate.modules.resource.domain.project.Project;
import org.venusPj.projectTemplate.modules.resource.usecase.command.RegisterProductCommand;

@RestController
@RequestMapping("api/")
public class ProductsRestController {

    private final RegisterProductCommand registerProductCommand;

    public ProductsRestController(RegisterProductCommand registerProductCommand) {
        this.registerProductCommand = registerProductCommand;
    }

    @GetMapping("v1.0/products")
    Project[] getAll() {
        return new Project[]{};

    }

    @PostMapping("v1.0/products")
    ResponseEntity<Project> post(@RequestBody Project project, UriComponentsBuilder uriBuilder) {
        Project createdProject = registerProductCommand.register(project);

        // Locationで設定するURLを作成する
        URI location = uriBuilder.path("api/v1.0/products/{id}")    // c
            .buildAndExpand(createdProject.getProjectId().asString())    // d
            .toUri();

        // レスポンスのHTTPヘッダー
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);

        // レスポンス情報を作成
        return new ResponseEntity<>(
            createdProject, headers, HttpStatus.CREATED);
    }
}
