package tp.therad.strtok;

public class strtok {
    private static final ThreadLocal<CharSequence> lastInput = new ThreadLocal<>();
    private static final ThreadLocal<Integer> lastOffset = ThreadLocal.withInitial(() -> 0);

    public static CharSequence strtok(CharSequence input, char delimiter) {
        int offset;
        if (input == null) {
            input = lastInput.get();
            if (input == null) {
                return null;
            }
            offset = lastOffset.get();
        } else {
            lastInput.set(input);
            offset = 0;
            lastOffset.set(offset);
        }

        for (int i = offset; i < input.length(); i++) {
            if (input.charAt(i) == delimiter) {
                lastOffset.set(i + 1);
                return input.subSequence(offset, i);
            }
        }

        lastInput.remove();
        lastOffset.remove();
        return input.subSequence(offset, input.length());
    }

    public static void main(String[] args) {
        CharSequence seq1 = strtok("Test du Test", ' ');
        CharSequence seq2 = strtok(null, ' ');
        CharSequence seq3 = strtok(null, ' ');
        CharSequence seq4 = strtok(null, ' ');

        System.out.println(seq1);
        System.out.println(seq2);
        System.out.println(seq3);
        System.out.println(seq4);
    }
}
