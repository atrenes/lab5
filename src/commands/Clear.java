package commands;

import elements.MusicBand;

import java.util.LinkedList;

/**
 * Класс для команды clear
 */
public class Clear extends Command{
    public static void execute(LinkedList<MusicBand> linkedList){
        if (!linkedList.isEmpty()) {
            linkedList.clear();
            System.out.println("Коллекция очищена\n");
        } else {
            System.out.println("Коллекция пуста");
        }
    }
}
