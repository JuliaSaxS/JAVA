// Пусть дан произвольный список целых чисел, удалить из него четные числа
package Home_Work_Java.HW_3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Task_9 {
    public static void main(String[] args) {
        List<Byte> listNumbers = new ArrayList<>();
        for (byte i = 0; i < 20; i++) {
            listNumbers.add((byte) (Math.random() * Byte.MAX_VALUE));
        }
        System.out.printf("Произвольный список чисел: %s\n", listNumbers);
        Iterator<Byte> listNumIterator = listNumbers.iterator();
// перебор всех элементов списка
        while (listNumIterator.hasNext()) {
            byte element = listNumIterator.next();
// удаление четных чисел из списка
            if (element % 2 == 0) {
                listNumIterator.remove();
            }
        }
        System.out.printf("Список без чётных чисел: %s\n", listNumbers);
    }
}
