package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _24479 {
	static boolean visited[];
	static ArrayList<Integer> list[];
	static int answer[];//�湮�� ������ ������� �迭
	static StringBuilder sb = new StringBuilder();
	static int index;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		
		//����
		int n = Integer.parseInt(st.nextToken());
		//����
		int m = Integer.parseInt(st.nextToken());
		//���� ����
		int r = Integer.parseInt(st.nextToken());
		
		//���� ������ ������ ����Ʈ 
		list = new ArrayList[n+1];
		visited = new boolean[n+1];
		answer = new int[n+1];
		
		for(int i=1; i<list.length;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			list[n1].add(n2);
			list[n2].add(n1);
			
		}
		
		for(int i=1; i<list.length;i++) {
			Collections.sort(list[i]);
		}
		
		visited[r] = true;
		dfs(r);

		for(int i=1; i<=n ; i++) {
			sb.append(answer[i]).append('\n');
		}
		System.out.println(sb);
	}
	private static void dfs(int r) {
		// TODO Auto-generated method stub
		answer[r] = ++index;
		
		for(int k : list[r]) {
			if(!visited[k]) {//���� �湮���� �ʾҰ�, ���� ��尡 ���� ��庸�� ���� ��� 
				visited[k] = true;
				dfs(k);
			}
		}
	}

}


