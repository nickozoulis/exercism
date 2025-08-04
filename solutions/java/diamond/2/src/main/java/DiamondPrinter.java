import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DiamondPrinter {
    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private List<String> diamondList;

    public DiamondPrinter() {
        diamondList = new ArrayList<>();
    }

    List<String> printToList(char a) {
        if (a == 'A') {
            diamondList.add("A");
        } else {
            var indexOfCharacter = alphabet.indexOf(a);
            var substring = alphabet.substring(0, indexOfCharacter + 1);
            var horizontalSize = indexOfCharacter * 2 + 1;

            var list1 = new ArrayList<String>();
            for (int i = 0; i <= substring.length() - 1; i++) {
                list1.add(formatStr(substring.charAt(i), i, horizontalSize));
            }

            var list2 = new ArrayList<>(list1);
            Collections.reverse(list2);
            if (list2.size() > 1) list2.remove(0);

            diamondList.addAll(list1);
            diamondList.addAll(list2);
        }

        return diamondList;
    }

    private String formatStr(char character, int indexOfCharacter, int horizontalSize) {
        var str = new StringBuilder(horizontalSize);

        for (int i = 0; i < horizontalSize; i++) {
            if (character == 'A') {
                if (i == horizontalSize / 2) {
                    str.append('A');
                } else {
                    str.append(" ");
                }
            } else {
                if (i == horizontalSize / 2 - indexOfCharacter || i == horizontalSize / 2 + indexOfCharacter) {
                    str.append(character);
                } else {
                    str.append(" ");
                }
            }

        }

        return str.toString();
    }

}
