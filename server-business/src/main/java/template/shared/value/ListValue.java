package template.shared.value;

import java.util.List;

public interface ListValue<E> extends SingleValue<List<E>> {


    String asString();

}
