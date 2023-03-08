package com.undecided.projectTemplate.modules.business.domain.entity.resource;

import com.undecided.projectTemplate.shared.entity.AbstractEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(immutable = true)
@Table(schema = "tm", name = "resources")
public class Resource extends AbstractEntity<Resource> {


}
