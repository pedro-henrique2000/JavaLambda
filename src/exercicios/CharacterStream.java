package exercicios;

import java.security.SecureRandom;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CharacterStream {

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxwyz";

        List<Character> characterList = random.ints(30,0,52)
                .boxed()
                .map(v -> abc.charAt(v))
                .collect(Collectors.toList());

        //ascend
        characterList.stream().sorted().forEach(v -> System.out.print(v + " "));
        System.out.println();
        //descending
        characterList.stream().sorted(Comparator.reverseOrder()).forEach(v -> System.out.print(v + " "));
        System.out.println();
        //removed duplicated
        characterList.stream().sorted().distinct().forEach(v -> System.out.print(v + " "));



    }

}
