package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1916_최소비용 {
	static int N, M;
	static ArrayList<Node> list[];
	static int dist[];
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		//도시의 개수(정점=노드)
		N = Integer.parseInt(br.readLine());
		//버스의 개수
		M = Integer.parseInt(br.readLine());
		
		//인접리스트
		list = new ArrayList[N+1];
		//최단비용(=최단거리 배열)
		dist = new int[N+1];
		//방문배열
		visited = new boolean[N+1];
		
		//인접리스트 생성
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		//최단 거리 배열 무한대 값으로 초기화
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		//인접리스트에 데이터 넣기 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			//출발노드 = 출발 도시 번호
			int start = Integer.parseInt(st.nextToken());
			//도착 노드 = 도착 도시 번호
			int end = Integer.parseInt(st.nextToken());
			//가중치(비용)
			int weight = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		//구간 출발점
		int startIdx = Integer.parseInt(st.nextToken());
		//도착 출발점
		int endIdx = Integer.parseInt(st.nextToken());
		sb.append(dijkstra(startIdx, endIdx)).append('\n');
		System.out.println(sb);

	}
	private static int dijkstra(int startIdx, int endIdx) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.add(new Node(startIdx, 0));
		dist[startIdx] = 0;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			int nowNode = now.targetNode;
			
			//방문하지 않았다면 방문해라
			if(!visited[nowNode]) {
				visited[nowNode] = true;
				
				//인접한 모든 노드 중 아직 방문하지 않은 노드를 탐색하고 최단거리배열 갱신
				for(Node n : list[nowNode]) {
					if(!visited[n.targetNode] && dist[n.targetNode] > dist[nowNode] + n.value) {
						dist[n.targetNode] = dist[nowNode] + n.value;
						q.add(new Node(n.targetNode, dist[n.targetNode]));
					}
				}
			}
		}
		
		return dist[endIdx];
	}

}

class Node implements Comparable<Node>{
	int targetNode;
	int value;
	
	public Node(int targetNode, int value) {
		this.targetNode = targetNode;
		this.value = value;
	}
	
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.value - o.value;
	}
	
}
