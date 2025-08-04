import java.util.HashMap;
import java.util.Map;

public class DialingCodes {
    private HashMap<Integer, String> codes;

    public DialingCodes() {
        codes = new HashMap<>();
    }

    public Map<Integer, String> getCodes() {
        return codes;
    }

    public void setDialingCode(Integer code, String country) {
        codes.put(code, country);
    }

    public String getCountry(Integer code) {
        return codes.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if (!(codes.containsKey(code) || codes.containsValue(country))) {
            setDialingCode(code, country);
        }
    }

    public Integer findDialingCode(String country) {
        return codes.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(country))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public void updateCountryDialingCode(Integer code, String country) {
        final var maybeCode = findDialingCode(country);

        if (maybeCode != null) {
            codes.remove(maybeCode);
            setDialingCode(code, country);
        }

    }
}
