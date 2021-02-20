package conteudo;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysAndStream2 {

    public static void main(String[] args) {
        String[] strings =
                {"Red", "Orange", "Yellow", "green", "Blue", "indigo", "Violet"};

        System.out.printf("Original strings : %s%n", Arrays.asList(strings));

        System.out.printf("strings in upper case: %s%n",
                Arrays.stream(strings)
                        .map(String::toUpperCase)
                        .collect(Collectors.toList()));

        System.out.printf("strings greater than m sorted ascending: %s%n",
                Arrays.stream(strings)
                        .filter(string -> string.compareToIgnoreCase("n") > 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER)
                        .collect(Collectors.toList())
        );

        System.out.printf("strings greater than m sorted descending: %s%n",
                Arrays.stream(strings)
                        .filter(string -> string.compareToIgnoreCase("n") > 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                        .collect(Collectors.toList())
        );


    }

}
