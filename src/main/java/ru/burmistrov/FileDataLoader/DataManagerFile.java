package ru.burmistrov.FileDataLoader;

import lombok.RequiredArgsConstructor;
import org.apache.commons.cli.CommandLine;
import ru.burmistrov.statistics.StatisticFactory;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class DataManagerFile {
    private final WriterFile writerFile;
    private final List<String> strings = new ArrayList<>();
    private final List<String> floats = new ArrayList<>();
    private final List<String> longs = new ArrayList<>();

    public void parseAndWriteData(CommandLine cmd, List<String> allLines) {
        Parser.parseFile(allLines, strings, floats, longs);
        Map<String, Path> pathCreatedFiles = writerFile.writeResultsToFile(cmd, strings, floats, longs);
        StatisticFactory.createStatistic(cmd)
                .ifPresent(stat -> stat.wrightStatistics(pathCreatedFiles));
    }
}

