package conteudo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamOperations {

    public static void main(String[] args) {
        int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};
        System.out.println("Original Values: ");
        IntStream.of(values).forEach(value -> System.out.printf("%d ", value));
        System.out.println();

        //count, min, max, sum e average
        System.out.printf("%nCount: %d%n", IntStream.of(values).count());
        System.out.printf("Min: %d%n", IntStream.of(values).min().getAsInt());
        System.out.printf("Max: %d%n", IntStream.of(values).max().getAsInt());
        System.out.printf("Sum: %d%n", IntStream.of(values).sum());
        System.out.printf("Average: %.2f%n%n", IntStream.of(values).average().getAsDouble());

        //soma com o metodo reduce
        System.out.printf("sum via reduce : %d%n", IntStream.of(values).reduce(0, (x, y) -> x + y));

        //produto com o metodo reduce
        System.out.printf("product via reduce: %d%n", IntStream.of(values).reduce(1, (x, y) -> x * y));

        //valores pares
        IntStream.of(values).filter(value -> value % 2 == 0).sorted().forEach(value -> System.out.print(value + " "));
        System.out.println();

        //valores impares multiplicados por 10
        IntStream.of(values).filter(value -> value % 2 != 0).map(value -> value * 10).sorted().forEach(value -> System.out.print(value + " "));

        System.out.println();
        System.out.println(IntStream.of(values).summaryStatistics());


    }


}
