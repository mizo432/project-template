package com.undecided.projectTemplate.teamMember.domain.member;

import com.undecided.projectTemplate.resource.domain.partyRole.user.User;
import com.undecided.projectTemplate.resource.domain.project.Project;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Member {

    SnowflakeIdentifier<User> id;
    MemberAttribute attribute;

    SnowflakeIdentifier<Project> projectId;

    public Member(SnowflakeIdentifier<User> id, MemberAttribute attribute
    ) {
        this.id = id;
        this.attribute = attribute;
    }

}
