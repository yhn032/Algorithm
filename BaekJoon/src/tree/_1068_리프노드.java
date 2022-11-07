package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1068_리프노드 {
	public static boolean visited[];
	public static int cnt = 0;
	public static ArrayList<ArrayList<Integer>> tree;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//노드 개수 0 <= n < 50
		int n = Integer.parseInt(br.readLine());
		
		visited = new boolean[n];
		//각 노드의 부모노드를 기억할 배열 
		//노드번호는 0번 부터 시작한다. 
		//값이 -1인 노드가 루트 노드이다.
		
		int root = 0;
		int parent[] = new int[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			parent[i] = Integer.parseInt(st.nextToken());
			if(parent[i] == -1) root = i;
		}
		
		//지울 노드 번호
		int remove = Integer.parseInt(br.readLine());
		
		if(remove == root) {
			System.out.println(0);
			return;
		}
		
		//양방향으로 인접 리스트를 구성할 건데, 특정 노드의 번호가 삭제하는 노드의 번호와 일치하는 경우 건너 뛰고 구성하기 
		//-> parent배열은 인덱스값을 노드번호로 갖는 번호가 연결된 부모 노드의 번호이다. 즉 부모노드의 번호가 삭제번호와 일치한다면
		//그 밑에 딸린 자식 노드는 삭제되기 때문에 트리로 구성할 필요가 없다는 것이다. 
		tree = new ArrayList<ArrayList<Integer>>(n);
		for(int i=0 ; i<n; i++) {
			tree.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<n; i++) {
			if(parent[i] == -1 || i == remove) continue;
			
			int temp = parent[i];
			tree.get(i).add(temp);
			tree.get(temp).add(i);
		}
		
		dfs(root);
		
		System.out.println(cnt);
	}

	private static void dfs(int node) {
		visited[node] = true;
		
		int can = 0;
		for(int i : tree.get(node)) {
			if(visited[i]) continue;
			
			can++;
			dfs(i);
		}
		
		if(can == 0) cnt++;
		
	}
}
