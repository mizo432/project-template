package template.modules.admin.appl.command.project;

import com.undecided.gfw.common.exception.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.modules.admin.domain.model.project.Project;
import template.modules.admin.domain.model.project.ProjectRepository;

import static com.undecided.primitive.object.Objects2.isNull;

@Service
@AllArgsConstructor
public class InsertProjectCommand {

    private final ProjectRepository projectRepository;

    @Transactional
    public void execute(Project project) {

        Project found = projectRepository.findOneByProjectCode(project.getAttribute().getProjectCode());
        if (isNull(found)) {
            projectRepository.insert(project);

        } else {
            throw new BusinessException("プロジェクトコードが重複しているため本プロジェクトは登録できません");
        }
    }

}
