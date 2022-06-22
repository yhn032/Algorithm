package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11054_가장긴바이토닉수열 {
	static int [] ans;
	static int []  dp_i; //최장 증가 수열 LIS
	static int []  dp_d; //최장 감소 수열 LDS
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		ans = new int[n];
		dp_i  = new int[n];
		dp_d  = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i <n; i++) {
			ans[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n; i++) {
			LIS(i);
			LDS(i);
		}
		
		int max = -1;
		for(int i=0; i < n; i++) {
			max = Math.max(dp_i[i]+dp_d[i], max);
		}
		
		System.out.println(max-1);
		
		
	}
	private static int LDS(int M) {
		// TODO Auto-generated method stub
		if(dp_d[M] == 0) {
			dp_d[M] = 1;
			
			//M이후의 노드들을 탐색
			for(int i=M+1; i<dp_d.length; i++) {
				if(ans[i] < ans[M]) {
					dp_d[M] = Math.max(dp_d[M], LDS(i)+1);
				}
			}
		}
		
		return dp_d[M];
		
		
	}
	private static int LIS(int N) {
		// TODO Auto-generated method stub
		if(dp_i[N] == 0) {
			dp_i[N] = 1;	//1로 초기화
			
			//N이전의 노드를 탐색
			for(int k=N-1; k>=0; k--) {
				if(ans[k] < ans[N]) {
					dp_i[N] = Math.max(dp_i[N], LIS(k)+1);
				}
			}
		}
		
		return dp_i[N];
	}
}
