import java.math.BigInteger;
import java.util.stream.IntStream;

class Grains {

    BigInteger grainsOnSquare(final int square) {
        if (square > 64 || square <= 0) throw new IllegalArgumentException("square must be between 1 and 64");
        return IntStream.range(1, square).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, (acc, s) -> acc.multiply(BigInteger.TWO));
    }

    BigInteger grainsOnBoard() {
        return IntStream.range(1, 65).mapToObj(this::grainsOnSquare).reduce(BigInteger.ZERO, BigInteger::add);
    }

}
