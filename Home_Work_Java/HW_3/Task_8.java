// Реализовать алгоритм сортировки слиянием.
package Home_Work_Java.HW_3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Task_8 {
// сортировка слиянием
    public static byte[] mergeSortTwoArrays(byte[] arrayA, byte[] arrayB) {
        byte[] arrayC = new byte[arrayA.length + arrayB.length];
        byte a = 0, b = 0;
        for (byte i = 0; i < arrayC.length; i++) {
            if (a >= arrayA.length) {
                arrayC[i] = arrayB[b];
                b++;
            } else if (b >= arrayB.length) {
                arrayC[i] = arrayA[a];
                a++;
            } else if (arrayA[a] < arrayB[b]) {
                arrayC[i] = arrayA[a];
                a++;
            } else {
                arrayC[i] = arrayB[b];
                b++;
            }
        }
        return arrayC;
    }
    public static byte[] mergeSort(List<byte[]> listArrays) {
        if (listArrays.size() < 2) return listArrays.get(0);
        byte[] arr = listArrays.get(0);
// проход по всему списку массивов, сортировка и слияние
        for (int i = 1; i < listArrays.size(); i++) {
            arr = mergeSortTwoArrays(arr, listArrays.get(i));
        }
        return arr;
    }
// разбивка массива на список при помощи рекурсии (длина массивов 1 и 2, сортировка и запись массивов длиной 2)
    public static List<byte[]> splitArray(byte[] array) {
// подсчет массивов длиной 1 и 2 при помощи списка
        List<byte[]> listArrays = new ArrayList<>();
// добавление массива длиной 1 в список, выход из рекурсии
        if (array.length == 1) {
            listArrays.add(array);
            return listArrays;
        } else if (array.length == 2) {
// сортировка массива длиной 2, выход из рекурсии
            if (array[0] > array[1]) {
                byte temp = array[0];
                array[0] = array[1];
                array[1] = temp;
            }
// добавление сортированного массив в список
            listArrays.add(array);
            return listArrays;
        } else {
// деление массива на 2 части
            int mid = array.length / 2;
            byte[] arrLeft = new byte[mid];
            System.arraycopy(array, 0, arrLeft, 0, mid);
            byte[] arrRight = new byte[array.length - mid];
            System.arraycopy(array, mid, arrRight, 0, array.length - mid);
// добавление в список частей массива при помощи рекурсии
            listArrays.addAll(splitArray(arrLeft));
            listArrays.addAll(splitArray(arrRight));
            return listArrays;
        }
    }
    public static void main(String[] args) {
// генерация массива случайных чисел (byte)
        byte[] randomArray = new byte[20];
        for (byte i = 0; i < randomArray.length; i++) {
            randomArray[i] = (byte) (Math.random() * Byte.MAX_VALUE);
        }
        System.out.printf("Исходный массив %s\n", Arrays.toString(randomArray));
// разбивка исходный массив на массивы длиной 2 и 1
        List<byte[]> listArrays = splitArray(randomArray);
        System.out.print("Массивы после разделения:");
        for (byte[] arr : listArrays) {
            System.out.printf(" %s ", Arrays.toString(arr));
        }
        System.out.println();
        System.out.printf("Сортированный массив %s\n", Arrays.toString(mergeSort(listArrays)));
    }
}