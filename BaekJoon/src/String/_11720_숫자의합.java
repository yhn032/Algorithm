package String;

import java.util.Scanner;

public class _11720_숫자의합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		int sum=0;
		
		for(int i=0; i<N;i++) {
			sum += str.charAt(i)-'0';
		}
		
		System.out.println(sum);
	}

}
