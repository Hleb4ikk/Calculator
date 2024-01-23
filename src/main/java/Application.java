import java.util.Scanner;

public class Application {
    //надо сделать функцию которая будет искать */+- и определять что будет выполняться первым, расположить индексы в массиве в порядке приоритетов.
    static char[] op_search(String str){ //создание массива из операций
        char[] operations_i;
        int counter = 0;
        char[] c_str = str.toCharArray();
        for(char a : c_str){
            if(a == '+' || a =='-' || a == '*' || a  == '/'){

                counter++;

            }


        }
        operations_i = new char[counter];
        counter = 0;

        for(int i = 0; i < c_str.length; i++){

            if(c_str[i] == '+' || c_str[i] == '-' || c_str[i] == '*' || c_str[i]  == '/'){

                operations_i[counter] = c_str[i];
                counter++;

            }


        }
        return operations_i;
    }

    static String ready_to_split(String str){ //удаление операций из строки
        String str_without_op = "";
        char[] c_str = str.toCharArray();

        for(char s : c_str){

            if(s == '+' || s == '-' || s == '*' || s  == '/'){

                str_without_op = str_without_op + " ";

            }else if(s != ' '){

                str_without_op = str_without_op + s;

            }

        }
        return str_without_op;
    }
    static boolean run(char[] arr, String str){

        String[] numbers_str = str.split(" "); //числа в string
        double[] numbers = new double[numbers_str.length];//числа в double
        double[] results = new double[numbers_str.length-1];//результаты

        for(int i = 0; i < numbers_str.length; i++){ // перевод чисел в double
            try {

                numbers[i] = Double.parseDouble(numbers_str[i]);

            } catch (Exception e){

                System.out.println("Вы ввели неверный символ!");
                return false;

            }

        }

        double res = 0;

        return true;
    }
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();
        run(op_search(expression), ready_to_split(expression));

    }
}
