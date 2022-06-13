package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10986_누적합_나머지합 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//구간합 나머지 배열
		long dp[] = new long[m];
		
		st = new StringTokenizer(br.readLine());
		int sum = 0;
 		for(int i=0; i<n; i++) {
 			sum += Integer.parseInt(st.nextToken());
 			dp[sum%m]++;
		}
 		
 		
 		long cnt = dp[0];
 		for(int i=0; i<m; i++) {
 			long a = dp[i];
 			cnt += a*(a-1)/2;
 		}
 		
 		
 		System.out.println(cnt);
 		/*
 			(a-b)%c = ((a%c)-(b%c))%c = 0
 			5개의 수중에서 2개의 수를 순서 없이 뽑는 경우의 수는 
 			5 * 4
 			-----
 			2 * 1
 		*/
	}

}

