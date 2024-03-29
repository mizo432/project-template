package template.shared.relationship.party.domain.person;

import org.jetbrains.annotations.NotNull;
import template.shared.entity.id.SnowflakeId;

import java.util.Collection;
import java.util.List;

import static com.undecided.primitive.list.Lists2.newArrayList;

public class Person extends AbstractPerson {
    public Person(SnowflakeId id) {
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
