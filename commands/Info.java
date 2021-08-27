package commands;

import elements.MusicBand;

import java.time.LocalDate;
import java.util.LinkedList;

/**
 * Класс для команды info
 */
public class Info extends Command{
    public static void execute(LinkedList<MusicBand> linkedList, LocalDate time) {
        System.out.println("Тип коллекции: LinkedList");
        System.out.println("Дата создания: " + time);
        System.out.println("Количество элементов: " + linkedList.size());
        System.out.println();
    }
}
