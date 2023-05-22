package com.undecided.projectTemplate.teamMember.domain.member;

import com.undecided.projectTemplate.project.domain.model.project.Project;
import com.undecided.projectTemplate.resource.domain.partyRole.user.User;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Member {

    SnowflakeId<User> id;
    MemberAttribute attribute;

    SnowflakeId<Project> projectId;

    public Member(SnowflakeId<User> id, MemberAttribute attribute
    ) {
        this.id = id;
        this.attribute = attribute;
    }

}
