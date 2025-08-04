import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class RnaTranscription {

    private static Map<Character, Character> mappings;

    public RnaTranscription() {
        mappings = new HashMap();
        mappings.put('G', 'C');
        mappings.put('C', 'G');
        mappings.put('T', 'A');
        mappings.put('A', 'U');
    }

    String transcribe(String dnaStrand) {
        return dnaStrand
                .chars()
                .mapToObj(c -> (char) c)
                .map(c -> mappings.get(c))
                .map(Object::toString)
                .collect(Collectors.joining());
    }

}
