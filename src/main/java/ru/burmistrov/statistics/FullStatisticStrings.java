package ru.burmistrov.statistics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.stream.Stream;

public class FullStatisticStrings implements Statistic {
    @Override
    public void wrightStatistics(Map<String, Path> createdFiles) {
        createdFiles.forEach((type, filePaths) -> {
            if (type.equals("fileStrings")) {
                try (Stream<String> lines = Files.lines(filePaths)) {
                    IntSummaryStatistics stats = lines
                            .mapToInt(String::length)
                            .summaryStatistics();
                    System.out.println("\nФайл " + filePaths.getFileName());
                    System.out.println("Общее количество строк: " + stats.getCount());
                    System.out.println("Минимальная длина строки: " + stats.getMin());
                    System.out.println("Максимальная длина строки: " + stats.getMax());
                } catch (IOException e) {
                    System.err.println("Ошибка чтения файла " + filePaths + ": " + e.getMessage());
                }
            }
        });
    }
}
