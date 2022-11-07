package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1068_������� {
	public static boolean visited[];
	public static int cnt = 0;
	public static ArrayList<ArrayList<Integer>> tree;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//��� ���� 0 <= n < 50
		int n = Integer.parseInt(br.readLine());
		
		visited = new boolean[n];
		//�� ����� �θ��带 ����� �迭 
		//����ȣ�� 0�� ���� �����Ѵ�. 
		//���� -1�� ��尡 ��Ʈ ����̴�.
		
		int root = 0;
		int parent[] = new int[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			parent[i] = Integer.parseInt(st.nextToken());
			if(parent[i] == -1) root = i;
		}
		
		//���� ��� ��ȣ
		int remove = Integer.parseInt(br.readLine());
		
		if(remove == root) {
			System.out.println(0);
			return;
		}
		
		//��������� ���� ����Ʈ�� ������ �ǵ�, Ư�� ����� ��ȣ�� �����ϴ� ����� ��ȣ�� ��ġ�ϴ� ��� �ǳ� �ٰ� �����ϱ� 
		//-> parent�迭�� �ε������� ����ȣ�� ���� ��ȣ�� ����� �θ� ����� ��ȣ�̴�. �� �θ����� ��ȣ�� ������ȣ�� ��ġ�Ѵٸ�
		//�� �ؿ� ���� �ڽ� ���� �����Ǳ� ������ Ʈ���� ������ �ʿ䰡 ���ٴ� ���̴�. 
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
