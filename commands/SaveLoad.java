package commands;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import elements.MusicBand;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Класс для чтения и записи json-файла
 */
public class SaveLoad extends Command{
    private static Gson builder() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(ZonedDateTime.class, new TypeAdapter<ZonedDateTime>() {
                    @Override
                    public void write(JsonWriter out, ZonedDateTime value) throws IOException {
                        out.value(value.toString());
                    }

                    @Override
                    public ZonedDateTime read(JsonReader in) throws IOException {
                        return ZonedDateTime.parse(in.nextString());
                    }
                })
                .registerTypeAdapter(LocalDate.class, new TypeAdapter<LocalDate>() {
                    @Override
                    public void write(JsonWriter jsonWriter, LocalDate localDate) throws IOException {
                        jsonWriter.value(localDate.toString());
                    }

                    @Override
                    public LocalDate read(JsonReader jsonReader) throws IOException {
                        return LocalDate.parse(jsonReader.nextString());
                    }
                })
                .enableComplexMapKeySerialization()
                .create();
        return gson;
    }

    public static void save(LinkedList<MusicBand> linkedList, String file) {
        try {
            Gson gson = builder();
            PrintWriter pw = new PrintWriter(file);
            pw.write(gson.toJson(linkedList));
            pw.close();
            System.out.println("Коллекция сохранена\n");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }

    public static void load(LinkedList<MusicBand> linkedList, String file) {
        String content = new String();
        try {
            Scanner scanner = new Scanner(new File(file));
            while (scanner.hasNextLine()) {
                content = content + scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

        TreeSet<Long> idSet = new TreeSet<>(); // Отдельная коллекция для проверки уникальности id

        Gson gson = builder();
        if (content.length() != 0) {
            for (MusicBand obj : gson.fromJson(content, MusicBand[].class)) {
                linkedList.add(obj);
                if (idSet.contains(linkedList.getLast().getId())) {
                    System.out.println("Ошибка: id не уникальны");
                    System.exit(0);
                } else {
                    idSet.add(linkedList.getLast().getId());
                }
            }
        }
    }
}
