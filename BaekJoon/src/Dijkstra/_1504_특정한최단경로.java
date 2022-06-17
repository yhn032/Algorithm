package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node1 implements Comparable<Node1>{
	int end;
	int weight;
	
	public Node1(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node1 o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}
	
}

public class _1504_특정한최단경로 {
	//무방향 그래프 단, 간선의 가중치는 있음
	//간선이 최대 1개 -> 하나의 가중치만 생각하라
	//임의의 두 정점을 거쳐서 가는 길이 없다면 -1을 출력하라 
	//통과한 지점 또는 간선을 다시 지날 수도 있기 때문에 방문배열은 만들지 않는다.
	static int N, E;
	static ArrayList<ArrayList<Node1>> list;
	static int dist[];
	static boolean check[];
	static int INF = 200000000;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		dist = new int[N+1];
		check = new boolean[N+1];
		
		//최단거리 배열 초기화 
		Arrays.fill(dist, INF);
		
		//인접리스트 생성
		for(int i=0; i<=N;i++) {
			list.add(new ArrayList<>());
		}
		
		
		//인접리스트에 가중치 값 초기화
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			//양방향으로 이동 가능하기 때문에 양쪽 다 설정하기
			list.get(start).add(new Node1(end, weight));
			list.get(end).add(new Node1(start, weight));
		}
		
		//반드시 거쳐야 하는 정점을 입력받는다. 
		st = new StringTokenizer(br.readLine());
		
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int res1 = 0;
		res1 += dijkstra(1, v1);
		res1 += dijkstra(v1, v2);
		res1 += dijkstra(v2, N);
		
		int res2 = 0;
		res2 += dijkstra(1, v2);
		res2 += dijkstra(v2, v1);
		res2 += dijkstra(v1, N);
		
		
		int min = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);
		
		System.out.println(min);
		/*
		 * if(res1 >= INF && res2 >= INF) { System.out.println(-1); } else { int min =
		 * res1 > res2 ? res2 : res1;
		 * 
		 * System.out.println(min);
		 * 
		 * }
		 */
		//총 3번의 다익스트라 알고리즘 수행
		//차후의 덧셈 연산을 수행하는 경우 오버플로우를 방지하기 위해서 자료형은 long으로 한다. 
		//만약 더한 결과가 integer.max_value보다 크거나 같다면 최소값이 maxvalue라는 말이므로 경로를 찾지 못했다는 뜻이다. -> INF = -1
		//1 -> v1 -> v2 -> N
		//1 -> v2 -> v1 -> N
		//1번 노드에서 출발합니다.
		br.close();
		
	}
	private static int dijkstra(int start, int end) {
		// TODO Auto-generated method stub
		//매 연산마다 같은 방문 배열과 최단거리 배열을 공유하므로 초기화 시켜야 합니다.
		Arrays.fill(dist, INF);
		Arrays.fill(check, false);
		
		PriorityQueue<Node1> pq = new PriorityQueue<Node1>();
		boolean []check = new boolean[N+1];
		pq.offer(new Node1(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node1 curNode = pq.poll();
			//시작 노드의 번호
			int cur = curNode.end;
			
			if(!check[cur]) {
				check[cur] = true;
				
				for(Node1 node : list.get(cur)) {
					
					if(!check[node.end] && dist[node.end] > dist[cur] + node.weight) {
						dist[node.end] = dist[cur] + node.weight;
						pq.add(new Node1(node.end, dist[node.end]));
					}
				}
			}
					
		}
		
		return dist[end];
	}

}



