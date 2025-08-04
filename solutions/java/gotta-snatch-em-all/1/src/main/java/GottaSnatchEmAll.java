import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        return Set.copyOf(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        return !myCollection.containsAll(theirCollection) && !theirCollection.containsAll(myCollection);
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        final var startingSet = collections.getFirst();
        return collections
                .stream()
                .skip(1)
                .reduce(startingSet, GottaSnatchEmAll::findCommon);
    }

    private static Set<String> findCommon(Set<String> set1, Set<String> set2) {
        final var tmpSet = new HashSet<>(set1);
        tmpSet.retainAll(set2);
        return tmpSet;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        return collections
                .stream()
                .reduce(new HashSet<>(),
                        (partialSet, currentSet) ->
                                Stream.concat(partialSet.stream(), currentSet.stream()).collect(toSet())
                );
    }
}
