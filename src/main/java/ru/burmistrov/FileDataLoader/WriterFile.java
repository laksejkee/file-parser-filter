package ru.burmistrov.FileDataLoader;

import lombok.RequiredArgsConstructor;
import org.apache.commons.cli.CommandLine;
import ru.burmistrov.Options.ValidateOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class WriterFile {
    private final ValidateOptions appOptions;

    public Map<String, Path> writeResultsToFile(CommandLine cmd, List<String> strings, List<String> floats, List<String> longs) {
        Map<String, Path> fileWriteMode = new HashMap<>();
        StandardOpenOption[] writeOptions = cmd.hasOption('a')
                ? new StandardOpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.APPEND}
                : new StandardOpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING};
        try {
            if (!longs.isEmpty()) {
                Path fileLongs = Files.write(appOptions.outputDir().resolve(appOptions.prefix().isEmpty() ? "longs.txt" : appOptions.prefix() + "longs.txt"),
                        longs, writeOptions);
                fileWriteMode.put("fileLongs", fileLongs);
            } else {
                System.err.println(" Файл longs.txt не был создан, т.к. не было найдено данных типа Long");
            }
            if (!floats.isEmpty()) {
                Path fileFloats = Files.write(appOptions.outputDir().resolve(appOptions.prefix().isEmpty() ? "floats.txt" : appOptions.prefix() + "floats.txt"),
                        floats, writeOptions);
                fileWriteMode.put("fileFloats", fileFloats);
            } else {
                System.err.println(" Файл floats.txt не был создан, т.к. не было найдено данных типа float");
            }
            if (!strings.isEmpty()) {
                Path fileStrings = Files.write(appOptions.outputDir().resolve(appOptions.prefix().isEmpty() ? "strings.txt" : appOptions.prefix() + "strings.txt"),
                        strings, writeOptions);
                fileWriteMode.put("fileStrings", fileStrings);
            } else {
                System.err.println(" Файл strings.txt не был создан, т.к. не было найдено данных типа String");
            }
        } catch (IOException e) {
            System.err.println(" ошибка записи файлов: " + e.getMessage());
        }
        return fileWriteMode;
    }

    public static WriterFile create(CommandLine cmd) {
        return new WriterFile(ValidateOptions.OptionsValue(cmd));
    }
}
