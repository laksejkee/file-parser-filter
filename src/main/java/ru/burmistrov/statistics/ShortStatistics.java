package ru.burmistrov.statistics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Stream;

public class ShortStatistics implements Statistic {
    @Override
    public void wrightStatistics(Map<String, Path> pathCreatedFiles) {

        pathCreatedFiles.forEach((type, filePaths) -> {
            try (Stream<String> lines = Files.lines(filePaths)) {
                long count = lines.count();
                System.out.println("Количество элементов в файле " + filePaths.getFileName() + ": " + count);
            } catch (IOException e) {
                System.err.println("Ошибка чтения файла " + filePaths + ": " + e.getMessage());
            }
        });
    }
}
