package ru.burmistrov;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;
import ru.burmistrov.FileDataLoader.DataManagerFile;
import ru.burmistrov.FileDataLoader.ReaderFile;
import ru.burmistrov.FileDataLoader.WriterFile;
import ru.burmistrov.Options.SettingOptions;

public class Runner {
    public static void main(String[] args) {
        try {
            CommandLine cmd = new DefaultParser().parse(SettingOptions.createOptions(), args);

            WriterFile writerFile = WriterFile.create(cmd);
            DataManagerFile dataManager = new DataManagerFile(writerFile);
            ReaderFile readerFile = new ReaderFile(dataManager);

            readerFile.processFiles(cmd);
        } catch (ParseException e) {
            System.err.println("Ошибка парсинга аргументов: " + e.getMessage());
        }
    }
}




