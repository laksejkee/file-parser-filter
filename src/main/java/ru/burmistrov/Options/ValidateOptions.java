package ru.burmistrov.Options;

import org.apache.commons.cli.CommandLine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public record ValidateOptions(Path outputDir, String prefix) {


    public static ValidateOptions OptionsValue(CommandLine cmd) {
        Path outputDir;
        try {
            outputDir = cmd.hasOption('o') ? Files.createDirectories(Path.of(cmd.getOptionValue('o'))) : Path.of(System.getProperty("user.dir"));
        } catch (IOException e) {
            throw new IllegalArgumentException("Не удалось создать директорию: " + cmd.getOptionValue('o'), e);
        }

        String prefix = cmd.hasOption('p')
                ? cmd.getOptionValue('p')
                : "";

        return new ValidateOptions(outputDir, prefix);
    }
}
