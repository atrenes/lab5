package commands;

import additional.ListComparator;
import elements.MusicBand;

import java.util.LinkedList;

/**
 * Класс для команды remove_lower
 */
public class RemoveLower extends Command{
    public static void execute(LinkedList<MusicBand> linkedList, String line) {
        String[] fields;
        fields = line.split(" ");
        if (!linkedList.isEmpty()) {
            if (fields.length == 2) {
                try {
                    MusicBand[] bands = linkedList.toArray(new MusicBand[0]);
                    int id = Integer.parseInt(fields[1]);
                    int count = 0;
                    MusicBand musicBand = new MusicBand();
                    ListComparator comparator = new ListComparator();
                    boolean found = false;

                    for (int i = 0; i < bands.length; i++) {
                        if (id == bands[i].getId()) {
                            musicBand = bands[i];
                            found = true;
                        }
                    }

                    for (int i = 0; i < bands.length; i++) {
                        if (comparator.compare(musicBand, bands[i]) == -1) {
                            linkedList.remove(bands[i]);
                            count++;
                        }
                    }

                    if (found) {
                        if (count != 0) {
                            System.out.println("Удалено " + count + " элемент(а/ов)");
                        } else {
                            System.out.println("Не удалено ни одного элемента");
                        }
                    } else {
                        System.out.println("Элемент не найден");
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
}
