package String;

import java.util.Scanner;
import java.util.StringTokenizer;

public class _2675_문자열반복 {
	public static void main(String[] args) {
		//a~z = 26
		//97~122
		//A~Z = 26
		//65~90
		//int arr[] =new int[26];
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int t = sc.nextInt();
		sc.nextLine();
		
		//테스트케이스
		for(int i=0; i<t;i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int r = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			//문자의길이
			for(int k=0; k<str.length();k++) {
				//반복횟수
				for(int j=0; j<r;j++) {
					sb.append(str.charAt(k));
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
		sc.close();
	}
}
