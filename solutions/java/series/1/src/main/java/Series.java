import java.util.ArrayList;
import java.util.List;

class Series {

    private final String string;

    Series(String string) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException("series cannot be empty");
        }
        this.string = string;
    }

    List<String> slices(int num) {
        var slices = new ArrayList<String>();

        if (num > string.length()) {
            throw new IllegalArgumentException("slice length cannot be greater than series length");
        }

        if (num <= 0) {
            throw new IllegalArgumentException("slice length cannot be negative or zero");
        }

        for(int i=0; i <= string.length() - num; i++) {
            slices.add(string.substring(i, i + num));
        }

        return slices;
    }
}
