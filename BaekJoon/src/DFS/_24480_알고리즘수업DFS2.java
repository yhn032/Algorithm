package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _24480_알고리즘수업DFS2 {
	static List<ArrayList<Integer>> list;
	static int n, m, r;
	static int answer[];
	static boolean visit[];
	static int cnt=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		list = new ArrayList<ArrayList<Integer>>();
		
		//중간에 빈값을 허용하지 않는 arraylist의 특성상 생성은 해놔야 함. 초기화만 안 할 뿐 
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		for(int i=1; i<=n; i++) {
			Collections.sort(list.get(i), Collections.reverseOrder());
		}
		answer = new int[n+1];
		visit  = new boolean[n+1];
		
		
		dfs(r);
		
		for(int i=1; i<=n; i++) {
			System.out.println(answer[i]);
		}
	}
	private static void dfs(int r) {
		// TODO Auto-generated method stub
		visit[r] = true;
		answer[r] = ++cnt;
		
		for(int k : list.get(r)) {
			if(!visit[k]) {
				visit[k] = true;
				dfs(k);
			}
		}
		
	}

}

