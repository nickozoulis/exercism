import java.util.Optional;

public class Twofer {
    public String twofer(String name) {
        return Optional.ofNullable(name)
                .map(n -> String.format("One for %s, one for me.", n))
                .orElse("One for you, one for me.");
    }
}
