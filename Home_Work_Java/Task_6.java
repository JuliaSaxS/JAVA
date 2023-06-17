/*  Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл. */ 

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task_6 {
public static void main(String[] args) throws IOException {
    Logger logger = Logger.getLogger(Task_6.class.getName());
    FileHandler fh = new FileHandler("log.txt", false);
    logger.addHandler(fh);
    SimpleFormatter sFormat = new SimpleFormatter();
    fh.setFormatter(sFormat);
    byte[] arr = new byte[10];
    StringBuilder sbArray = new StringBuilder();
        sbArray.append("Исходный массив: ");
        for (int i = 0; i < arr.length; i++) {
            //  Math.random() - случайное число double из промежутка [0,1)
            arr[i] = (byte) (Math.random() * 100);
            sbArray.append(arr[i]);
            sbArray.append(" ");
        }
        System.out.println(sbArray);
        logger.log(Level.WARNING, sbArray.toString());
        sbArray.delete(0, sbArray.length());
        sbArray.append("Сортированный массив: ");
        arr = BubbleSort(arr, logger);
        for (byte b : arr) {
            sbArray.append(b);
            sbArray.append(" ");
        }
        System.out.println(sbArray);
        logger.log(Level.WARNING, sbArray.toString());
    }
    public static byte[] BubbleSort(byte[] array, Logger logger) {
        StringBuilder sbArray = new StringBuilder();
        int iterCount = 0;
        boolean isSorted = false;
        byte temp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    isSorted = false;
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            iterCount++;
            sbArray.append("Массив после ");
            sbArray.append(iterCount);
            sbArray.append(" итерации: ");
            for (byte b : array) {
                sbArray.append(b);
                sbArray.append(" ");
            }
            logger.info(sbArray.toString());
            sbArray.delete(0, sbArray.length());
        }
        return array;
    }
}