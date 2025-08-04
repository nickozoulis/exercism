import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

class DnDCharacter {
    private Random RANDOM;
    private List<Integer> strength;
    private List<Integer> dexterity;
    private List<Integer> constitution;
    private List<Integer> intelligence;
    private List<Integer> wisdom;
    private List<Integer> charisma;

    public DnDCharacter() {
        RANDOM = new Random();
        strength = rollDice();
        dexterity = rollDice();
        constitution = rollDice();
        intelligence = rollDice();
        wisdom = rollDice();
        charisma = rollDice();
    }

    int ability(List<Integer> scores) {
        return scores.stream()
                .sorted(Comparator.reverseOrder())
                .toList()
                .subList(0, 3)
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    List<Integer> rollDice() {
        return IntStream.range(0, 4).mapToObj(x -> RANDOM.nextInt(6) + 1).toList();
    }

    int modifier(int input) {
        final var calc = (input - 10) / 2.0;
        return calc > 0 ? (int) Math.floor(calc) : (int) Math.ceil(calc - 0.5);
    }

    int getStrength() {
        return ability(strength);
    }

    int getDexterity() {
        return ability(dexterity);
    }

    int getConstitution() {
        return ability(constitution);
    }

    int getIntelligence() {
        return ability(intelligence);
    }

    int getWisdom() {
        return ability(wisdom);
    }

    int getCharisma() {
        return ability(charisma);
    }

    int getHitpoints() {
        return modifier(getConstitution()) + 10;
    }
}
