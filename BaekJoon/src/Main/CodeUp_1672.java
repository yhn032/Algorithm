package Main;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CodeUp_1672 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int range = K/n;
		if(range > 9999) {
			System.out.println("번호 초과 오류");
			System.exit(0);
		}
		for(int i=1; i<=range; i++) {
			sb.append(String.format("F-%04d", i)).append('\n');
		}
		System.out.println(sb);
	}

}
