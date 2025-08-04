class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {

        var str = String.valueOf(numberToCheck);
        var sum = 0;

        for (int i = 0; i < str.length(); i++) {
            sum +=  Math.pow(Character.getNumericValue(str.charAt(i)), str.length());
        }

        return numberToCheck == sum;
    }

}
