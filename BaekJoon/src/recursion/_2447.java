package recursion;

import java.util.Scanner;

public class _2447 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ũ�Ⱑ NxN�� ���簢���϶�, ����� N/2�� ��(������ 3�� �ŵ������̹Ƿ� ���� ������ Ȧ���̴�.)
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		printStar(N);
	}

	private static void printStar(int n) {
		// TODO Auto-generated method stub
		//������ ����ϴ� ���
		
		for(int i=0; i<n; i++) {
			for(int k=0; k<n;k++) {
				if( (i==n/2) && (k==n/2) ) {
					System.out.print(" ");
					continue;
				}
				printStar(i);
			}
			System.out.println();
		}
	}

}
