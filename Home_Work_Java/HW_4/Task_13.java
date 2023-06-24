package Home_Work_Java.HW_4;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
public class Task_13 {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(Task_13.class.getName());
        FileHandler fh = new FileHandler("log_calc.txt", false);
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        String logMessage;
        Stack<String> operationStack = new Stack<>();
        Scanner iScanner = new Scanner(System.in);
        while (true) {
            System.out.printf("Выберите нужное действие (Enter - завершение программы, 1 - калькулятор, 2 - показать последние вычисления, 3 - отменить последнюю операцию): ");
            String str = iScanner.nextLine();
            if (str.equals("")) {
                iScanner.close();
                logMessage = "Работа программы завершена.";
                logger.info(logMessage);
                break;
            } else if (str.equals("2")) {
                if (operationStack.empty()) {
                    logMessage = "Показать последние вычисления невозможно, т.к. не было выполнено ни одной операции!";
                    System.out.println(logMessage);
                    logger.info(logMessage);
                } else {
                    for (int i = 0; i < operationStack.size(); i++) {
                        System.out.printf("Операция %d: %s\n", i + 1, operationStack.get(i));
                    }
                    logMessage = "Последние вычисления показаны.";
                    logger.info(logMessage);
                }
            } else if (str.equals("3")) {
                if (operationStack.empty()) {
                    logMessage = "Отменить последнюю операцию невозможно, т.к. не было выполнено ни одной операции!";
                    System.out.println(logMessage);
                    logger.info(logMessage);
                } else {
                    logMessage = String.format("Последняя операция %s отменена.\n", operationStack.pop());
                    System.out.println(logMessage);
                    logger.info(logMessage);
                }
            } else if (str.equals("1")) {
                int n1;
                int n2;
                while (true) {
                    try {
                        System.out.printf("Введите первое число: ");
// считывание строк из консоли
                        String nString1 = iScanner.nextLine();
                        n1 = Integer.parseInt(nString1);
                        System.out.printf("Введите второе число: ");
                        String nString2 = iScanner.nextLine();
                        n2 = Integer.parseInt(nString2);
                        break;
                    } catch (NumberFormatException ex) {
                        logMessage = "Некорректный ввод: " + ex.getMessage();
                        System.out.println(logMessage);
                        logger.log(Level.WARNING, logMessage);
                    }
                }
                System.out.printf("Выберите необходимое действие (+, -, /, *, ^: ): ");
                String operation = iScanner.nextLine();
                double result = 0;
                boolean correctInput = true;
                switch (operation) {
                    case "+" -> result = n1 + n2;
                    case "-" -> result = n1 - n2;
                    case "/" -> result = (double) n1 / (double) n2;
                    case "*" -> result = n1 * n2;
                    case "^" -> result = Math.pow(n1, n2);
                    default -> {
                        logMessage = "Ошибочный ввод.";
                        System.out.println(logMessage);
                        correctInput = false;
                        logger.log(Level.WARNING, logMessage);
                    }
                }
// вывод результата с округлением до 2 знаков после запятой
                if (correctInput) {
                    logMessage = String.format("%d %s %d = %.2f", n1, operation, n2, result);
                    System.out.printf("%s\n", logMessage);
                    operationStack.push(logMessage);
                    logger.info(logMessage);
                }
            } else {
                logMessage = "Некорректный ввод выбора действия!";
                System.out.println(logMessage);
                logger.log(Level.WARNING, logMessage);
            }
        }
    }
}
