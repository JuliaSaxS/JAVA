// Задача 1: Вычислить сумму чисел от 1 до n

package Home_Work_Java;
import java.util.Scanner;
public class Task_1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите число n: ");
        int i = iScanner.nextInt();
        System.out.printf("Сумма чисел равна %d\n", giveMeNumber(i));
        iScanner.close();
    }
    public static int giveMeNumber(int n) {
        return (n * (n + 1)) / 2;
    }    
}
