package exercicios;

import java.util.Arrays;
import java.util.Scanner;

public class RemovingDuplicatedWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        Arrays.stream(input)
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);


    }

}
