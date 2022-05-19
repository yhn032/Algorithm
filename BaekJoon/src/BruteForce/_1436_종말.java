package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1436_종말 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int start = 665;
		int cnt = 0;
		
		while(cnt != n) {
			start++;
			
			//포함하면 종말수로 카운트하기
			if(String.valueOf(start).contains("666")) {
				cnt++;
			}
		}
		
		System.out.println(start);
	}

}
