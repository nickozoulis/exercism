


class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        final var numOfDigits = numOfDigits(numberToCheck, 1);

        return numberToCheck == processNumber(numberToCheck, 0, numOfDigits);
    }

    private double processNumber(int numberToCheck, double acc, int numOfDigits) {
        var div = numberToCheck / 10;
        var mod = numberToCheck % 10;

        if (div >= 0.1) {
            return processNumber(div, acc + Math.pow(mod, numOfDigits), numOfDigits);
        }

        return acc + Math.pow(mod, numOfDigits);
    }

    private int numOfDigits(int numberToCheck, int acc) {
        var x = numberToCheck / 10;

        if (x > 0) {
            return numOfDigits(x, acc + 1);
        }

        return acc;
    }


}
