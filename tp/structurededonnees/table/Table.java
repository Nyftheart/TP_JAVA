package tp.structurededonnees.table;

import java.util.*;
import java.util.function.Function;

public class Table<T> {
    private final List<T> elements;

    private Table(List<T> elements) {
        this.elements = elements;
    }

    public static <T> Table<T> of(T... elements) {
        return new Table<>(List.of(elements));
    }

    public int size() {
        return elements.size();
    }

    public <K> Group<K, Integer> groupBy(Function<T, K> projection, Comparator<K> comparator) {
        Objects.requireNonNull(projection, "null");
        Objects.requireNonNull(comparator, "null");

        Map<K, List<Integer>> groups = new HashMap<>();

        for (int i = 0; i < elements.size(); i++) {
            T element = elements.get(i);
            K key = projection.apply(element);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(i);
        }

        List<K> keys = new ArrayList<>(groups.keySet());
        Collections.sort(keys, comparator);

        Group<K, Integer> resultGroup = new Group<>();
        for (K key : keys) {
            List<Integer> indices = groups.get(key);
            resultGroup.add(key, indices);
        }

        return resultGroup;
    }



    public static class Group<K, V> {
        private final List<K> keys;
        private final List<List<V>> values;

        public Group() {
            this.keys = new ArrayList<>();
            this.values = new ArrayList<>();
        }

        public void add(K key, List<V> values) {
            this.keys.add(key);
            this.values.add(values);
        }

        public int keySize() {
            return keys.size();
        }

        public void display() {
            for (int i = 0; i < keys.size(); i++) {
                K key = keys.get(i);
                List<V> indices = values.get(i);
                System.out.println(key + ": " + indices);
            }
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < keys.size(); i++) {
                K key = keys.get(i);
                List<V> indices = values.get(i);
                sb.append(key).append(": ").append(indices).append("\n");
            }
            return sb.toString().trim();
        }

    }
}
