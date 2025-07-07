package ru.burmistrov.Options;

import org.apache.commons.cli.Options;

public class SettingOptions {
    public static Options createOptions() {
        Options options = new Options();
        options.addOption("p", "prefix", true, "Prefix for output filenames");
        options.addOption("o", "output", true, "Path to output file");
        options.addOption("a", "append", false, "Append to existing files");
        options.addOption("s", "short", false, "Show short statistics");
        options.addOption("f", "full", false, "Show full statistics");
        return options;
    }
}
