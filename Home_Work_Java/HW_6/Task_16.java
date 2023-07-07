/* Подумать над структурой класса Ноутбук(или Единорогов) для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Переопределить toString, equals и hashCode(как на семинаре).
Вывести на печать экземпляры класса, сравнить пару экземпляров и найти один экземпляр в наборе.

Задание со звездочкой:
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям. */
package Home_Work_Java.HW_6;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class Task_16 {
    public static void main(String[] args) {
        Notebook notebook1 = new Notebook("Asus", "4", "1000", "Windows", "grey");
        Notebook notebook2 = new Notebook("Asus", "4", "1000", "Lunex", "black");
        Notebook notebook3 = new Notebook("Asus", "4", "2000", "Windows", "black");
        Notebook notebook4 = new Notebook("Asus", "16", "1000", "Windows", "grey");
        Notebook notebook5 = new Notebook("Huawei", "8", "1000", "Windows", "black");
        Set<Notebook> notebooks = new HashSet<>(List.of(notebook1, notebook2,
              notebook3, notebook4, notebook5));
        Map<String, String> sel = selectCriteria();
        sort(sel, notebooks);
     }
     public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        return scan;
     }
     public static Map<String, String> selectCriteria() {
        Map<String, String> resultCriterias = new HashMap<>();
        while (true) {
           System.out.println("Вы хотите выбрать критерий? Если да введите 'y', если нет введите 'n'");
           String question = scanner();
           if (question.equals("n")) {
              break;
           } else { 
              System.out.println(
                    "Введите данные для поиска: \n 1 - Название \n 2 - ОЗУ \n 3 - Объем ЖД \n 4 - Операционная система \n 5 - Цвет");
              String key = scanner();
              System.out.println("Введите значение выбранных данных: ");
              String value = scanner();  
              resultCriterias.put(key, value);
           }
        }
        System.out.println(resultCriterias);
        return resultCriterias;
     } 
     public static void sort(Map<String, String> criterias, Set<Notebook> notebooks) { 
        Set<Notebook> temp = new HashSet<>(notebooks);
        for (Notebook notebook : notebooks) { 
           for (Object pair : criterias.keySet()) { 
              if (pair.equals("1") && !notebook.getName().equals(criterias.get(pair))) {
                 temp.remove(notebook);
              }
              for (Object pair1 : criterias.keySet()) {  
                 if (pair1.equals("2") && !notebook.getRam().equals(criterias.get(pair1))) {
                    temp.remove(notebook);
                 }
                 for (Object pair2 : criterias.keySet()) { 
                    if (pair2.equals("3") && !notebook.getHardDisk().equals(criterias.get(pair2))) {
                       temp.remove(notebook);  
                    }
                    for (Object pair3 : criterias.keySet()) {  
                       if (pair3.equals("4") && !notebook.getOperatingSystem().equals(criterias.get(pair3))) {
                          temp.remove(notebook);  
                       }
                       for (Object pair4 : criterias.keySet()) {  
                          if (pair4.equals("5") && !notebook.getColour().equals(criterias.get(pair4))) {
                             temp.remove(notebook); 
                          }
                       }
                    }
                 }
              }
           }
  
        }
        if (temp.isEmpty()) {
           System.out.println("По введенным данным ничего не найдено.");
        } else {
           System.out.println("Вот что нашлось: \n" + temp.toString());
        }
     }
}
