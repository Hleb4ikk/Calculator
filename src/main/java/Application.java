import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    //надо сделать функцию которая будет искать */+- и определять что будет выполняться первым, расположить индексы в массиве в порядке приоритетов.
    static int[] op_search(String[] c_str){ //создание массива из операций
        int[] operations_i;
        int counter = 0;

        for(String a : c_str){

            if(a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/")){

                counter++;

            }


        }
        operations_i = new int[counter];
        counter = 0;

        for(int i = 0; i < c_str.length; i++){

            if(c_str[i].equals("/")){

                operations_i[counter] = i;
                counter++;

            }


        }
        for(int i = 0; i < c_str.length; i++){

            if(c_str[i].equals("*")){

                operations_i[counter] = i;
                counter++;

            }


        }
        for(int i = 0; i < c_str.length; i++){

            if(c_str[i].equals("-")){

                operations_i[counter] = i;
                counter++;

            }


        }
        for(int i = 0; i < c_str.length; i++){

            if(c_str[i].equals("+")){

                operations_i[counter] = i;
                counter++;

            }


        }
        return operations_i;
    }

    static ArrayList<String> to_ArrayList(String[] arr){
        ArrayList<String> converted = new ArrayList<>();

        for(int i = 0; i < arr.length;i++){
            converted.add(arr[i]);
        }

        return converted;
    }
    static String ready_to_split(String str){
        String str_without_op = "";
        char[] c_str = str.toCharArray();

        for(char s : c_str){

            if(s == '+' || s == '-' || s == '*' || s  == '/'){

                str_without_op = str_without_op + " " + s + " ";

            }else if(s != ' '){

                str_without_op = str_without_op + s;

            }

        }
        return str_without_op;
    }
    static boolean run(String str){

        String[] exp = str.split(" "); //числа в string
        ArrayList<String> exp_list = to_ArrayList(exp);
        int[] operations = op_search(exp);
        double result = 0;

        try {
            for (int i = 0; i < operations.length; i++) {

                if (exp_list.get(operations[i]).equals("/")){
                    if(exp_list.get(operations[i] - 1).equals(" ") && exp_list.get(operations[i] + 1).equals(" ")) {

                        result = Double.parseDouble(exp_list.get(operations[i] - 2)) / Double.parseDouble(exp_list.get(operations[i] + 2));
                        exp_list.set(operations[i], Double.toString(result));
                        exp_list.set(operations[i] + 2, " ");
                        exp_list.set(operations[i] - 2, " ");

                    } else if(exp_list.get(operations[i] - 1).equals(" ") && !exp_list.get(operations[i] + 1).equals(" ")){

                        result = Double.parseDouble(exp_list.get(operations[i] - 2)) / Double.parseDouble(exp_list.get(operations[i] + 1));
                        exp_list.set(operations[i], Double.toString(result));
                        exp_list.set(operations[i] + 1, " ");
                        exp_list.set(operations[i] - 2, " ");

                    } else if(!exp_list.get(operations[i] - 1).equals(" ") && exp_list.get(operations[i] + 1).equals(" ")){

                        result = Double.parseDouble(exp_list.get(operations[i] - 1)) / Double.parseDouble(exp_list.get(operations[i] + 2));
                        exp_list.set(operations[i], Double.toString(result));
                        exp_list.set(operations[i] + 2, " ");
                        exp_list.set(operations[i] - 1, " ");


                    } else {

                        result = Double.parseDouble(exp_list.get(operations[i] - 1)) / Double.parseDouble(exp_list.get(operations[i] + 1));
                        exp_list.set(operations[i], Double.toString(result));
                        exp_list.set(operations[i] + 1, " ");
                        exp_list.set(operations[i] - 1, " ");


                    }
                }
                if (exp_list.get(operations[i]).equals("*")){

                    if(exp_list.get(operations[i] - 1).equals(" ") && exp_list.get(operations[i] + 1).equals(" ")) {

                        result = Double.parseDouble(exp_list.get(operations[i] - 2)) * Double.parseDouble(exp_list.get(operations[i] + 2));
                        exp_list.set(operations[i], Double.toString(result));
                        exp_list.set(operations[i] + 2, " ");
                        exp_list.set(operations[i] - 2, " ");

                    } else if(exp_list.get(operations[i] - 1).equals(" ") && !exp_list.get(operations[i] + 1).equals(" ")){

                        result = Double.parseDouble(exp_list.get(operations[i] - 2)) * Double.parseDouble(exp_list.get(operations[i] + 1));
                        exp_list.set(operations[i], Double.toString(result));
                        exp_list.set(operations[i] + 1, " ");
                        exp_list.set(operations[i] - 2, " ");

                    } else if(!exp_list.get(operations[i] - 1).equals(" ") && exp_list.get(operations[i] + 1).equals(" ")){

                        result = Double.parseDouble(exp_list.get(operations[i] - 1)) * Double.parseDouble(exp_list.get(operations[i] + 2));
                        exp_list.set(operations[i], Double.toString(result));
                        exp_list.set(operations[i] + 2, " ");
                        exp_list.set(operations[i] - 1, " ");


                    } else {

                        result = Double.parseDouble(exp_list.get(operations[i] - 1)) * Double.parseDouble(exp_list.get(operations[i] + 1));
                        exp_list.set(operations[i], Double.toString(result));
                        exp_list.set(operations[i] + 1, " ");
                        exp_list.set(operations[i] - 1, " ");



                    }

                }
                if (exp_list.get(operations[i]).equals("+")){

                    if(exp_list.get(operations[i] - 1).equals(" ") && exp_list.get(operations[i] + 1).equals(" ")) {

                        result = Double.parseDouble(exp_list.get(operations[i] - 2)) + Double.parseDouble(exp_list.get(operations[i] + 2));
                        exp_list.set(operations[i], Double.toString(result));
                        exp_list.set(operations[i] + 2, " ");
                        exp_list.set(operations[i] - 2, " ");

                    } else if(exp_list.get(operations[i] - 1).equals(" ") && !exp_list.get(operations[i] + 1).equals(" ")){

                        result = Double.parseDouble(exp_list.get(operations[i] - 2)) + Double.parseDouble(exp_list.get(operations[i] + 1));
                        exp_list.set(operations[i], Double.toString(result));
                        exp_list.set(operations[i] + 1, " ");
                        exp_list.set(operations[i] - 2, " ");

                    } else if(!exp_list.get(operations[i] - 1).equals(" ") && exp_list.get(operations[i] + 1).equals(" ")){

                        result = Double.parseDouble(exp_list.get(operations[i] - 1)) + Double.parseDouble(exp_list.get(operations[i] + 2));
                        exp_list.set(operations[i], Double.toString(result));
                        exp_list.set(operations[i] + 2, " ");
                        exp_list.set(operations[i] - 1, " ");


                    } else {

                        result = Double.parseDouble(exp_list.get(operations[i] - 1)) + Double.parseDouble(exp_list.get(operations[i] + 1));
                        exp_list.set(operations[i], Double.toString(result));
                        exp_list.set(operations[i] + 1, " ");
                        exp_list.set(operations[i] - 1, " ");



                    }

                }

                if (exp_list.get(operations[i]).equals("-")){

                    if(exp_list.get(operations[i] - 1).equals(" ") && exp_list.get(operations[i] + 1).equals(" ")) {

                        result = Double.parseDouble(exp_list.get(operations[i] - 2)) - Double.parseDouble(exp_list.get(operations[i] + 2));
                        exp_list.set(operations[i], Double.toString(result));
                        exp_list.set(operations[i] + 2, " ");
                        exp_list.set(operations[i] - 2, " ");

                    } else if(exp_list.get(operations[i] - 1).equals(" ") && !exp_list.get(operations[i] + 1).equals(" ")){

                        result = Double.parseDouble(exp_list.get(operations[i] - 2)) - Double.parseDouble(exp_list.get(operations[i] + 1));
                        exp_list.set(operations[i], Double.toString(result));
                        exp_list.set(operations[i] + 1, " ");
                        exp_list.set(operations[i] - 2, " ");

                    } else if(!exp_list.get(operations[i] - 1).equals(" ") && exp_list.get(operations[i] + 1).equals(" ")){

                        result = Double.parseDouble(exp_list.get(operations[i] - 1)) - Double.parseDouble(exp_list.get(operations[i] + 2));
                        exp_list.set(operations[i], Double.toString(result));
                        exp_list.set(operations[i] + 2, " ");
                        exp_list.set(operations[i] - 1, " ");


                    } else {

                        result = Double.parseDouble(exp_list.get(operations[i] - 1)) - Double.parseDouble(exp_list.get(operations[i] + 1));
                        exp_list.set(operations[i], Double.toString(result));
                        exp_list.set(operations[i] + 1, " ");
                        exp_list.set(operations[i] - 1, " ");



                    }
                }
            }
            System.out.println(result);
        }catch (Exception e){

            System.out.println("Ошибка!");
            return false;
        }

        return true;
    }
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();

        run(ready_to_split(expression));
    }

}
