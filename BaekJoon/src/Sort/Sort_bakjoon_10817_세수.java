package Sort;


import java.util.Arrays;
import java.util.Scanner;

public class Sort_bakjoon_10817_¼¼¼ö {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] s = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        System.out.println(s[1]);
    }
}

