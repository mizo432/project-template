package template.modules.admin.domain.model.project;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

import java.io.Serial;

/**
 * プロジェクトを登録したアプリケーションイベント
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class RegisteredProjectEvent extends
        ApplicationEvent {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 登録したプロジェクト
     */
    private final Project project;

    /**
     * コンストラクター
     *
     * @param source  元オブジェクト
     * @param project プロジェクト
     */
    public RegisteredProjectEvent(final Object source, final Project project) {
        super(source);
        this.project = project;
    }
}
