// Задача 2: Вывести все простые числа от 1 до 1000

package Home_Work_Java;

public class Task_2 {
    public static void main(String[] args) {
        int n = 2;
        while(n <= 1000) {
            int k = 1;
            long sum = 0;
            while(k <= n - 1) {
                sum = sum + (long)Math.pow((double)k, (double)n - 1);
                k++;
            }
            if(sum % n == n - 1){
                System.out.println(n + " ");
            }
            n++;
        }
    }
}
