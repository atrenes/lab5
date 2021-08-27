package commands;

import elements.MusicBand;

import java.util.LinkedList;

/**
 * Класс для команды filter_contains_name
 */
public class FilterContainsName extends Command{
    private static void show(MusicBand musicBand) {
        System.out.println("id: " + musicBand.getId());
        System.out.println("name: " + musicBand.getName());
        System.out.println("x: " + musicBand.getCoordinates().getX());
        System.out.println("y: " + musicBand.getCoordinates().getY());
        System.out.println("creation date: " + musicBand.getCreationDate());
        System.out.println("number of participants: " + musicBand.getNumberOfParticipants());
        System.out.println("description: " + musicBand.getDescription());
        System.out.println("establishment date: " + musicBand.getEstablishmentDate());
        System.out.println("genre: " + musicBand.getGenre());
        System.out.println("\tfront man name: " + musicBand.getFrontMan().getName());
        System.out.println("\tfront man height: " + musicBand.getFrontMan().getHeight());
        System.out.println("\tfront man passport id: " + musicBand.getFrontMan().getPassportID());
        System.out.println("\tfront man hair color: " + musicBand.getFrontMan().getHairColor());
        System.out.println("\tfront man nationality: " + musicBand.getFrontMan().getNationality());
        System.out.println();
    }

    public static void execute(LinkedList<MusicBand> linkedList, String line) {
        if (!linkedList.isEmpty()) {
            String string;
            string = line.replaceFirst("filter_contains_name ", "");
            MusicBand[] bands = linkedList.toArray(new MusicBand[0]);
            boolean flag = false;

            for (int i = 0; i < bands.length; i++) {
                if (bands[i].getName().contains(string)) {
                    flag = true;
                    show(bands[i]);
                }
            }

            if (!flag) {
                System.out.println("Не найдено ни одного элемента");
            }
        } else {
            System.out.println("Коллекция пуста");
        }
    }
}
