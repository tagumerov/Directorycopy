import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String source;
        String destination;
        Path pathSource;
        Path pathDestination;
        try {
            System.out.println("Укажите копируемый каталог");
            source = reader.readLine();
            System.out.println("Укажите куда копировать каталог");
            destination = reader.readLine();
            pathSource = Paths.get(source);
            pathDestination = Paths.get(destination);
            reader.close();

            Files.walkFileTree(pathSource, new MyFileCopy(pathSource,pathDestination));
            System.out.println("файлы успешно скопированы");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

