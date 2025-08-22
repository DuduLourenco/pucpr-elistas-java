import java.util.ArrayList;

public class Main {
    public static void testeEArrayList() {
        System.out.println("Running `testeEArrayList()`");
        EArrayList<Integer> lista = new EArrayList<>();
        for (int i = 0; i < 1000; i++) {
            lista.add(i);
        }

        System.out.println(lista.indexOf(999));
        System.out.println(lista.toArray());
        System.out.println(lista.contains(1001));
        System.out.println(lista.contains(999));

        lista.add(15,934);
        System.out.println(lista.indexOf(934));
    }

    public static void testeArrayList() {
        System.out.println("Running `testeArrayList()`");
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            lista.add(i);
        }

        System.out.println(lista.indexOf(90));
        System.out.println(lista.toArray());
        System.out.println(lista.contains(1001));
        System.out.println(lista.contains(999));
    }

    public static void main(String[] args) {
        testeArrayList();
        testeEArrayList();
    }
}
