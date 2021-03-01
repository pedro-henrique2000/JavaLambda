package conteudo;

import java.util.*;
import java.util.stream.Collectors;

public class ProcessingPosts {

    public static void main(String[] args) throws Exception {
        Post[] posts = {
                new Post("Java 8", "Pedro", BlogType.ARTICLE, 1),
                new Post("Java 11", "Henrique", BlogType.NEWS, 10),
                new Post("Java 12", "Henrique", BlogType.NEWS, 5),
                new Post("How to create a API", "Joao", BlogType.ARTICLE, 15),
                new Post("Java news", "Pedro", BlogType.ARTICLE, 10)
        };

        List<Post> list = Arrays.asList(posts);

        //simple column
        Map<BlogType, List<Post>> simpleColumn = list.stream()
                .collect(Collectors.groupingBy(Post::getType));

        simpleColumn.forEach((key, value) -> {
            System.out.printf("%n%s: ", key.name());
            value.forEach(v -> System.out.print(v.getTitle() + " - "));
        });

        //complex column
        Map<Tuple, List<Post>> complexColumn = list.stream()
                .collect(Collectors.groupingBy(p -> new Tuple(p.getAuthor(), p.getType())));

        System.out.println();

        complexColumn.forEach((k, v) -> {
            System.out.printf("%n%s - %s: ", k.getAuthor(), k.getType().name());
            v.forEach(value -> System.out.print(value.getTitle() + "_"));
        });

        //average
        System.out.println("\nAverage: \n");
        Map<BlogType, Double> averagePerType =
                list.stream().collect(Collectors.groupingBy(Post::getType, Collectors.averagingDouble(Post::getLikes)));

        averagePerType.forEach((k, v) -> {
            System.out.printf("%s:%.1f%n", k.name(), v);
        });

        //sum
        System.out.println("\nSum:\n");
        Map<BlogType, Integer> sumPerType =
                list.stream().collect(Collectors.groupingBy(Post::getType, Collectors.summingInt(Post::getLikes)));

        sumPerType.forEach((k, v) -> {
            System.out.printf("%s:%d%n", k.name(), v);
        });

        //max like per type
        System.out.println("\nMax");
        Map<BlogType, Optional<Post>> maxLikePerType = list.stream().collect(Collectors.groupingBy(Post::getType,
                Collectors.maxBy(Comparator.comparing(Post::getLikes))
                ));

        maxLikePerType.forEach((v,k) -> {
                System.out.printf("%s : %d%n", v.name(), k.map(Post::getLikes).orElse(0));
        });

        //min like per type
        System.out.println("\nMin");
        Map<BlogType, Optional<Post>> minLikePerType = list.stream().collect(Collectors.groupingBy(Post::getType,
                Collectors.minBy(Comparator.comparing(Post::getLikes))
        ));

        minLikePerType.forEach((v,k) -> {
            System.out.printf("%s : %d%n", v.name(), k.map(Post::getLikes).orElse(0));
        });

        System.out.println("\nSummary\n");
        Map<BlogType, IntSummaryStatistics> summaryStatisticsMap =
                list.stream().collect(Collectors.groupingBy(Post::getType, Collectors.summarizingInt(Post::getLikes)));

        summaryStatisticsMap.forEach((k, v) -> System.out.printf("%s %s%n", k.name(), v));


    }

}
