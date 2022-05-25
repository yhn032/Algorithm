package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15651_N°úM3 {
	static int n,m;
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		
		dfs(0);
		
		System.out.println(sb);
	}

	private static void dfs(int depth) {
		// TODO Auto-generated method stub
		if(depth == m) {
			for(int k : arr) {
				sb.append(k).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		
		for(int i=1; i<=n; i++) {
			arr[depth] = i;
			dfs(depth+1);
		}
	}

}
