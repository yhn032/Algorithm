package IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1065_한수 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int result = arithmetic_progression(N);
		System.out.println(result);
	}

	private static int arithmetic_progression(int n) {
		// TODO Auto-generated method stub
		int cnt = 0;
		
		if(n < 100) { //100보다 작은 수는 모두 등차수열을 이룬다.
			return n;
		} else { 
			cnt = 99;
			for(int i = 100; i<=n; i++ ) {
				int baek = i/100;
				int sib  = (i/10)%10;
				int il   = i%10;
				
				if((baek-sib) == (sib-il)){
					cnt++;
				}
			}
		}
		
		
		
		
		return cnt;
	}

}

