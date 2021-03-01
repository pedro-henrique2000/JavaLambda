package conteudo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StreamOfLines {

    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("Text.txt")).forEach(System.out::println);
    }

}
