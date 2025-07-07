package ru.burmistrov.statistics;

import org.apache.commons.cli.CommandLine;

import java.util.Optional;

public class StatisticFactory {
    public static Optional<Statistic> createStatistic(CommandLine cmd) {
        if (cmd.hasOption('f')) {
            return Optional.of(new CompositeFullStatistic(
                    new FullStatisticNumbers(),
                    new FullStatisticStrings()
            ));
        } else if (cmd.hasOption('s')) {
            return Optional.of(new ShortStatistics());
        }
        return Optional.empty();
    }
}
