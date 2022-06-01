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

public class _24445_�˰������BFS2 {
	static int n, m, r;
	static List<ArrayList<Integer>> list;
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
		
		list = new ArrayList<>();
		visit = new boolean[n+1];
		answer = new int[n+1];
		
		//��������Ʈ �ʱ�ȭ�ϱ�
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<Integer>()); 
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		for(int i=1; i<=n; i++) {
			Collections.sort(list.get(i), Collections.reverseOrder());
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
			
			for(Integer k : list.get(cur)) {
				if(!visit[k]) {
					visit[k] = true;
					q.add(k);
				}
			}
		}
		
		
	}

}
