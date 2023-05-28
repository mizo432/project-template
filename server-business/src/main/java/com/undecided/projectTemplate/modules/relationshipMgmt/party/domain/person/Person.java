package com.undecided.projectTemplate.modules.relationshipMgmt.party.domain.person;

import com.undecided.projectTemplate.modules.relationshipMgmt.party.domain.party.Party;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

import static com.undecided.primitive.list.Lists2.newArrayList;

public class Person extends AbstractPerson {
    public Person(SnowflakeId<Party> id) {
        super(id);
    }

    /**
     * 人のファースコレクション
     */
    public static class People {
        private final List<Person> value = newArrayList();

        public People(Collection<Person> value) {
            this.value.addAll(value);
        }

        /**
         * ファクトリーメソッド
         *
         * @param value 値
         * @return 人
         */
        public static People of(@NotNull Collection<Person> value) {
            return new People(value);
        }

    }

}
