import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavlo.Mykhaylenko on 4/20/2016.
 */
public class ListTest {

    @Test
    public void testRetain() {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("3");
        list1.add("5");
        list1.add("7");
        list1.add("9");

        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("6");

        boolean b = list1.retainAll(list2);
        System.out.println(b);
        list1.forEach(s -> System.out.println(s));
    }

    @Test
    public void testFinally() {
        try {
            System.out.println("try");
        } catch (NullPointerException e) {
            System.out.println("catch");
        } finally {
            finally1("finally1");
            finally1("finally2");
        }
    }

    private void finally1(String finnally1) {
        try {
            System.out.println(finnally1);
            throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println("finally catch");
        }
    }
}
