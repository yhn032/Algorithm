package String;

import java.util.Scanner;

public class _9086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        for(int i=0; i<testcase; i++){
            String s = sc.nextLine();
            System.out.println(s.charAt(0) + s.charAt(s.length()-1));
        }
    }
}
