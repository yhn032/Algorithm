package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1707_�̺б׷��� {
	static List<ArrayList<Integer>> list;
	static int n, m;
	static int bound[];
	static boolean isBipartite ;
	static boolean visit[];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<ArrayList<Integer>>();
			visit = new boolean[n+1];
			bound = new int[n+1];
			isBipartite = true;
			
			for(int i=0; i<=n; i++) {
				list.add(new ArrayList<Integer>());
			}
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v= Integer.parseInt(st.nextToken());
				
				list.get(u).add(v);
				list.get(v).add(u);
			}
			
			//�־��� �׷����� 1���� ����Ǿ� �ִٰ� ������ �� �����Ƿ� ��� ��忡�� Ž���غ��� ��
			for(int i=1; i<=n; i++) {
				if(isBipartite) {//�̺б׷����� �´ٸ� ��� �ؼ� ���
					DFS(i);
				}else {
					break;//�̺� �׷����� �ƴ϶�� ��Ʈ��ŷ -> Ž�� ����
				}
			}
			
			bound[1] =0;
			if(isBipartite) {
				sb.append("YES").append('\n');
			}else {
				sb.append("NO").append('\n');
			}
		}
		
		System.out.println(sb);
	}
	private static void DFS(int start) {
		// TODO Auto-generated method stub
		visit[start] = true;
		for(int i : list.get(start)) {
			if(!visit[i]) {//�湮���� �ʾҴٸ� 
				bound[i] = (bound[start]+1)%2;//�̺� ������ �����ϴ� ���� 0�� 1�� ������ ������.
				DFS(i);
			}else if(bound[i] == bound[start]) {
				//�湮�ߴµ� ���� �� ���� ���� �����̸� �̺� �׷����� �ƴϴ�. 
				isBipartite = false;
			}
		}
	}

}

/*
	������ ���� �ٸ� ���տ� ���Եǵ��� ������ �̺��ؾ� �Ѵ�.
	��� �׷����� �̾��� ���� ���� �κ� �׷����� ������ �� �����Ƿ� BFS�� �ð��� �ʹ� �����ɸ�
	���� ��͸� ����Ͽ� Ž�����ϴٰ� �̹� �湮�� ������ ���� ���� �����̶�� ������ �� ��带 �ٸ� �������� 
	�������� ���Ѱ��̹Ƿ� Ž���� �����Ѵ�. ��Ʈ��ŷ
*/