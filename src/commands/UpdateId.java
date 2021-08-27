package commands;

import elements.MusicBand;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Класс для команды update_id
 */
public class UpdateId extends Command{
    public static void execute(LinkedList<MusicBand> linkedList, String line) {
        String[] fields;
        fields = line.split(" ");
        if (!linkedList.isEmpty()) {
            if (fields.length == 2) {
                try {
                    boolean flag = false;
                    long id = Long.parseLong(fields[1]);
                    Iterator<MusicBand> iter = linkedList.iterator();
                    while (iter.hasNext()) {
                        if (iter.next().getId() == id) {
                            flag = true;
                            iter.remove();
                        }
                    }
                    if (!flag) {
                        System.out.println("Элемент не найден");
                    } else {
                        linkedList.add(changeId(Add.execute(linkedList), id));
                        System.out.println("Элемент с указанным id обновлен");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат id");
                }
            } else {
                System.out.println("Неверный формат команды");
            }
        } else {
            System.out.println("Коллекция пуста");
        }
    }

    private static MusicBand changeId(MusicBand musicBand, long id) {
        musicBand.setId(id);
        return musicBand;
    }
}
