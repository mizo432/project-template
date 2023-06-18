package template.modules.project.domain.model.member;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import template.shared.entity.id.SnowflakeId;

@Getter
@EqualsAndHashCode
@ToString
public class Member {

    SnowflakeId id;
    MemberAttribute attribute;

    SnowflakeId projectId;

    public Member(SnowflakeId id, MemberAttribute attribute
    ) {
        this.id = id;
        this.attribute = attribute;
    }

}
