package BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11051_이항계수2 {
	static int f[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		//factorial값을 저장할 배열 n >= k
		//1번지에 1!,,, n번지에 n!을 저장
		f = new int[n+1][k+1];
		
		System.out.println(dfs(n, k));
		
	}

	private static int dfs(int n, int k) {
		// TODO Auto-generated method stub
		if(f[n][k] > 0) {//기본값 0이 아니라면 메모이제이션이 되었다는 뜻이므로 저장된값 출력
			return f[n][k];
		}else if(n==k || k==0){//분모가 0이되는 경우
			return 1;
			
		}
		
		//나눗셈 연산은 모듈러 분배법칙이 불가능하기 때문에 바꾸어서 해야한다.
		//파스칼의 법칙;
		//C(n,k) + C(n, k+1) = C(n+1, k+1);
		return f[n][k] = (dfs(n-1,k-1) + dfs(n-1, k))%10007;
	}

}
