package ru.burmistrov.statistics;

import java.nio.file.Path;
import java.util.Map;

public interface Statistic {
    void wrightStatistics(Map<String, Path> createdFiles);
}
