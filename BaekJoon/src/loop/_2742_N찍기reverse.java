package loop;

import java.util.Scanner;

public class _2742_N���reverse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		for(int i=n; i>=1;i--) {
			sb.append(i).append('\n');
		}
		
		System.out.println(sb);
	}
}
