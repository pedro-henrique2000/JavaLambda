package conteudo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAndStreams {

    public static void main(String[] args) {
        Integer[] values = {2, 9, 5, 0, 3, 7, 1, 4, 8, 6};

        System.out.printf("Original values: %s%n", Arrays.asList(values));

        System.out.printf("Sorted Values: %s%n",
                Arrays.stream(values)
                        .filter(value -> value > 4)
                        .sorted()
                        .collect(Collectors.toList()));

        List<Integer> greaterThan5 =
                Arrays.stream(values)
                        .filter(value -> value > 5)
                        .sorted()
                        .collect(Collectors.toList());

        System.out.printf("Greater than 5: %s%n", greaterThan5);

    }

}
