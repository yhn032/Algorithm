package DFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1260_DFS_BFS {
	static Queue<Integer> q_dfs;
	static Queue<Integer> q_bfs;
	static int answer_dfs[];
	static int answer_bfs[];
	static boolean check_dfs[];
	static boolean check_bfs[];
	static StringBuilder sb1;
	static StringBuilder sb2;
	static ArrayList<Integer> sequence[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		int V = Integer.parseInt(st.nextToken());
		
		//정점(노드)의 개수보다 하나 더 크게. 노드의 번호에 맞춰서 0번지는 버리고 갈거임 그래야 이해가 편함
		check_dfs = new boolean[N+1];
		check_bfs = new boolean[N+1];
		sequence = new ArrayList[N+1];
		answer_bfs = new int[N+1];
		answer_dfs = new int[N+1];
		
		q_dfs = new LinkedList<Integer>();
		q_bfs = new LinkedList<Integer>();

		//인접리스트 구성하기
		for(int i=1; i<=N;i++) {
			sequence[i] = new ArrayList<>();
		}
		
		//인접리스트 초기화하기 
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			sequence[n1].add(n2);
			sequence[n2].add(n1);
		}
		
		for(int k=1; k<=N;k++)
		{
			Collections.sort(sequence[k]);
		}
		
		/*
		 * for(ArrayList<Integer> list : sequence) { System.out.println(list); }
		 */
		
		//dfs실행하기 
		q_dfs.add(V);
		sb1 = new StringBuilder();
		DFS(V);
		while(!q_dfs.isEmpty()) {
			sb1.append(q_dfs.poll()).append(' ');
		}
		
		//bfs실행하기 
		sb2 = new StringBuilder();
		BFS(V);
		while(!q_bfs.isEmpty()) {
			sb2.append(q_bfs.poll()).append(' ');
		}
		
		
		
		
		System.out.println(sb1);
		System.out.println(sb2);
	}
	private static void BFS(int start) {
		// TODO Auto-generated method stub
		check_bfs[start]=true;
		q_bfs.add(start);
		
		//큐의 내용이 모두 빌때까지 반복해라
		while(!q_bfs.isEmpty()) {
			int node = q_bfs.poll();
			sb2.append(node).append(' ');
			for(int k : sequence[node]) {
				//아직 방문하지 않았다면,,,
				if(!check_bfs[k]) {
					check_bfs[k] = true;
					q_bfs.add(k);
				}
			}
		}
		/*
		 * //start값인 3번부터 시작해야하는데 나는 병신같이 1번부터 탐색했음 그러니 인접리스트 만든대로 안오지 for(int i=1;
		 * i<=sequence.length-1;i++) { for(int k=0; k<sequence[i].size();k++) {
		 * if(!check_bfs[sequence[i].get(k)]) { check_bfs[sequence[i].get(k)] = true;
		 * q_bfs.add(sequence[i].get(k)); } }
		 * 
		 * }
		 */
		
		
		
	}
	private static void DFS(int start) {
		// TODO Auto-generated method stub
		check_dfs[start] = true;
		
		//seq어레이 리스트에서 start번지에 있는 값에 저장된 어레이리스트에 요소들을 하나씩 가져옴(=인접노드) 
		for(int k : sequence[start]) {
			//아직 방문하지 않은 곳이라면
			if(!check_dfs[k]) {
				q_dfs.add(k);
				DFS(k);
			}
		}
	}
	/*
	 * 
		DFS 
		1. 방문배열에 true
		2. 인접리스트상에서 현재 노드에 인접한 노드 중 방문하지 않은 노드번호를 인자로 삼아서 DFS탐색
		
		BFS
		1. 방문배열에 true
		2. 시작 노드를 enqueue
		3. 큐가 빌때까지 반복
		4. 큐에 front에 있는 내용 poll
		5. 4에서 얻은 값과 인접한 노드중 방문하지 않은 노드 enqueue(접근은 인접리스트의 인덱스로 한다. )
		6. 반복을 돌면서 새로운 요소를 enqueue하더라도 이미 앞에서 큐에 요소가 들어왔기 때문에 먼저 들어온 요소들이 먼저 탐색됩니다.
	*/

}

