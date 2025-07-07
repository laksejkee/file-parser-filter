package ru.burmistrov.FileDataLoader;

import lombok.RequiredArgsConstructor;
import org.apache.commons.cli.CommandLine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class ReaderFile {
    private final DataManagerFile dataManagerFile;

    public void processFiles(CommandLine cmd) {
        String[] file = cmd.getArgs();
        List<String> allLines = Stream.of(file)
                .map(Paths::get)
                .flatMap(path -> {
                    if (Files.exists(path))
                        try {
                            return Files.readAllLines(path).stream();
                        } catch (IOException e) {
                            System.err.println("Ошибка чтения файла " + path + e.getMessage());
                            return Stream.empty();
                        }
                    else {
                        System.err.println("Файл не найден: " + path);
                        return Stream.empty();
                    }
                })
                .toList();
        dataManagerFile.parseAndWriteData(cmd, allLines);
    }
}

