package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1167 {
	static int V;
	static boolean[] visited;
	static ArrayList<edge2> []list;
	static int dist[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//노드의 개수
		V = Integer.parseInt(br.readLine());
		
		//자료구조 초기화(초기용적 : V+1)
		list = new ArrayList[V+1];
		
		//노드번호가 1번부터 시작하므로 0번지는 버리고 하는게 맘 편하다
		
		for(int i=1; i<=V;i++) {
			list[i] = new ArrayList<edge2>();
		}
		
		//인접리스트 초기화 
		for(int i=0; i<V; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			while(true) {
				int node = Integer.parseInt(st.nextToken());
				if(node == -1) {
					break;
				}
				
				int edge = Integer.parseInt(st.nextToken());
				list[S].add(new edge2(node, edge));
			}
		}
		
		dist = new int[V+1];
		visited = new boolean[V+1];
		
		//임의의 노드에서 시작, 편의상 1번 노드에서 출발하겠다/ 
		BFS(1);
		
		int max = 1;
		for(int i=2; i<=V; i++) {//1번 노드에서부터 출발했으니 어차피 dist[1]은 0이다 따라서 제외
			if(dist[i] > dist[max]) {
				max = i;//다음 BFS의 출발점, 즉 트리의 지름을 이루는 노드번호를 찾아야 한다.
			}
		}
		
		Arrays.fill(dist, 0);
		Arrays.fill(visited, false);
		
		BFS(max);
		
		Arrays.sort(dist);
		System.out.println(dist[V]);
		
	}
	private static void BFS(int i) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		visited[i] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(edge2 k : list[cur]) {//현재 노드와 연결된 노드 번호와 가중치(거리)값을 읽어온다.
				int node = k.node;
				int value = k.value;
				if(!visited[node]) {
					//아직 방문하지 않은 곳이라면 
					visited[node] = true;
					q.add(node);
					dist[node] = dist[cur] + value; //현재 위치를 기준으로 거리값을 추가함
				}
				
			}
		}
	}

}

class edge2 {
	int node;
	int value;
	public edge2(int node, int value) {
		this.node = node;
		this.value = value;
	}
}
/*
	트리를 구성하는 노드 중 두 노드 사이의 거리가 가장 긴 것을 트리의 지름이라고 한다. 
	"임의의 노드에서 가장 민 경로로 연결되어 있는 노드는 트리의 지름에 해당하는 두 노드 중 하나이다."
	ㄴ> 임의의 노드에서 출발. 거리배열 설정하여 가장 먼 거리에 있는 노드(트리의 지름 중 하나)를 찾고 이 노드를 시작점으로 BFS하여 가장 먼 거리에 있는 노드(트리의 지름 중 하나)를 찾는다.
	ㄴ> 즉, 두번의 거리배열 초기화를 하면서 트리의 지름을 이루는 노드 두개를 찾아내고 덩달아 거리 즉, 지름 까지 구한다.
	
*/
