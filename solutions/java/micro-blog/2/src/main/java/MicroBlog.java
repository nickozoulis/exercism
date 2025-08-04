import java.util.stream.Collector;


class MicroBlog {
    public String truncate(String input) {
        return input.codePoints()
                .limit(5)
                .mapToObj(Character::toChars)
                .collect(Collector.of(
                    StringBuilder::new,
                    StringBuilder::append,
                    StringBuilder::append,
                    StringBuilder::toString)
                );
    }

}
