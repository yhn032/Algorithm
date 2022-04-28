package recursion;

import java.util.Scanner;

public class _2447 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//크기가 NxN의 정사각형일때, 가운데는 N/2의 몫값(어차피 3의 거듭제곱이므로 값은 무조건 홀수이다.)
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		printStar(N);
	}

	private static void printStar(int n) {
		// TODO Auto-generated method stub
		//공백을 출력하는 경우
		
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
