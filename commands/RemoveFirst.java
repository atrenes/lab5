package commands;

import elements.MusicBand;

import java.util.LinkedList;

/**
 * Класс для команды remove_first
 */
public class RemoveFirst extends Command{
    public static void execute(LinkedList<MusicBand> linkedList) {
        if (!linkedList.isEmpty()) {
            linkedList.removeFirst();
            System.out.println("Первый элемент удален");
        } else {
            System.out.println("Коллекция пуста");
        }
    }
}
