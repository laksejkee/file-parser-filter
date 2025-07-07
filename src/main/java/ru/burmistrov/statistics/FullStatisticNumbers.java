package ru.burmistrov.statistics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.DoubleSummaryStatistics;
import java.util.Map;
import java.util.stream.Stream;

public class FullStatisticNumbers implements Statistic {
    @Override
    public void wrightStatistics(Map<String, Path> createdFiles) {
        createdFiles.forEach((type, filePaths) -> {
            if (type.equals("fileLongs") || type.equals("fileFloats")) {
                try (Stream<String> lines = Files.lines(filePaths)) {
                    DoubleSummaryStatistics stats = lines
                            .mapToDouble(Double::parseDouble)
                            .summaryStatistics();
                    System.out.println("\nФайл " + filePaths.getFileName());
                    System.out.println("Количество: " + stats.getCount());
                    System.out.println("Минимальное значение: " + stats.getMin());
                    System.out.println("Максимальное значение: " + stats.getMax());
                    System.out.println("Сумма: " + stats.getSum());
                    System.out.println("Среднее значение: " + stats.getAverage());
                } catch (IOException e) {
                    System.err.println("Ошибка чтения файла " + filePaths + ": " + e.getMessage());
                }
            }
        });
    }
}

