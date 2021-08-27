package commands;

import elements.MusicBand;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Класс для команды execute_script
 */
public class ExecuteScript extends Command{
    public static void execute(String line, LinkedList<MusicBand> linkedList, String file, ZonedDateTime zonedDateTime, LocalDate localDate) {
        line = line.replace("execute_script ", "");
        File script = new File(line);
        String newLine;
        String newField[];
        String newCommand;
        try {
            Scanner scanner = new Scanner(script);
            while (scanner.hasNextLine()) {
                newLine = scanner.nextLine();
                if (newLine.equals("execute_script")) {
                    System.out.println("Команда execute_script не выполняется внутри скрипта");
                } else {
                    newField = newLine.split(" ");
                    newCommand = newField[0];

                    Executor.execute(linkedList, newLine, newCommand, file, zonedDateTime, localDate);
                }
            }
            scanner.close();
            System.out.println("Скрипт исполнен");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}
