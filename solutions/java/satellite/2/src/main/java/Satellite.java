import java.util.ArrayList;
import java.util.List;

public class Satellite {
    public Tree treeFromTraversals(List<Character> preorderInput, List<Character> inorderInput) {

        if (preorderInput.size() != inorderInput.size()) throw new IllegalArgumentException("traversals must have the same length");
        if (!preorderInput.stream().distinct().allMatch(inorderInput::contains)) throw new IllegalArgumentException("traversals must have the same elements");
        if (preorderInput.stream().distinct().toList().size() != preorderInput.size()) throw new IllegalArgumentException("traversals must contain unique items");
        if (inorderInput.stream().distinct().toList().size() != inorderInput.size()) throw new IllegalArgumentException("traversals must contain unique items");
        if (preorderInput.isEmpty()) return new Tree(null);
        if (preorderInput.size() == 1) return new Tree(new Node(preorderInput.get(0)));

        final var preorderInputArrayList = new ArrayList<>(preorderInput);
        return new Tree(reconstructTree(preorderInputArrayList, inorderInput));
    }

    private Node reconstructTree(ArrayList<Character> preorderInput, List<Character> inorderInput) {
        final var parent = new Node(preorderInput.get(0));

        if (inorderInput.size() == 1) return parent;

        final var indexOfParent = inorderInput.indexOf(preorderInput.get(0));

        preorderInput.remove(0);
        parent.left = reconstructTree(preorderInput, inorderInput.subList(0, indexOfParent));

        preorderInput.remove(0);
        parent.right = reconstructTree(preorderInput, inorderInput.subList(indexOfParent + 1, inorderInput.size()));

        return parent;
    }

}
