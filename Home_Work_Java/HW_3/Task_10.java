// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
package Home_Work_Java.HW_3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Task_10 {
    public static void main(String[] args) {
        List<Byte> listNumbers = new ArrayList<>();
        for (byte i = 0; i < 20; i++) {
            listNumbers.add((byte) (Math.random() * Byte.MAX_VALUE));
        }
        System.out.printf("Целочисленный список: %s\n", listNumbers);

        System.out.printf("Минимальное значение: %d\n", Collections.min(listNumbers));
        System.out.printf("Максимальное значение: %d\n", Collections.max(listNumbers));
        double sum = 0;
        for (byte element : listNumbers) {
            sum += element;
        }
        System.out.printf("Среднее значение: %.2f\n", sum / listNumbers.size());

    }
}
