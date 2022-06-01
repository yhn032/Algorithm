package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _24444_알고리즘수업BFS1 {
	static int n, m, r;
	static List<Integer> []list;
	static boolean visit[];
	static int answer[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		visit = new boolean[n+1];
		answer = new int[n+1];
		
		//인접리스트 초기화하기
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		
		for(int i=1; i<=n; i++) {
			Collections.sort(list[i]);
		}
		
		bfs(r);
		
		
		for(int i=1; i<=n ; i++) {
			System.out.println(answer[i]);
		}
	}
	private static void bfs(int start) {
		// TODO Auto-generated method stub
		int count = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		visit[start] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			answer[cur] = ++count;
			
			for(Integer k : list[cur]) {
				if(!visit[k]) {
					visit[k] = true;
					q.add(k);
				}
			}
		}
		
		
	}

}
