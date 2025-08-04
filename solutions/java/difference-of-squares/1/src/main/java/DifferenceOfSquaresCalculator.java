import java.util.stream.IntStream;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        return (int) Math.pow(
                IntStream.range(1, input + 1).sum(), 2
        );
    }

    int computeSumOfSquaresTo(int input) {
        return IntStream.range(1, input + 1)
                .mapToObj(n -> Math.pow(n, 2))
                .map(Double::intValue)
                .reduce(Integer::sum)
                .get();
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
