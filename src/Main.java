//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Box<String> stringBox = new Box<>("Hello, Generics!");
        System.out.println(stringBox);

        Box<Integer> integerBox = new Box<>(42);
        System.out.println(integerBox);



    }
}