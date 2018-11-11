package reflect_test;

import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String[] args) {
        ARI ar = new AR();
        try {
            Object obj = ar.getClass().getDeclaredMethods()[0].invoke(ar,112);
            System.out.println("obj: " + obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
