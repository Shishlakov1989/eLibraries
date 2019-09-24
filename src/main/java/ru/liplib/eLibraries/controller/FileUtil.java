package ru.liplib.eLibraries.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    static void addAccounts(String filename) {
        List<String> strings = readFile(filename);

        if (strings == null) {

        }
    }

    private static List<String> readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            List<String> strings = new ArrayList<>();

            while (reader.ready()) {
                strings.add(reader.readLine());
            }

            System.out.println("Прочитано " + strings.size() + " строк");

            return strings;
        } catch (FileNotFoundException e1) {
            System.out.println("Не удалось найти файл");
        } catch (IOException e2) {
            System.out.println("Ошибка чтения файла");
        }

        return null;
    }
}
