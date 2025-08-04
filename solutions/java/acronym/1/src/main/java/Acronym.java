import java.util.Arrays;
import java.util.stream.Collectors;

class Acronym {

    private String acronym;

    Acronym(String phrase) {
        acronym = Arrays.stream(phrase.replaceAll("'", "")
                .replaceAll("[^a-zA-Z]", " ")
                .split(" "))
                .map(w -> w.isEmpty() ? w : w.substring(0, 1).toUpperCase())
                .collect(Collectors.joining());
    }

    String get() {
        return acronym;
    }

}
