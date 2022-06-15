package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _9370_미확인도착지_100 {
	static int min_dist[];
	static int n,m,t, T;
	static List<List<Node9370>> list;
	static boolean visit[];
	static final int INF = 100000000;
	static class Node9370 implements Comparable<Node9370>{
		int node, weight;

		public Node9370(int node, int weight) {
			super();
			this.node = node;
			this.weight = weight;
		}
		//우선 순위큐의 정렬 기준(우선순위 기준) 제공. -> 오름차순 정렬 작은 것 먼저(최단거리) -> 최소 힙 
		@Override
		public int compareTo(Node9370 o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//테스트케이스 수
		T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			//교차로의 개수 = 정점 개수
			n = Integer.parseInt(st.nextToken());
			//도로의 개수   = 간선 개수
			m = Integer.parseInt(st.nextToken());
			//목적지 후보의 개수
			t = Integer.parseInt(st.nextToken());
			
			//최단거리 배열
			min_dist = new int[n+1];
			//최단 거리 배열 초기화 (차후에 시작노드는 0으로 초기화)
			Arrays.fill(min_dist, INF);
			
			//인접 리스트 생성
			list = new ArrayList<>(n+1);
			//인접 리스트 초기화
			for(int i=0; i<=n; i++) {
				list.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			//예술가듀오의 출발 노드
			int s = Integer.parseInt(st.nextToken());
			//예술가 듀오가 확실히 지나가는 두 정점
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			//인접리스트에 간선 정보 초기화 
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				//두 정점 a, b사이의 가중치
				int d = Integer.parseInt(st.nextToken());
				
				if((a==g && b ==h) || (a==h && b == g)) {//반드시 지나는 정점은 홀수로
					list.get(a).add(new Node9370(b, d*2-1));
					list.get(b).add(new Node9370(a, d*2-1));
				}else {
					list.get(a).add(new Node9370(b, d*2));
					list.get(b).add(new Node9370(a, d*2));
				}
			}
			
			//후보 정점
			List<Integer> target = new ArrayList<Integer>();
			for(int k=0; k<t; k++) {
				target.add(Integer.parseInt(br.readLine()));
			}
			
			dijkstra(s);
			
			Collections.sort(target);
			
			for(int num : target) {
				if(min_dist[num] % 2 == 1) {
					sb.append(num).append(' ');
				}
			}
			sb.append('\n');
			
		}//end-while-t
		
		System.out.println(sb);
		
	}
	private static void dijkstra(int start) {
		// TODO Auto-generated method stub
		//방문 배열
		visit = new boolean[n+1];
		//다익스트라 알고리즘 시작
		PriorityQueue<Node9370> pq = new PriorityQueue<Node9370>();
		//시작노드와 거리값을 초기화(시작노드의 최단거리배열은 0)
		min_dist[start] = 0;
		pq.add(new Node9370(start, 0));
		
		while(!pq.isEmpty()) {
			Node9370 currentNode = pq.poll();
			
			if(visit[currentNode.node]) continue;
			//방문 처리
			visit[currentNode.node] = true;
			
			//현재 노드에서 인접 노드를 탐색
			for(Node9370 node : list.get(currentNode.node)) {
				
				//최단거리 배열 업데이트 하기 
				if(!visit[node.node] && min_dist[node.node] > min_dist[currentNode.node] + node.weight) {
					min_dist[node.node] = min_dist[currentNode.node] + node.weight;
					pq.add(new Node9370(node.node, min_dist[node.node]));
				}
			}
		}
	}
}