package BellmanFordMoore;

/*
	기능 : 특정 출발 노드에서 다른 모든 노드까지의 최단 경로 탐색
	특징 : 에지의 가중치가 음수여도 수행 가능 
		   전체 그래프에서 음수 가중치 존재 여부 파악 가능
		   에지를 중심으로 동작하므로 에지리스트로 구현
	시간 복잡도 : O(VE)
	
	원리
	1. "에지리스트"로 그래프를 구현하고 최단경로 배열 초기화 
		최단거리 배열에서 업데이트 횟수는 (노드 개수 - 1)
		음수 사이클이 없다면, N개의 수를 최단거리로 연결하기 위해 구성할 수 있는 에지의 최대 개수는 N개의 노드를 1자로 쭉 늘여놓고 연결하는 방법(사향트리)으로 N-1이다. 
	
	2. 모든 에지를 확인하면서 정답 배열 업데이트 
		업데이트 조건. 출발노드s, 종료노드e, 가중치w
		★ 최단 거리 배열의 값이 무한대이며, e까지의 최단 경로 > s까지의 최단 경로 + 둘 사이의 거리(w)이면 업데이트 한다.
		★ 음수 "사이클"이 없다면 N-1번 에지 사용횟수를 반복하면 출발노드와 모든 노드간의 최단거리를 알려주는 정답배열 완성.
		그래프를 완성한 후에 음수 사이클이 있는지 반드시 확인할 것
		
	3. 음수 사이클 유무 확인
		모든 에지를 한 번씩 다시 사용해 업데이트 되는 노드가 발생한다면 -> 음수값으로 반복되는 사이클이 있다는 뜻이다.
		위의 경우 2단계에서 시도한 방법이 무의미한 방법이 되고, 최단 거리를 찾을 수 없는 그래프라는 뜻이다.
		
		음수 사이클이 존재하면 이 사이클을 무한하게 돌수록 가중치가 계속 감소하기 때문에 최단 거리를 구할 수 없다. 
		특정 출발 노드에서의 나머지 모든 노드까지의 최단거리를 구하는 것이므로, 어디에서 출발하는지에 따라 음수 사이클을 지날수도 있고 안지날수도 있다. 
		따라서 반드시 음수 사이클 유무를 확인해야 한다.
		
		실제 코테에서는 최단거리 알고리즘으로 벨만 포드를 쓰기보다는 음수 사이클의 유무를 확인하는데 더 빈번하게 출제 된다.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11657_타임머신 {
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		//도시의 수n (정점), 버스노선의 수 m(에지)
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		//에지의 정보를 저장할 배열(에지리스트), 최단거리를 저장할 배열
		edge []edges = new edge[m+1];
		long []dist  = new long[n+1];
		
		//최단거리배열 무한대값으로 초기화 
		Arrays.fill(dist, INF);
		
		//에지리스트 초기화
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end   = Integer.parseInt(st.nextToken());
			int val   = Integer.parseInt(st.nextToken());
			edges[i] = new edge(start, end, val);
		}
		
		//벨만-포드 수행 -> 특정 노드에서 출발해서 모든 노드에 대한 최단거리 구하기 
		
		dist[1] = 0;//시작노드의 최단거리는 0
		for(int i=1; i<n; i++) {//반복횟수는 n-1이라고 했다. 
			for(int k=0; k<m; k++) {
				edge e = edges[k];//최단거리 배열을 채워줄 것이다.   
				
				if(dist[e.start] != INF && dist[e.end] > dist[e.start] + e.val) {
					dist[e.end] = dist[e.start] + e.val;
				}
			}
		}
		
		boolean isCycle = false;
		
		//음수 사이클 여부 확인하기 -> 완성된 정답 배열을 기준으로 모든 에지에 대해 다시 탐색해서 갱신이 이루어지면 음수사이클이 존재하는 것임
		for(int i=0; i<m; i++) {
			edge e = edges[i];
			
			if(dist[e.start] != INF && dist[e.end] > dist[e.start] + e.val) {
				isCycle = true;
			}
		}
		
		if(!isCycle) {//음수 사이클이 없다면,,,
			for(int i=2; i<=n; i++) {//1번노드에서 출발했으므로 2번노드부터 출력
				//1->2, 1->3, 1->4의 경우의수를 비교해보는 것이다. 
				if(dist[i] == INF) {
					sb.append(-1).append('\n');
				}else {
					sb.append(dist[i]).append('\n');
				}
				
				
			}
			
		}else {//음수 사이클이 존재한다면,,, 
			sb.append(-1).append('\n');
			
		}
		
		System.out.println(sb);
	}

}

class edge{
	int start, end, val;

	public edge(int start, int end, int val) {
		super();
		this.start = start;
		this.end = end;
		this.val = val;
	}
}

