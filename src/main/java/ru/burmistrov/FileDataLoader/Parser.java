package ru.burmistrov.FileDataLoader;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.List;

public class Parser {
    public static void parseFile(List<String> files, List<String> strings, List<String> floats, List<String> longs) {

        for (String file : files) {
            if (file.contains(".")) {
                floats.add(String.valueOf(NumberUtils.toFloat(file)));
            } else if (!NumberUtils.isParsable(file)) {
                strings.add(file);
            } else {
                longs.add(String.valueOf(NumberUtils.toLong(file)));
            }
        }
    }
}
