import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        System.out.println("Task 1");

        Collection<Integer> col = new ArrayList<>(Arrays.asList(new Integer[]{11, 2, 3, 4, 5}));

        int minNumber = col.stream().min(Integer::compare).get();
        int maxNumber = col.stream().max(Integer::compare).get();
        int average = col.stream().reduce(Integer::sum).get() / col.size();
        int multiplyingNumbers = col.stream().reduce((x, y) -> x * y).get();
        int sumNumbers = col.stream().reduce(Integer::sum).get();
        int sumDigits = col.stream().map(n -> n.toString().chars().map(i -> i - '0').sum()).reduce(Integer::sum).get();

        System.out.println(minNumber);
        System.out.println(maxNumber);
        System.out.println(average);
        System.out.println(multiplyingNumbers);
        System.out.println(sumNumbers);
        System.out.println(sumDigits);

        System.out.println("Task 2");

        List<String> myList = Arrays.asList("a1", "a2", "a3", "b1", "b3", "c2", "c1", "c5");
        Stream<String> stringStream = myList.stream();

        stringStream.filter(x -> x.matches("\\w[^3]+"))
            .sorted(((o1, o2) -> {
                int code1 = Integer.parseInt(o1.substring(1, 2));
                int code2 = Integer.parseInt(o2.substring(1, 2));

                if (code2 - code1 != 0) {
                    return code1 - code2;
                } else {
                    char char1 = o1.charAt(1);
                    char char2 = o2.charAt(1);

                    return char2 - char1;
                }
            }))
            .sorted(Collections.reverseOrder())
            .skip(1).limit(myList.size() - 2)
            .map(String::toUpperCase)
            .forEach(System.out::println);
    }
}
