package additional;

import elements.MusicBand;

import java.util.Comparator;

/**
 * Класс для сравнения элементов коллекции по хеш-коду
 */
public class ListComparator implements Comparator<MusicBand>{
    public int compare(MusicBand o1, MusicBand o2) {
        if (o1.hashCode() < o2.hashCode()) {
            return 1;
        } else if (o1.hashCode() > o2.hashCode()) {
            return -1;
        } else return 0;
    }
}