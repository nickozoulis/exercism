class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        final var processedStr = stringToVerify
                .replace("-", "")
                .toUpperCase();

        if (processedStr.length() != 10) return false;

        final var partOne = processedStr.substring(0, processedStr.length() - 1);
        final var partTwo = processedStr.substring(processedStr.length() - 1);

        try {
            final var d = partOne.chars().mapToObj(c -> Integer.parseInt(String.valueOf((char) c))).toList();
            int d10 = partTwo.equals("X") ? 10 : Integer.parseInt(partTwo);

            return (d.get(0) * 10 + d.get(1) * 9 + d.get(2) * 8 + d.get(3) * 7 + d.get(4) * 6 + d.get(5) * 5 + d.get(6) * 4 + d.get(7) * 3 + d.get(8) * 2 + d10) % 11 == 0;
        } catch (RuntimeException e) {
            return false;
        }
    }

}
