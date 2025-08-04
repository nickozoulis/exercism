import java.util.Arrays;

class SqueakyClean {
    static String clean(String identifier) {

            return cleanFromSymbols(
                    convertKebabCaseToCamelCase(
                                leetSpeakTranslate(
                                        replaceSpacesWithUnderscores(identifier)
                                )
                    )
            );
    }

    private static String replaceSpacesWithUnderscores(String identifer) {
        return identifer.replace(" ", "_");
    }

    private static String convertKebabCaseToCamelCase(String identifer) {
        String tmp = replaceSpacesWithUnderscores(identifer);

        StringBuilder tmp2 = new StringBuilder();
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == '-') {
                tmp2.append(("" + tmp.charAt(i + 1)).toUpperCase());
                i++;
            } else {
                tmp2.append(tmp.charAt(i));
            }
        }
        return tmp2.toString();
    }

    private static String leetSpeakTranslate(String identifier) {
        return identifier
                .replace("4", "a")
                .replace("3", "e")
                .replace("0", "o")
                .replace("1", "l")
                .replace("7", "t");
    }

    private static String cleanFromSymbols(String identifier) {
        return identifier.replaceAll("\\W", "");
    }
}
