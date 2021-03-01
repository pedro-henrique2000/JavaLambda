package conteudo;

import java.security.SecureRandom;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RandomIntStream {

    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();

        Map<Integer, Long> random = secureRandom.ints(6_000_000, 1, 3).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        random.forEach((value, key) ->{
            System.out.printf("%d : %d %n", key, value);
        });
    }
}
