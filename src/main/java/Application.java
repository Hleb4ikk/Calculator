import java.util.Scanner;

public class Application {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        String expression = input.nextLine();
        System.out.println(Calculator.op_search(expression));

    }
}
