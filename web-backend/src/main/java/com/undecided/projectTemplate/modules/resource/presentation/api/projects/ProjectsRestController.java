package com.undecided.projectTemplate.modules.resource.presentation.api.projects;

import com.undecided.projectTemplate.resource.buisiness.command.RegisterProductCommand;
import com.undecided.projectTemplate.resource.domain.project.Project;
import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api")
public class ProjectsRestController {

    private final RegisterProductCommand registerProductCommand;

    public ProjectsRestController(RegisterProductCommand registerProductCommand) {
        this.registerProductCommand = registerProductCommand;
    }

    @GetMapping("v1.0/projects")
    Project[] getAll() {
        return new Project[]{};

    }

    @GetMapping("v1.0/projects/{id}")
    Project get(@PathVariable("id") UlidIdentifier<Project> projectId) {
        return Project.empty();

    }

    @PostMapping("v1.0/projects")
    ResponseEntity<Project> post(@RequestBody Project project, UriComponentsBuilder uriBuilder) {
        Project createdProject = registerProductCommand.register(project);

        // Locationで設定するURLを作成する
        URI location = uriBuilder.path("v1.0/products/{id}")    // c
            .buildAndExpand(createdProject.getProjectId().asString())    // d
            .toUri();

        // レスポンス情報を作成
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("v1.0/projects/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") UlidIdentifier<Project> projectId) {

        // レスポンス情報を作成
        return ResponseEntity.noContent().build();
    }

    @PutMapping("v1.0/projects/{id}")
    public ResponseEntity<Project> update(@PathVariable UlidIdentifier<Project> id,
        @RequestBody Project sourceProject) {

        return ResponseEntity.ok(sourceProject);

    }
}
