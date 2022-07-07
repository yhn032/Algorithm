package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1325_효율적인해킹2 {
	static List<ArrayList<Integer>> list;
	static int ans[];
	static int n, m;
	static boolean visit[];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ans = new int[n+1];
		
		
		list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		long start = System.currentTimeMillis();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(b).add(a);
		}
		
		//모든 노드를 방문하는 것이 중요한 것이 아니라 한 노드를 신뢰하는 노드의 ""개수""를 찾아야 한다. 
		//이 값이 최대인 경우의 노드를 해킹하면 최댓값만큼의 컴퓨터를 해킹가능
		//각 노드에서 출발했을때, 최대의 경우의수를 구해야한다.
		//방향이 있는 그래프이기 때문에 사이클을 이루지 않는다면, 특정 노드를 출발노드로 잡았을때, 탐색을 아에 하지 않는 경우가 존재할 수 있다. 
		//따라서 모든 노드를 출발점으로 잡아서 탐색을 진행해야 한다.
		for(int i=1; i<=n;i++) {
			visit = new boolean[n+1];
			BFS(i);
		}
		
		int max = Integer.MIN_VALUE;
		
		//최댓값 찾기
		for(int i=1; i<=n;i++) {
			max = Math.max(max, ans[i]);
		}
		
		for(int i=1; i <=n ; i++) {
			if(ans[i]==max) {
				System.out.print(i + " ");
			}
		}

		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000.0);
	}
	private static void BFS(int i) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<Integer>();
		visit[i] = true;
		q.add(i);
		int count = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int a : list.get(now)) {
				if(!visit[a]) {
					count++;
					visit[a] =true;
					//현재 노드 now에서 a노드로 이동할 수 있다는 것은 
					//now가 a를 신뢰한다는 뜻이다.
					q.add(a);
				}
			}
		}
		
		ans[i] = count;
	}

}

/*
	A가 B를 신뢰한다. -> A가 B를 방문한다. 
	가장 많은 컴퓨터를 해킹하기 위해서 가장 많은 노드에게 신뢰받는 노드를 찾아야 한다. 
	즉, 가장 많은 노드와 연결된 노드를 찾아야 함
	A가 B를 신뢰하는데, B가 C를 신뢰한다고 가정해보자. C를 해킹하면 C를 신뢰하는 A, B 모두 해킹할 수 있다.
*/
