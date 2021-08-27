package commands;

import elements.MusicBand;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.LinkedList;

/**
 * Класс для вызова всех команд
 */
public class Executor extends Command{
    public static void execute(LinkedList<MusicBand> linkedList,
                               String line,
                               String command,
                               String file,
                               ZonedDateTime zonedDateTime,
                               LocalDate localDate){
        switch (command) {
            case ("help"):
                Help.execute();
                break;
            case ("exit"):
                Exit.execute();
                break;
            case ("clear"):
                Clear.execute();
                break;
            case ("add"):
                linkedList.add(Add.execute(linkedList));
                System.out.println("Элемент добавлен в коллекцию\n");
                break;
            case ("info"):
                Info.execute(linkedList, localDate);
                break;
            case ("show"):
            case ("print_descending"):
                Show.execute(linkedList);
                break;
            case ("save"):
                SaveLoad.save(linkedList, file);
                break;
            case ("remove_by_id"):
                RemoveById.execute(linkedList, line);
                break;
            case ("remove_first"):
                RemoveFirst.execute(linkedList);
                break;
            case ("update_id"):
                UpdateId.execute(linkedList, line);
                break;
            case ("remove_greater"):
                RemoveGreater.execute(linkedList, line);
                break;
            case ("remove_lower"):
                RemoveLower.execute(linkedList, line);
                break;
            case ("print_field_descending_establishment_date"):
                PrintFieldDescendingEstablishmentDate.execute(linkedList);
                break;
            case ("filter_contains_name"):
                FilterContainsName.execute(linkedList, line);
                break;
            case ("execute_script"):
                ExecuteScript.execute(line, linkedList, file, zonedDateTime, localDate);
                break;
            default:
                System.out.println("Неизвестная команда. Для получения списка команд введите help\n");
                break;
        }
    }
}
