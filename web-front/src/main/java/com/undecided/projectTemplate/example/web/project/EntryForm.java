package com.undecided.projectTemplate.example.web.project;

import com.undecided.projectTemplate.resource.domain.project.Project;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EntryForm {
    private Project project = new Project();

}