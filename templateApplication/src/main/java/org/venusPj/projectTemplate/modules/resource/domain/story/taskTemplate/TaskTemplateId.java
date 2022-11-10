package org.venusPj.projectTemplate.modules.resource.domain.story.taskTemplate;

import de.huxhorn.sulky.ulid.ULID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.entity.id.Id;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@ToString
public class TaskTemplateId extends Id<TaskTemplateId> {

    private final String value;

    public static TaskTemplateId newInstance() {
        return new TaskTemplateId(new ULID().nextValue().toString());

    }

    public static TaskTemplateId reconstruct(String value) {
        return new TaskTemplateId(value);
    }


    @Override
    public String asString() {
        return value;

    }
}
