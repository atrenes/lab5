package commands;

import elements.MusicBand;

import java.util.LinkedList;

/**
 * Класс для команды show
 */
public class Show extends Command{
    public static void execute(LinkedList<MusicBand> linkedList) {
        if (linkedList.size() == 0) {
            System.out.println("Коллекция пуста");
        }
        MusicBand[] array = linkedList.toArray(new MusicBand[0]);
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println("id: " + array[i].getId());
            System.out.println("name: " + array[i].getName());
            System.out.println("x: " + array[i].getCoordinates().getX());
            System.out.println("y: " + array[i].getCoordinates().getY());
            System.out.println("creation date: " + array[i].getCreationDate());
            System.out.println("number of participants: " + array[i].getNumberOfParticipants());
            System.out.println("description: " + array[i].getDescription());
            System.out.println("establishment date: " + array[i].getEstablishmentDate());
            System.out.println("genre: " + array[i].getGenre());
            System.out.println("\tfront man name: " + array[i].getFrontMan().getName());
            System.out.println("\tfront man height: " + array[i].getFrontMan().getHeight());
            System.out.println("\tfront man passport id: " + array[i].getFrontMan().getPassportID());
            System.out.println("\tfront man hair color: " + array[i].getFrontMan().getHairColor());
            System.out.println("\tfront man nationality: " + array[i].getFrontMan().getNationality());
            System.out.println();
        }
    }
}
