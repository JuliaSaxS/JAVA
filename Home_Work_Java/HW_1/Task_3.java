package Home_Work_Java.HW_1;
import java.util.Scanner;
public class Task_3 {
    public static void main(String[] args) {
        System.out.print("Введите первое число: ");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        System.out.print("Введите второе число: ");
        int numberOne = scan.nextInt();
        System.out.print("Введите нужный знак (+, -, *, /): ");
        String Symbol = scan.next();
        System.out.print(" " + number + Symbol + numberOne);
        switch (Symbol) {
            case "+":
                System.out.print(" = " + (number + numberOne));
            break;
            case "-":
                System.out.print(" = " + (number - numberOne));
            break;
            case "*":
                System.out.print(" = " + (number * numberOne));
            break;
            case "/":
                System.out.print(" = " + (number / numberOne));
            break;
        }
    scan.close();
    }
}

