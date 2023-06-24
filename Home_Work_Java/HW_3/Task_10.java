// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
package Home_Work_Java.HW_3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Task_10 {
    public static void main(String[] args) {
// Задан целочисленный список ArrayList
        List<Byte> listNumbers = new ArrayList<>();
        for (byte i = 0; i < 20; i++) {
            listNumbers.add((byte) (Math.random() * Byte.MAX_VALUE));
        }
// Найти минимальное, максимальное и среднее из этого списка
        System.out.printf("Произвольный целочисленный список: %s\n", listNumbers);

        System.out.printf("Минимальное число из списка: %d\n", Collections.min(listNumbers));
        System.out.printf("Максимальное число из списка: %d\n", Collections.max(listNumbers));
        double sum = 0;
        for (byte element : listNumbers) {
            sum += element;
        }
        System.out.printf("Среднее арифметическое чисел из списка: %.1f\n", sum / listNumbers.size());

    }
}
