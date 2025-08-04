public class EliudsEggs {
    public int eggCount(int number) {
        return (int) Integer.toBinaryString(number)
                .chars()
                .filter(c -> String.valueOf((char)c).equals("1"))
                .count();
    }
}
