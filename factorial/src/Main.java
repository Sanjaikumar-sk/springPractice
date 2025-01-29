// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int i = 1;
        int num = 1;
        System.out.println(num);
        for(i = 1; i<1000; i++) {
            System.out.println(num);
            System.out.println(i);
            num = num * i;
        }
        System.out.println(num);

    }
}