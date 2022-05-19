package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2231_분해합 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1<= n <= 1,000,000
		int n = Integer.parseInt(br.readLine());
		
		
		int sum=0;
		for(int i=1; i<=n; i++) {
			String str = String.valueOf(i);
			
			if(i < 10) { //한자리수는 분해합 존재 x
				int a = str.charAt(0)-'0';
				if(a+i == n) {
					sum = i;
					break;
				}
			}else if(i<100){ //두 자리 수
				int a = str.charAt(1)-'0';
				int b = str.charAt(0)-'0';
				if(a+b+i == n) {
					sum = i;
					break;
				}
			}else if(i<1000) { //세자리수
				int a = str.charAt(2)-'0';
				int b = str.charAt(1)-'0';
				int c = str.charAt(0)-'0';
				if(a+b+c+i == n) {
					sum = i;
					break;
				}
			}else if(i<10000) { //네자리수
				int a = str.charAt(3)-'0';
				int b = str.charAt(2)-'0';
				int c = str.charAt(1)-'0';
				int d = str.charAt(0)-'0';
				if(a+b+c+d+i == n) {
					sum = i;
					break;
				}
			}else if(i<100000) { //다섯자리수
				int a = str.charAt(4)-'0';
				int b = str.charAt(3)-'0';
				int c = str.charAt(2)-'0';
				int d = str.charAt(1)-'0';
				int e = str.charAt(0)-'0';
				if(a+b+c+d+e+i == n) {
					sum = i;
					break;
				}
			}else if(i<1000000) { //여섯자리수
				int a = str.charAt(5)-'0';
				int b = str.charAt(4)-'0';
				int c = str.charAt(3)-'0';
				int d = str.charAt(2)-'0';
				int e = str.charAt(1)-'0';
				int f = str.charAt(0)-'0';
				if(a+b+c+d+e+f+i == n) {
					sum = i;
					break;
				}
			}
		}
		System.out.println(sum == 0 ? 0 : sum);
	}

}

/*
	245의 분해합은 245 + 2 + 4 + 5 = 256
	256의 생성자는 245
	
	완전 탐색
	어떤 수는 생성자가 없을수도 있고, 여러개 있을 수 있음
	가장 작은 생성자를 구해라. 생성자가 없는 경우 0을 출력
*/
