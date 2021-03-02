package exercicios;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class DirectoryFiles {

    public static void main(String[] args) {
        Path dir = Paths.get("C:/Users/User/Downloads");
        Map<String, Integer> map = new HashMap<>();

        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir);



            for(Path path : directoryStream) {
                String location = path.getFileName().toString();
                String[] file = location.split("\\.");

                String endFile = file[file.length - 1];

                if(map.containsKey(endFile))
                    map.put(endFile, map.get(endFile) + 1);
                else
                    map.put(endFile, 1);

            }

        } catch(IOException e) {
            e.printStackTrace();
        }

        map.forEach((k, v) -> {
            System.out.printf("%s : %d%n", k, v);
        });


    }

}
