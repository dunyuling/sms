package sms.runtime;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CommandRunner commandRunner = new CommandRunner();
        Scanner scanner = new Scanner(System.in);
        String line;

        while( !Objects.equals((line = scanner.nextLine()), "quit") ) {
            String[] inputs = line.split("\\W");
            commandRunner.run(inputs[0], inputs[1],
                    Arrays.asList(Arrays.copyOfRange(inputs ,2, inputs.length)));
        }

        /*Path path = Paths.get("","/home/liux/IdeaProjects/sms/data/Student/1.bin");
        try {
            Files.createDirectories(path.getParent());
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

//        System.out.println("I hen ma nao");
    }


}
