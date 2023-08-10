package com.undecided.template.modules.foo.models.foo.admin.employees;

import com.undecided.template.shared.entity.Entity;
import com.undecided.template.shared.entity.SnowflakeId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Getter
@Table(schema = "admin", name = "employee")
public class Employee implements Entity {
    @Id
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String kanaName;

    public static Employee create(String firstName, String lastName, String kanaName) {
        return new Employee(SnowflakeId.newInstance().getValue(), firstName, lastName, kanaName);
    }

    public static Employee reconstruct(Long id, String firstName, String lastName, String kanaName) {
        return new Employee(id, firstName, lastName, kanaName);
    }

}
