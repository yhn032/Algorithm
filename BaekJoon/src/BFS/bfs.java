package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs {
	//노드의 최대값
	static final int MAX_N = 10;
	static int N, E;
	//인접배열로 그래프 표현하기
	static int[][] Graph = new int[MAX_N][MAX_N];
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//노드의 개수
		N = sc.nextInt();
		//간선의 개수
		E = sc.nextInt();
		
		//간선의 개수가 이동할 수 있는 경로 이므로 간선의 개수만큼 반복하면서 노드의 쌍을 읽어들인다.
		for(int i=0; i<E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			//u노드에서 v노드로 갈 수 있다는 의미이므로 1로 셋. 방향성이 없는 그래프이므로 v -> u로 가능 방향도 같기 때문에 같이 1로 셋해준더ㅏ. 
			Graph[u][v] = Graph[v][u] = 1; 
		}
		//입력으로 시작노드의 위치를 전달한다.
		bfs(0);
	}



	private static void bfs(int node) {
		// TODO Auto-generated method stub
		//초기값은 false로 저장됩니다. 
		boolean []visited = new boolean[MAX_N];
		
		//자료구조로 큐를 사용
		Queue<Integer> q = new LinkedList<>();
		//푸시하기 전에 해당 위치에 방문했다는 표시를 해줍니다. 
		//DFS와는 달리 큐의 구조는 FIFO이므로 어차피 먼저  큐에 들어온 요소가 제일 먼저 나가게 됩니다.[제일 먼저 탐색을 합니다]
		//따라서 방문을 하고 나서 방문 표시를 하는 것은 동일한 요소를 큐에 또 넣은 것이기 때문에 의미가 없습니다.
		//즉, 방문 표시를 하고! enqueue한 다음! 큐에 가장 먼저 들어온 노드부터 방문을 시작합니다.
		visited[node] = true; 
		q.add(node);
		
		//큐가 빌때까지 -> 모든 노드를 탐색할 때까지
		while(!q.isEmpty()) {
			//큐에 가장 먼저 들어온 요소를 뽑아서 방문합니다. 
			int curr = q.remove();
			
			System.out.print(curr + " ");
			
			//1번 노드와 인접한 노드를 방문합니다.
			for(int next = 0; next<N;++next) {
				//방문하지 않았거나, 현재위치 curr에서 다음 위치next로 넘어갈 수 있는 경우.(간선으로 연결되어 이동할 수 있는가?) 
				//graph배열은 노드를 연결하는 간선의 여부, 즉 이동가능한 경로를 저장한 배열입니다. 
				//(0:간선x) (1:간선o)  
				if(!visited[next] && Graph[curr][next] != 0) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
	}

}
