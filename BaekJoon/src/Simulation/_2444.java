package Simulation;

import java.util.Scanner;

public class _2444 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();

        for (int i=0; i<row; i++) {
            for (int j=1; j<row-i; j++) {
                System.out.print(" ");
            }
            for (int j=0; j<i*2+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i=row-1; i>0; i--) {
            for (int j=row-i; j>0; j--) {
                System.out.print(" ");
            }
            for (int j=i*2-1; j>0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
