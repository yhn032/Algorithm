package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11501_주식 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t;i++) {
			
			int days = Integer.parseInt(br.readLine());
			long money[] = new long[days];
			
			//주가 초기화하기
			st = new StringTokenizer(br.readLine());
			for(int k=0; k<days; k++) {
				money[k] = Long.parseLong(st.nextToken());
			}
			
			
			//최고가
			long max = 0;
			long plus = 0;
			for(int j=days-1; j>=0; j--) {
				if(money[j] > max) {
					//최고가 갱신 -> 3.아무것도 안 한다.
					max = money[j];
				}else {//최고가보다 저렴하면 사고 판다. -> 시세차익만큼 더하는 것이 이익이다. 
					plus += (max-money[j]);
				}
			}
			
			sb.append(plus).append('\n');
		}
		System.out.println(sb);
	}

}
//3 5 9
/*
	max 9 
	9-5 +   4 
	9-3 +   6
*/
