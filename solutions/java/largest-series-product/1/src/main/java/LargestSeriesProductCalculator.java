class LargestSeriesProductCalculator {

    private String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        var list = inputNumber.chars().mapToObj(Character::isAlphabetic).toList();
        if (list.contains(true)) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
       this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if (numberOfDigits > this.inputNumber.length()) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }

        if (numberOfDigits <= 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }

        var maxProduct = 0L;

        for (int i=0; i <= inputNumber.length() - numberOfDigits; i++) {
           var num = inputNumber.substring(i, i + numberOfDigits);

           var product = num
                   .chars()
                   .mapToObj(c -> Long.valueOf(Character.getNumericValue(c)))
                   .reduce(1L, (acc, d) -> acc * d);

           if (product > maxProduct) {
               maxProduct = product;
            }
        }

       return maxProduct;
    }
}
