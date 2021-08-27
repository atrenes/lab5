package commands;

/**
 * Класс команды, которая выводит справку по всем командам
 */
public class Help extends Command{
    public static void execute(){
        System.out.println("info: вывести в стандартный поток вывода информацию о коллекции");
        System.out.println("show: вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println("add: добавить новый элемент в коллекцию");
        System.out.println("update <id>: обновить значение элемента коллекции, id которого равен заданному");
        System.out.println("remove_by_id <id>: удалить элемент из коллекции по его id");
        System.out.println("clear: очистить коллекцию");
        System.out.println("save: сохранить коллекцию в файл");
        System.out.println("execute_script <file name>: считать и исполнить скрипт из указанного файла");
        System.out.println("exit: завершить программу (без сохранения в файл)");
        System.out.println("remove_first: удалить первый элемент из коллекции");
        System.out.println("remove_greater <id>: удалить из коллекции все элементы, превышающие заданный");
        System.out.println("remove_lower <id>: удалить из коллекции все элементы, меньшие, чем заданный");
        System.out.println("filter_contains_name <name>: вывести элементы, значение поля name которых содержит заданную подстроку");
        System.out.println("print_descending: вывести элементы коллекции в порядке убывания");
        System.out.println("print_field_descending_establishment_date: вывести значения поля establishmentDate всех элементов в порядке убывания\n");
    }
}
