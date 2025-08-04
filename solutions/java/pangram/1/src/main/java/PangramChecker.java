import java.util.HashSet;
import java.util.Set;

public class PangramChecker {

    private Set<String> lettersSeen;

    PangramChecker() {
        lettersSeen = new HashSet<>();
    }

    public boolean isPangram(String input) {
        input.replaceAll("[^a-zA-Z]", "")
                .chars()
                .mapToObj(c -> String.valueOf((char) c).toLowerCase())
                .forEach(letter -> lettersSeen.add(letter));

        return lettersSeen.size() == 26;
    }

}
