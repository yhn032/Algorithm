package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1753_최단경로 {
	static int V;
	static int K;
	static int E;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<Edge> list[];
	static PriorityQueue<Edge> q = new PriorityQueue<>();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		//Vertex. 정점 =노드의 개수
		V = Integer.parseInt(st.nextToken());
		
		//Edge의 개수
		E = Integer.parseInt(st.nextToken());
		
		//출발노드
		K = Integer.parseInt(br.readLine());
		
		//0번지는 버리고 헷갈리지 않게 노드의 번호와 같도록 1번지부터 사용할 거니까 크기 +1하기
		//최단거리 배열
		distance = new int[V+1];
		
		//방문 체크 배열
		visited = new boolean[V+1];
		
		//인접리스트의 크기 지정(1차원 배열의 형태)
		list = new ArrayList[V+1];
		
		//인접 리스트 생성하기 
		for(int i=0; i<V+1; i++) {
			list[i] = new ArrayList<Edge>();
		}
		
		//최단거리 배열 초기화하기 (초기에는 무한대의 값을 준다.)
		for(int i=0; i<V+1;i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		//인접리스트에 가중치 값 초기화하기 
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());//시작노드
			int v = Integer.parseInt(st.nextToken());//도착노드
			int w = Integer.parseInt(st.nextToken());//두 노드를 연결하는 에지의 가중치
			list[u].add(new Edge(v, w));
		}
		
		//시작노드를 K로 설정하기
		q.add(new Edge(K, 0));
		distance[K] = 0;
		
		//큐가 빌때까지 반복을 수행하면서 최단거리 배열을 완성한다. 
		//다익스트라 알고리즘 시작
		while(!q.isEmpty()) {
			Edge current = q.poll();
			//현재 노드번호를 저장
			int current_v = current.vertex;
			
			//이미 방문했다면, 아래의 명령을 수행하지 않고 건너뛰기
			if(visited[current_v]) continue;
			
			//false라면 방문 표시를 해준다.
			visited[current_v] = true;
			
			//현재 노드의 인접리스트를 탐색한다. 즉, 현재 노드와 연결된 노드의 에지를 탐색하면서 최단거리 배열을 갱신한다. 
			for(int i=0; i<list[current_v].size(); i++) {
				Edge tmp = list[current_v].get(i);//현재 노드 번호와 연결된 노드의 번호와 에지 정보를 가져온다. 
				int next  = tmp.vertex; //인접한 번호
				int value = tmp.value;  //위 번호와 연결된 에지의 가중치
				
				//최단거리로 업데이트하기
				if(distance[next] > distance[current_v] + value) {
					distance[next] = value + distance[current_v];
					//너비우선 탐색과정처럼 연쇄적으로 인접한 노드를 계속 탐색
					q.add(new Edge(next, distance[next]));
				}
			}//end-for
		}//end-while
		
		//최단거리 배열 출력하기 
		for(int i=1; i<V+1;i++) {
			//방문한 곳은 최단거리 배열 출력
			if(visited[i]) {
				System.out.println(distance[i]);
			} else {//5번노드는 방문할 수 있는 경우의 수가 없다.
				System.out.println("INF");
			}
		}
		
	}

}

//이를 통해서 우선순위 큐의 정렬 기준을 지정한다.
class Edge implements Comparable<Edge>{
	
	int vertex, value;
	Edge(int vertex, int value){
		this.vertex = vertex;
		this.value  = value;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		
		return this.value - o.value;
	}
	
}
