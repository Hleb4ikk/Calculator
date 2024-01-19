import java.util.ArrayList;

public class Calculator{

    public static float plus(float a, float b){

        return a+b;

    }

    public static float minus(float a, float b){

        return a-b;

    }

    public static float div(float a, float b){

        return a/b;

    }

    public static float multiplication(float a, float b){

        return a*b;

    }

    public static ArrayList<ArrayList<Integer>> op_search(String exp){
        ArrayList<ArrayList<Integer>> op_index;
        op_index = new ArrayList<>();
        op_index.add(new ArrayList<>()); //0 - +
        op_index.add(new ArrayList<>()); //1 - -
        op_index.add(new ArrayList<>()); //2 - /
        op_index.add(new ArrayList<>()); //3 - *

        int counter = 0;

        for(char s : exp.toCharArray()){
            if(s == '+'){
                ArrayList<Integer> temp = op_index.get(0);
                temp.add(counter);
                op_index.set(0, temp);

            }
            if(s == '-'){
                ArrayList<Integer> temp = op_index.get(1);
                temp.add(counter);
                op_index.set(1, temp);

            }
            if(s == '/'){
                ArrayList<Integer> temp = op_index.get(2);
                temp.add(counter);
                op_index.set(2, temp);

            }
            if(s == '*'){
                ArrayList<Integer> temp = op_index.get(3);
                temp.add(counter);
                op_index.set(3, temp);

            }
            counter++;

        }
        return op_index;

    }



}
