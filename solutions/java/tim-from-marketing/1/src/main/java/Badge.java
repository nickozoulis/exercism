import static java.util.Objects.nonNull;

class Badge {
    public String print(Integer id, String name, String department) {

        boolean hasId = nonNull(id);
        boolean hasDepartment = nonNull(department);

        if (!hasId & !hasDepartment) {
            return String.format("%s - OWNER", name);
        } else if (!hasId & hasDepartment) {
            return String.format("%s - %s", name, department.toUpperCase());
        } else if (!hasDepartment) {
            return String.format("[%d] - %s - OWNER", id, name);
        } else {
            return String.format("[%d] - %s - %s", id, name, department.toUpperCase());
        }

    }
}
