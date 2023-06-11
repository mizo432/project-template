package com.undecided.projectTemplate.modules.project.domain.model.member;

import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

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
