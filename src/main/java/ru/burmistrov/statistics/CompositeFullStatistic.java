package ru.burmistrov.statistics;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CompositeFullStatistic implements Statistic {
    private final List<Statistic> statistics;

    public CompositeFullStatistic(Statistic... statistics) {
        this.statistics = Arrays.asList(statistics);
    }

    @Override
    public void wrightStatistics(Map<String, Path> createdFiles) {
        statistics.forEach(stat -> stat.wrightStatistics(createdFiles));
    }
}
