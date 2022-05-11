package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1854_K번째최단경로 {
	static final int INF = 200000000;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int N,M,K;
		int [][]W = new int[1001][1001];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		//도시(=노드)의 개수
		N = Integer.parseInt(st.nextToken());
		//에지의 수 
		M = Integer.parseInt(st.nextToken());
		//K번째 최단경로
		K = Integer.parseInt(st.nextToken());
		
		//최단거리 배열을 저장할 우선순위 큐 생성 
		PriorityQueue<Integer>[] distq = new PriorityQueue[N+1];
		
		Comparator<Integer> cp = new Comparator<Integer>() {//정렬 기준 만들기

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 < o2 ? 1 : -1 ;
			}
			
		};
		
		for(int i=0; i<=N; i++) {
			//정렬 기준을 지정해주면서 우선순위큐 생성
			distq[i] = new PriorityQueue<Integer>(K, cp);
		}
		
		//인접 행렬에 그래프 데이터 저장 
		for(int i=0; i< M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			W[a][b] = c;
		}
		
		PriorityQueue<Node2> pq = new PriorityQueue<>();
		//출발노드를 큐에 저장한다. 이 부분은 기존 다익스트라 알고리즘과 동일하다. 최단거리 배열을 우선순위 큐로 구성한 것만 다름. 
		pq.add(new Node2(1, 0));
		distq[1].add(0);
		while(!pq.isEmpty()) {
			Node2 n = pq.poll();
			//W는 초기화 하지 않은 위치는 0으로 초기화 되어 있다. 즉, 0이 아니라는 말은 연결된 정보를 보유하고 있다는 뜻
			for(int node = 1; node <= N ; node++) {
				//시작 노드와 연결된 모든 노드 검색하기 
				if(W[n.node][node] != 0) {
					//우선순위 큐로 구성한 최단거리 배열에 저장된 경로가 K보다 작다면 그냥 추가하기 
					if(distq[node].size() < K) {
						distq[node].add(n.cost + W[n.node][node]);
						pq.add(new Node2(node, n.cost + W[n.node][node]));
						
					} else if(distq[node].peek() > n.cost + W[n.node][node]) {// 저장된 경로가 K개 이상일 때, 현재 가장 큰 값보다 작을 때만 추가하기 -> 우선순위큐를 사용해서 큐의 가장 앞부분은 가장 큰 값이 존재한다.(위에서 정렬기준을 주어서 오름차순 정렬을 했다.)
						distq[node].poll();//front의 값 삭제 
						distq[node].add(n.cost + W[n.node][node]); //신규 경로로 갱신
						pq.add(new Node2(node, n.cost + W[n.node][node]));
					}
				}
			}//end-for-node
		}//end-while
		
		//K번째 경로를 출력하기 
		for(int i=1; i<=N; i++) {
			if(distq[i].size() == K) {
				sb.append(distq[i].peek()).append('\n');
			} else { 
				sb.append(-1).append('\n');
			}
		}
		
		System.out.println(sb);
	}

}

class Node2 implements Comparable<Node2>{
	int node;//노드번호 
	int cost;//노드를 이동할 때 걸리는 시간
	Node2(int node, int cost){
		this.node = node;
		this.cost = cost;
	}
	@Override
	public int compareTo(Node2 o) {
		// TODO Auto-generated method stub
		return this.cost < o.cost ? -1 : 1;
	}

	
}
/*
	K번째 최단경로 찾기 ㅁㅊ 놈 그냥 빠른길로 가지 
	시작점과 도착점이 주어진다. 그래프에는 방향이 있다. (a -> b로 이동하는 에지가 정해져 있음)
	최단경로 배열을 우선순위 큐로 구현하자. -> 최단 경로와 더불어 최단경로부터 K번째 최단 경로 까지 우선순위에 맞추어 표현가능
	K번째 경로를 찾기 위해서 같은 노드를 중복반복해도 된다고 했다 -> 방문한 노드는 방문 배열에 표시하고, 재방문하지 않는 노드는 삭제해서 구분하자.
	
	우선순위큐로 구현하는 최단거리 배열 채우기 
	1. 현재 노드에 저장된 경로가 K개 미만일 때 신규 경로 추가 -> K번째 최단경로라는 말은 적어도 K개의 최단경로는 있어야 한다. 
	2. 경로가 K개 일때, 초기화 된 경로중 최대 경로와 신규 경로를 비교해서 신규 경로가 더 """최단거리"""일때만 최단거리 배열을 갱신한다. 
	3. 방문배열에 표시하고 재방문하지 않는 경우만 삭제한다. 
	
	
	
*/
