/* Реализуйте структуру телефонной книги с помощью HashMap. 
Программа также должна учитывать, что во входной структуре будут повторяющиеся имена 
с разными телефонами, их необходимо считать, как одного человека с разными телефонами. 
Вывод должен быть отсортирован по убыванию числа телефонов.(можно выводить без сортировки, 
но обязательно в отдельном методе) 
*/
package Home_Work_Java.HW_5;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
public class Task_14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, String> book = new LinkedHashMap<>();
        menu(book, input);
        input.close();
    }
    public static void addContact(Map<String, String> book, Scanner input) {
        String name;
        while (true) {
            System.out.println("Введите ФИО");
            name = input.nextLine();
            System.out.println("Введите номер телефона");
            book.compute(name, (key, value) -> value != null ? value + ", " + input.nextLine() : input.nextLine());
            System.out.println("Добавить еще контакт? пустая строка -> нет");
            if (input.nextLine().length() == 0){
                menu(book, input);
                break;
            }
        }
    }
    public static void menu(Map<String, String> book, Scanner input) {
        System.out.println("1: Добавить контакт \n2: Показать список \n3: Выход");       
        switch (Integer.parseInt(input.nextLine())) {
            case 1:   
                addContact(book, input);
                break;       
            case 2:   
                printBook(book, input);
                break;
            case 3:
                System.exit(0);
        }
    }
    public static void printBook(Map<String, String> book, Scanner input) {
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<String> phone = new ArrayList<String>();        
        for (String s: book.keySet()) name.add(s);
        for (String s: book.values()) phone.add(s);     
        for (int j = phone.size() - 1; j >= 1; j--) {
            for (int i = 0; i < j; i++) {
                if (phone.get(i).length() < phone.get(i + 1).length()) {
                    String tmp = phone.get(i);      
                    phone.set(i, phone.get(i + 1));       
                    phone.set(i + 1, tmp); 

                    tmp = name.get(i);      
                    name.set(i, name.get(i + 1));       
                    name.set(i + 1, tmp); 
                }
            }
        }     
        for (int i = 0; i < name.size(); i++) {
            System.out.println(name.get(i) + " : " + phone.get(i));
        }
        menu(book, input);
    }
}