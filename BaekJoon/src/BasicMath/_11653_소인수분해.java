package BasicMath;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _11653_소인수분해 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=2; i <= n; i++) {
			
			if(n==1) break;
			
			while(n%i==0) {
				sb.append(i).append('\n');
				n /= i;
			}
		}
		System.out.println(sb);
	}

}

