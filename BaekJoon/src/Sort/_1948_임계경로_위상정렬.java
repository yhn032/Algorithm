package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1948_임계경로_위상정렬 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//도시의 수(노드)n, 도로의 수(간선)m
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		//인접리스트 생성 및 초기화
		List<ArrayList<node>> list 		  = new ArrayList<ArrayList<node>>();
		List<ArrayList<node>> list_reverse = new ArrayList<ArrayList<node>>();
		
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<node>());
			list_reverse.add(new ArrayList<node>());
		}
		
		//진입차수 배열 생성 및 초기화 
		int []inDegree = new int[n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			//출발노드 a, 다음노드 b, 가중치 e
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.get(a).add(new node(b, e));
			list_reverse.get(b).add(new node(a, e));
			inDegree[b]++;
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end   = Integer.parseInt(st.nextToken());
		
		//위상 정렬 수행하기 
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);//일반적인 위상정렬과는 다르게 시작점을 정하고 시작해야 한다. 
		
		//시작지점에서 출발해 도착지점을 도착할 때까지 거칠 수 있는 모든 경로 중에서(이동시간이 가장 긴 경로의 시간을 저장) -> 가장 마지막에 도착하는 사람은 누구?
		int []ans = new int[n+1];
		while(!q.isEmpty()) {
			int now = q.poll();
			for(node next : list.get(now)) {
				inDegree[next.nextNode]--;
				
				//							다음위치까지의 시간		현재시간 + 두 노드를 이동하는데 걸리는 시간 중 최댓값을 저장한다.
				ans[next.nextNode] = Math.max(ans[next.nextNode], ans[now] + next.val);
				
				if(inDegree[next.nextNode]==0) {
					q.add(next.nextNode);
				}
			}
		}
		
		//위의 위상정렬의 결과로 가장 오래걸리는 결과가 ans[end]에 저장되었다. 
		
		//이제 임계경로(1분도 쉬지않아야 하는 도로로 이동하는 경우의 수)를 구하자
		//1분도 쉬지않아야 하는 도로와 연결된 노드만이 결과갑의 후보이다. 중복방문을 방지해야 한다. 
		//에지 뒤집기 아이디어를 활용. 도착 도시를 출발점으로 하여 거꾸로 위상정렬을 수행한다.
		int ansCnt=0;
		boolean visit[] = new boolean[n+1];
		
		q = new LinkedList<Integer>();
		q.add(end);
		visit[end] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(node next : list_reverse.get(now)) {
				//정방향으로 탐색을 하면서 최장 거리에 대한 시간을 ans배열에 누적시켜왔다.
				//지금은 역방향으로 탐색하고 있기 때문에, ans[현재]값이 ans[이전노드] + 사이의 엣지와 같다면 지금 연결된 노드가 임계경로에 포함되는 거리라는 뜻이다. 
				if(ans[now] == ans[next.nextNode] + next.val) {
					ansCnt++;
					
					
					//중복 방지 방문 처리
					if(!visit[next.nextNode]) {
						visit[next.nextNode] = true;
						q.add(next.nextNode);//다음 경로로 저장
					}
				}
			}
		}
		
		
		System.out.println(ans[end]);
		System.out.println(ansCnt);
	}

}
class node{
	int nextNode, val;

	public node(int nextNode, int val) {
		super();
		this.nextNode = nextNode;
		this.val = val;
	}
}