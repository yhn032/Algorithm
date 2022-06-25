package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _18352_특정거리의도시찾기 {
	static List<ArrayList<Integer>> list;
	static int []minDist;//각 노드에 대해 최단거리를 저장할 배열
	static List<Integer> ans;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		//도시의 개수 = 정점의 개수
		int n = Integer.parseInt(st.nextToken());
		//도로의 개수 = 간선의 개수 
		int m = Integer.parseInt(st.nextToken());
		//출발노드에서 도달할 수 있는 최단 거리
		int k = Integer.parseInt(st.nextToken());
		//출발노드 번호
		int x = Integer.parseInt(st.nextToken());
		
		
		list = new ArrayList<ArrayList<Integer>>();
		minDist = new int[n+1];
		Arrays.fill(minDist, -1);
		
		//인접리스트
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		//간선 정보 초기화
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			//단방향, 가중치가 1.
			list.get(u).add(v);
		}
		
		BFS(x);
		
		ans = new ArrayList<Integer>();
		//최단거리가 k인 정점번호를 추가하기
		for(int i=0; i<=n; i++) {
			if(minDist[i] == k) {
				ans.add(i);
			}
		}
		
		
		if(ans.isEmpty()) {
			sb.append(-1);
		}else {
			//정렬
			Collections.sort(ans);
			for(int temp : ans) {
				sb.append(temp).append('\n');
			}
		}
		
		System.out.println(sb);
		
	}

	private static void BFS(int x) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<Integer>();
		minDist[x]++;
		q.add(x);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i : list.get(now)) {//인접 노드를 탐색한다.
				if(minDist[i]==-1) {//최단거리가 초기화 되어 있지 않다면 -> 아직 방문하지 않은 것임
					minDist[i] = minDist[now] + 1;//거리 정보이니 이전에 탐색한 노드의 최단거리에서 +1을 해준다. 
					q.add(i);
				}
			}
				
		}
	}

}

