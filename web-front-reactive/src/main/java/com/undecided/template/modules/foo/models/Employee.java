package com.undecided.template.modules.foo.models;

import com.undecided.template.shared.entity.SnowflakeId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Employee {
    private final SnowflakeId id;

}
