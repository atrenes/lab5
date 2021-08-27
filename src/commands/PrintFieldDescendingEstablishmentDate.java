package commands;

import additional.ListComparator;
import elements.MusicBand;

import java.util.LinkedList;

/**
 * Класс для команды print_field_descending_establishment_date
 */
public class PrintFieldDescendingEstablishmentDate extends Command{
    public static void execute(LinkedList<MusicBand> linkedList) {
        ListComparator comparator = new ListComparator(){
            @Override
            public int compare(MusicBand o1, MusicBand o2) {
                if (o1.getEstablishmentDate().isBefore(o2.getEstablishmentDate())) {
                    return 1;
                } else if (o2.getEstablishmentDate().isBefore(o1.getEstablishmentDate())) {
                    return -1;
                } else return 0;
            }
        };
        ListComparator back = new ListComparator();
        if (!linkedList.isEmpty()) {
            linkedList.sort(comparator);
            MusicBand[] array = linkedList.toArray(new MusicBand[0]);
            for (int i = 0; i < linkedList.size(); i++) {
                System.out.println("id: " + array[i].getId());
                System.out.println("establishment date: " + array[i].getEstablishmentDate() + "\n");
            }
            linkedList.sort(back);
        } else {
            System.out.println("Коллекция пуста");
        }
    }
}
