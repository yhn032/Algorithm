package BasicMath;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _2720 {
    static int quarter = 25;
    static int dime = 10;
    static int nickel = 5;
    static int penny = 1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = null;
        while(T --> 0){
            list = new ArrayList<>();

            int change = Integer.parseInt(br.readLine());
            list.add((int) (change / quarter));
            change %= quarter;

            list.add((int) (change / dime));
            change %= dime;

            list.add((int) (change / nickel));
            change %= nickel;

            list.add((int) (change / penny));
            change %= penny;

            for (Integer i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }


    }
}
