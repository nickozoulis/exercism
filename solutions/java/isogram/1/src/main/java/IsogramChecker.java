import java.util.ArrayList;
import java.util.HashSet;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        final var acc = new ArrayList<>();

        phrase.replace("-", "")
                .replace(" ", "")
                .toLowerCase()
                .chars().forEach(c -> acc.add((char) c));

        return new HashSet<>(acc).size() == acc.size();
    }

}
