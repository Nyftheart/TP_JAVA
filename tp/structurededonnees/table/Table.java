package tp.structurededonnees.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table<T> {
    private final List<T> elements;

    private Table(List<T> elements) {
        this.elements = elements;
    }

    public static <T> Table<T> of(T... elements) {
        return new Table<>(Arrays.asList(elements));
    }

    public int size() {
        return elements.size();
    }
}
