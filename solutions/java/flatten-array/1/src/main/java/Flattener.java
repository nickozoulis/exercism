import java.util.ArrayList;
import java.util.List;

class Flattener {

    List<Object> flatten(List<?> list) {
        var newList = new ArrayList<Object>();

        for (Object element : list) {
            if (element instanceof List<?>) {
                newList.addAll(flatten((List<?>) element));
            } else {
                if (element != null) {
                    newList.add(element);
                }
            }
        }

        return newList;
    }

}