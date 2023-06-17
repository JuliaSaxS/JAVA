/* Дана json-строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика. */

package Home_Work_Java;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task_7 {
    public static void main(String[] args) {
        String jsonString = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        String fileName = "json_string.json";
        String fileInfo = "info.txt";
        saveFile(jsonString, fileName, false);
        StringBuilder sbJson = loadFile(fileName);
        String[] persons = sbJson.toString().split("},\\{");
        for (String person : persons) {
            person = person.replace("\"", "");
            if (person.contains("[")) {
                person = person.replace("[", "");
            }
            if (person.contains("]")) {
                person = person.replace("]", "");
            }
            if (person.contains("{")) {
                person = person.replace("{", "");
            }
            if (person.contains("}")) {
                person = person.replace("}", "");
            }
            String[] records = person.split(",");
            StringBuilder noteFromJournal = getNote(records);
            System.out.println(noteFromJournal);
            noteFromJournal.append("\n");
            saveFile(noteFromJournal.toString(), fileInfo, true);
        }
    }
    public static StringBuilder getNote(String[] records) {
        StringBuilder noteFromJournal = new StringBuilder();
        for (String record : records) {
            String[] elements = record.split(":");
            switch (elements[0]) {
                case "фамилия" -> {
                    noteFromJournal.append("Студент ");
                    noteFromJournal.append(elements[1]);
                }
                case "оценка" -> {
                    noteFromJournal.append(" получил ");
                    noteFromJournal.append(elements[1]);
                }
                case "предмет" -> {
                    noteFromJournal.append(" по предмету ");
                    noteFromJournal.append(elements[1]);
                    noteFromJournal.append(".");
                }
            }
        }
        return noteFromJournal;
    }
    public static void saveFile(String content, String fileName, boolean addRec) {
        try (FileWriter fw = new FileWriter(fileName, addRec)) {
            fw.write(content);
            fw.flush();
        } 
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static StringBuilder loadFile(String fileName) {
        StringBuilder fileContent = new StringBuilder();
        try (FileReader fr = new FileReader(fileName)) {
            int symbol;
            while ((symbol = fr.read()) != -1) {
                fileContent.append((char) symbol);
            }
        } 
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return fileContent;
    }
}

