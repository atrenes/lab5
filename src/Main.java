import commands.Executor;
import additional.ListComparator;
import commands.SaveLoad;
import elements.MusicBand;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * Главный класс, запускающий работу программы
 * @author atrenes
 */
public class Main {
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        //String file = "C:\\Users\\User\\Desktop\\Labing55555\\src\\data.json";
        System.out.print("Имя файла: ");
        String file = in.nextLine();
        LinkedList<MusicBand> linkedList = new LinkedList<MusicBand>();
        SaveLoad.load(linkedList, file);

        ListComparator comparator = new ListComparator();
        linkedList.sort(comparator); //сортировка по умолчанию (от большего к меньшему)

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        LocalDate localDate = LocalDate.now();
        while (true) {
            String line;
            String[] field;
            String command;

            System.out.print("> ");
            line = in.nextLine();
            field = line.split(" ");
            command = field[0];

            Executor.execute(linkedList, line, command, file, zonedDateTime, localDate);
        }
    }
}
