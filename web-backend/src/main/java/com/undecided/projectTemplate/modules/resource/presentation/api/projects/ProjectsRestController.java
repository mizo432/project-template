package com.undecided.projectTemplate.modules.resource.presentation.api.projects;

import com.undecided.projectTemplate.project.domain.appl.command.project.RegisterProjectCommand;
import com.undecided.projectTemplate.project.domain.model.project.Project;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api")
public class ProjectsRestController {

    private final RegisterProjectCommand registerProjectCommand;

    public ProjectsRestController(RegisterProjectCommand registerProductCommand) {
        this.registerProjectCommand = registerProductCommand;
    }

    @GetMapping("v1.0/projects")
    Project[] getAll() {
        return new Project[]{};

    }

    @GetMapping("v1.0/projects/{id}")
    Project get(@PathVariable("id") SnowflakeId projectId) {
        return Project.empty();

    }

    @PostMapping("v1.0/projects")
    ResponseEntity<Project> post(@RequestBody Project project, UriComponentsBuilder uriBuilder) {
        Project createdProject = registerProjectCommand.register(project);

        // Locationで設定するURLを作成する
        URI location = uriBuilder.path("v1.0/projects/{id}")    // c
                .buildAndExpand(createdProject.getId().asString())    // d
                .toUri();

        // レスポンス情報を作成
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("v1.0/projects/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") SnowflakeId projectId) {

        // レスポンス情報を作成
        return ResponseEntity.noContent().build();
    }

    @PutMapping("v1.0/projects/{id}")
    public ResponseEntity<Project> update(@PathVariable SnowflakeId id,
                                          @RequestBody Project sourceProject) {

        return ResponseEntity.ok(sourceProject);

    }
}
