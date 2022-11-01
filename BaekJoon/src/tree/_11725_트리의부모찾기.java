package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _11725_트리의부모찾기 {
	
	public static int n;
	public static boolean[] visited;
	public static int[] ans;
	public static ArrayList<ArrayList<Integer>> tree;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		tree = new ArrayList<ArrayList<Integer>>(n+1);
		visited = new boolean[n+1];
		ans = new int[n+1];
		
		for(int i=0; i<=n; i++) {
			tree.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//양방향 에지
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		
		//1번 노드에서 출발
		dfs(1);
		
		for(int i=2; i<=n; i++) {
			System.out.println(ans[i]);
		}
	}

	private static void dfs(int node) {
		visited[node] = true;
		
		for(int i : tree.get(node)) {
			if(visited[i]) continue;
			
			ans[i] = node;
			dfs(i);
		}
		
	}
}
