class CollatzCalculator {

    int computeStepCount(int start) {
        if (start <= 0) {
            throw new IllegalArgumentException("Only positive integers are allowed");
        }
        var count = 0;
        var num = start;

        while (true) {

            if (num <= 1) {
                break;
            }

            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num * 3 + 1;
            }

            count++;
        }

        return count;
    }

}
