package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    public void readFile() {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/names.txt").getFile());
        //getResource -> parent not null?
        //a adres pliku np na pulpicie??

        try (Stream<String> fileLines = Files.lines(Paths.get("file/ttt.txt"))){

            // stream mial nie byc czyms nietrwalym?
            fileLines.forEach((System.out::println));

        } catch (IOException e) {

            System.out.println("blabla" + e);

        } finally {

            System.out.println("always");
        }

    }
}
