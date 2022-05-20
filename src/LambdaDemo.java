import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class LambdaDemo {
    public static final Function<String, Integer> getLength = String::length;
    public static final Function<String, Character> getFirstSymbol = n -> (n == null || n.length() == 0) ? null : n.charAt(0);
    public static final Function<String, Boolean> containsSpace = n -> !n.contains(" ");
    public static final Function<String, Integer> replaceCount = n -> n.split(",").length;
    public static final Function<? super Human, Integer> getAge = Human::getAge;
    public static final BiPredicate<? super Human, ? super Human> equalsLastName = (n, m) -> n.getLastName().equals(m.getLastName());
    public static final Function<? super Human, String> getFullName = n -> n.getFirstName() + " " + n.getLastName() + " " + n.getPatronymic();
    public static final Function<Human, Human> makeOldest = n -> new Human(n.getFirstName(), n.getLastName(), n.getPatronymic(), n.getAge() + 1, n.getGender());
    public static final BiPredicate<List<Human>, Integer> isYoungerMaxAge = (list, maxAge) -> {
        for (Human human : list) {
            if (human.getAge() > maxAge) return false;
        }
        return true;
    };
}
