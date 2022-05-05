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
		
		//����(���)�� �������� �ϳ� �� ũ��. ����� ��ȣ�� ���缭 0������ ������ ������ �׷��� ���ذ� ����
		check_dfs = new boolean[N+1];
		check_bfs = new boolean[N+1];
		sequence = new ArrayList[N+1];
		answer_bfs = new int[N+1];
		answer_dfs = new int[N+1];
		
		q_dfs = new LinkedList<Integer>();
		q_bfs = new LinkedList<Integer>();

		//��������Ʈ �����ϱ�
		for(int i=1; i<=N;i++) {
			sequence[i] = new ArrayList<>();
		}
		
		//��������Ʈ �ʱ�ȭ�ϱ� 
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
		
		//dfs�����ϱ� 
		q_dfs.add(V);
		sb1 = new StringBuilder();
		DFS(V);
		while(!q_dfs.isEmpty()) {
			sb1.append(q_dfs.poll()).append(' ');
		}
		
		//bfs�����ϱ� 
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
		
		//ť�� ������ ��� �������� �ݺ��ض�
		while(!q_bfs.isEmpty()) {
			int node = q_bfs.poll();
			sb2.append(node).append(' ');
			for(int k : sequence[node]) {
				//���� �湮���� �ʾҴٸ�,,,
				if(!check_bfs[k]) {
					check_bfs[k] = true;
					q_bfs.add(k);
				}
			}
		}
		/*
		 * //start���� 3������ �����ؾ��ϴµ� ���� ���Ű��� 1������ Ž������ �׷��� ��������Ʈ ������ �ȿ��� for(int i=1;
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
		
		//seq��� ����Ʈ���� start������ �ִ� ���� ����� ��̸���Ʈ�� ��ҵ��� �ϳ��� ������(=�������) 
		for(int k : sequence[start]) {
			//���� �湮���� ���� ���̶��
			if(!check_dfs[k]) {
				q_dfs.add(k);
				DFS(k);
			}
		}
	}
	/*
	 * 
		DFS 
		1. �湮�迭�� true
		2. ��������Ʈ�󿡼� ���� ��忡 ������ ��� �� �湮���� ���� ����ȣ�� ���ڷ� ��Ƽ� DFSŽ��
		
		BFS
		1. �湮�迭�� true
		2. ���� ��带 enqueue
		3. ť�� �������� �ݺ�
		4. ť�� front�� �ִ� ���� poll
		5. 4���� ���� ���� ������ ����� �湮���� ���� ��� enqueue(������ ��������Ʈ�� �ε����� �Ѵ�. )
		6. �ݺ��� ���鼭 ���ο� ��Ҹ� enqueue�ϴ��� �̹� �տ��� ť�� ��Ұ� ���Ա� ������ ���� ���� ��ҵ��� ���� Ž���˴ϴ�.
	*/

}

