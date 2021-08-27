package commands;

import elements.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Класс для команды add
 */
public class Add extends Command {
    public static MusicBand execute(LinkedList<MusicBand> linkedList){
        Scanner in = new Scanner(System.in);
        MusicBand musicBand = new MusicBand();
        Coordinates coordinates = new Coordinates();
        String line;

        if (linkedList.isEmpty()) {
            musicBand.setId(0);
        } else {
            musicBand.setId(linkedList.getLast().getId()+1);
        }

        while (true) {
            System.out.print("name: ");
            line = in.nextLine();
            if (!line.equals("")) {
                musicBand.setName(line);
                break;
            } else {
                System.out.println("Поле не может быть пустым");
            }
        }

        while (true) {
            System.out.print("x: ");
            line = in.nextLine();
            if (line.equals("")) {
                System.out.println("Поле не может быть пустым");
                continue;
            }
            try {
                coordinates.setX(Long.parseLong(line));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат числа");
            }
        }
        while (true) {
            System.out.print("y: ");
            line = in.nextLine();
            if (line.equals("")) {
                System.out.println("Поле не может быть пустым");
                continue;
            }
            try {
                coordinates.setY(Integer.parseInt(line));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат числа");
            }
        }
        musicBand.setCoordinates(coordinates);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        musicBand.setCreationDate(zonedDateTime);

        while (true) {
            System.out.print("number of participants: ");
            line = in.nextLine();
            if (line.equals("")) {
                System.out.println("Поле не может быть пустым");
                continue;
            }
            try {
                Long number = Long.parseLong(line);
                if (number > 0) {
                    musicBand.setNumberOfParticipants(number);
                    break;
                } else {
                    System.out.println("Число должно быть больше нуля");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат числа");
            }
        }

        System.out.print("description: ");
        line = in.nextLine();
        if (line.equals("")) {
            musicBand.setDescription(null);
        } else {
            musicBand.setDescription(line);
        }

        LocalDate localDate = LocalDate.now();
        musicBand.setEstablishmentDate(localDate);

        boolean flag = true;
        while (flag) {
            System.out.print("genre (HIP_HOP, BLUES, POP, null (пустая строка)): ");
            line = in.nextLine();
            switch (line) {
                case ("HIP_HOP"):
                    musicBand.setGenre(MusicGenre.HIP_HOP);
                    flag = false;
                    break;
                case ("BLUES"):
                    musicBand.setGenre(MusicGenre.BLUES);
                    flag = false;
                    break;
                case ("POP"):
                    musicBand.setGenre(MusicGenre.POP);
                    flag = false;
                    break;
                case (""):
                    musicBand.setGenre(null);
                    flag = false;
                    break;
                default:
                    System.out.println("Введите один из предложенных типов");
                    break;
            }
        }

        Person person = new Person();
        while (true) {
            System.out.print("person name: ");
            line = in.nextLine();
            if (!line.equals("")) {
                person.setName(line);
                break;
            } else {
                System.out.println("Поле не может быть пустым");
            }
        }

        while (true) {
            System.out.print("person height: ");
            line = in.nextLine();
            if (line.equals("")) {
                person.setHeight(null);
                break;
            } else {
                try {
                    Long height = Long.parseLong(line);
                    if (height > 0) {
                        person.setHeight(height);
                        break;
                    } else {
                        System.out.println("Число должно быть больше нуля");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат числа");
                }
            }
        }

        while (true) {
            System.out.print("person passport id: ");
            line = in.nextLine();
            if (line.equals("")) {
                System.out.println("Поле не может быть пустым");
            } else {
                person.setPassportID(line);
                break;
            }
        }

        flag = true;
        while (flag) {
            System.out.print("hair color (GREEN, BLUE, WHITE): ");
            line = in.nextLine();
            switch (line) {
                case ("GREEN"):
                    person.setHairColor(Color.GREEN);
                    flag = false;
                    break;
                case ("BLUE"):
                    person.setHairColor(Color.BLUE);
                    flag = false;
                    break;
                case ("WHITE"):
                    person.setHairColor(Color.WHITE);
                    flag = false;
                    break;
                default:
                    System.out.println("Введите один из предложенных типов");
                    break;
            }
        }

        flag = true;
        while (flag) {
            System.out.print("country (USA, SPAIN, ITALY, SOUTH_KOREA, NORTH_KOREA): ");
            line = in.nextLine();
            switch (line) {
                case ("USA"):
                    person.setNationality(Country.USA);
                    flag = false;
                    break;
                case ("SPAIN"):
                    person.setNationality(Country.SPAIN);
                    flag = false;
                    break;
                case ("ITALY"):
                    person.setNationality(Country.ITALY);
                    flag = false;
                    break;
                case ("SOUTH_KOREA"):
                    person.setNationality(Country.SOUTH_KOREA);
                    flag = false;
                    break;
                case ("NORTH_KOREA"):
                    person.setNationality(Country.NORTH_KOREA);
                    flag = false;
                    break;
                default:
                    System.out.println("Введите один из предложенных типов");
                    break;
            }
        }

        musicBand.setFrontMan(person);

        return musicBand;
    }
}
