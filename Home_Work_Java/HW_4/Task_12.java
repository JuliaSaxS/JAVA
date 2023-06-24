/* Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди, 
dequeue() - возвращает первый элемент из очереди и удаляет его, 
first() - возвращает первый элемент из очереди, не удаляя. */
package Home_Work_Java.HW_4;
import java.util.LinkedList;
public class Task_12 {
// помещает элемент в конец очереди
    public static LinkedList<Integer> enqueue(LinkedList<Integer> ll, int elem) {
        ll.add(elem);
        return ll;
    }
// возвращает первый элемент из очереди и удаляет его
    public static LinkedList<Object> dequeue(LinkedList<Integer> ll) {
        LinkedList<Object> result = new LinkedList<>();
        try {
            int firstElem = ll.remove();
            result.add(ll);
            result.add(firstElem);
            return result;
        } catch (Exception e) {
            result.add(ll);
            result.add(null);
            return result;
        }
    }
// возвращает первый элемент из очереди, не удаляя
    public static Object first(LinkedList<Integer> ll) {
        if (ll.size() == 0) {
            return null;
        } else {
            return ll.peek();
        }
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList<>();
        int llLength = 10;
        for (int i = 0; i < llLength; i++) {
            ll.add(i);
        }
        System.out.printf("LinkedList: %s\n", ll);
        int elem = 10;
        ll = enqueue(ll, elem);
        System.out.printf("Элемент %d добавлен в конец LinkedList: %s\n", elem, ll);
        LinkedList<Object> result = dequeue(ll);
        System.out.printf("Первый элемент LinkedList: %s (удалён).\n", result.get(1));
        ll = (LinkedList) result.get(0);
        System.out.printf("LinkedList: %s\n", ll);
        Object firstElemQu = first(ll);
        System.out.printf("Первый элемент LinkedList: %s (не удалён).\n", firstElemQu);
        System.out.printf("LinkedList: %s\n", ll);
    }
}
