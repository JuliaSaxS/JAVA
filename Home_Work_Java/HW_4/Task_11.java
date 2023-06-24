// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
package Home_Work_Java.HW_4;
import java.util.Collections;
import java.util.LinkedList;
public class Task_11 {
    public static LinkedList<Integer> RevList_1(LinkedList<Integer> ll) {
        Collections.reverse(ll);
        return ll;
    }
    public static LinkedList<Integer> RevList_2(LinkedList<Integer> ll) {
        for (int i = 1; i < ll.size(); i++) {
// удаление элементов справа от первого и перезапись их слева от него ("переворот")
            ll.addFirst(ll.remove(i));
        }
        return ll;
    }
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            ll.add((int) (Math.random() * 10));
        }
        System.out.printf("LinkedList: %s\n", ll);
        ll = RevList_1(ll);
        System.out.printf("“Перевернутый” LinkedList: %s\n", ll);
        ll = RevList_2(ll);
    }
}
