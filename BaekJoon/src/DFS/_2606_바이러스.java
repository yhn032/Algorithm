package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _2606_바이러스 {
	static List<ArrayList<Integer>> list;
	static int n, m;
	static boolean visit[];
	static int cnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		list = new ArrayList<ArrayList<Integer>>();
		visit = new boolean[n+1];
		
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		dfs(1);
		
		System.out.println(cnt);
		
	}
	private static void dfs(int i) {
		// TODO Auto-generated method stub
		visit[i] = true;
		
		for(Integer a : list.get(i)) {
			if(!visit[a]) {
				visit[a] = true;
				cnt++;
				dfs(a);
			}
		}
	}

}
