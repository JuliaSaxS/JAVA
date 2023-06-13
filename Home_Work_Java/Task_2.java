// Задача 2: Вывести все простые числа от 1 до 1000

package Home_Work_Java;

public class Task_2 {
    public static void main(String[] args) {
        int n = 2;

        while(n<=1000){
        int k = 1;
            long sum = 0;
            while(k<=n-1){
                long pow = 1;
                for (int i = 0; i < n - 1; i++)
                    pow = (pow * k) % n;
                sum = (sum + pow)%n;
                k++;
            }
            if(sum%n==n-1){
                System.out.print(n + " ");
            }
            n++;
        }
    }
}

