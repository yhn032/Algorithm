package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1707_이분그래프 {
	static List<ArrayList<Integer>> list;
	static int n, m;
	static int bound[];
	static boolean isBipartite ;
	static boolean visit[];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<ArrayList<Integer>>();
			visit = new boolean[n+1];
			bound = new int[n+1];
			isBipartite = true;
			
			for(int i=0; i<=n; i++) {
				list.add(new ArrayList<Integer>());
			}
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v= Integer.parseInt(st.nextToken());
				
				list.get(u).add(v);
				list.get(v).add(u);
			}
			
			//주어진 그래프가 1개로 연결되어 있다고 보장할 수 없으므로 모든 노드에서 탐색해봐야 함
			for(int i=1; i<=n; i++) {
				if(isBipartite) {//이분그래프가 맞다면 계속 해서 재귀
					DFS(i);
				}else {
					break;//이분 그래프가 아니라면 백트레킹 -> 탐색 종료
				}
			}
			
			bound[1] =0;
			if(isBipartite) {
				sb.append("YES").append('\n');
			}else {
				sb.append("NO").append('\n');
			}
		}
		
		System.out.println(sb);
	}
	private static void DFS(int start) {
		// TODO Auto-generated method stub
		visit[start] = true;
		for(int i : list.get(start)) {
			if(!visit[i]) {//방문하지 않았다면 
				bound[i] = (bound[start]+1)%2;//이분 집합을 구분하는 값은 0과 1로 집합을 나눈다.
				DFS(i);
			}else if(bound[i] == bound[start]) {
				//방문했는데 현재 내 노드와 같은 집합이면 이분 그래프가 아니다. 
				isBipartite = false;
			}
		}
	}

}

/*
	인접한 노드는 다른 집합에 포함되도록 집합을 이분해야 한다.
	모든 그래프가 이어져 있지 않은 부분 그래프가 존재할 수 있으므로 BFS는 시간이 너무 오래걸림
	따라서 재귀를 사용하여 탐색을하다가 이미 방문한 지점이 나와 같은 집합이라면 인접한 두 노드를 다른 집합으로 
	구분하지 못한것이므로 탐색을 종료한다. 백트레킹
*/