package Main;

import java.util.Scanner;

public class _25314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N/4; i++){
            sb.append("long").append(" ");
        }
        System.out.println(sb.append("int").toString());
    }
}
