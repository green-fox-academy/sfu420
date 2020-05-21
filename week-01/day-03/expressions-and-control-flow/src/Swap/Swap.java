package Swap;

public class Swap {
    public static void main(String[] args) {
        int a = 123;
        int b = 526;

        System.out.println(a);
        System.out.println(b);

        int swap = a;
        a = b;
        b = swap;

        System.out.println(a);
        System.out.println(b);
    }
}
