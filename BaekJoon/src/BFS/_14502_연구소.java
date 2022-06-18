package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14502_������ {
	
	static int [][]map;			//���� ��
	static int [][]copy;		//���纻
	static int [][]virus_map; 	//bfs�� ��
	static boolean [][]visit;
	static int n,m;
	static List<Virus> virus;
					  //�� �� �� ��
	static int dx[] = {-1, 1,  0, 0};
	static int dy[] = { 0, 0, -1, 1};
	static int max = 0; //�������� ���� ���� ������ ���� �� ����
	
	static class Virus{
		int x, y;
		public Virus() {
			super();
		}
		public Virus(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st=  new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map  = new int[n][m];
		copy = new int[n][m]; //���� ���¸� �����ϱ� ���� ���纻�� ���� �� �迭�� ���� �����.
		virus = new ArrayList<Virus>(); //���̷����� ��ġ�� ������ ����Ʈ
		
		
		//map�� ���纻 �ʱ�ȭ
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0; k<m;k++) {
				copy[i][k] = map[i][k] = Integer.parseInt(st.nextToken());
				if(map[i][k] == 2) {
					virus.add(new Virus(i, k));//���̷����� ��ġ�� ��� ����ش�.
				}
			}
		}
		
		//��͸� �����ϸ鼭 ���� ��������.
		for(int i=0; i<n; i++) {
			for(int k=0; k<m; k++) {
				if(map[i][k]==0) {//���� ���� ���ٸ�,,,
					copy[i][k] = 1;
					dfs(1);
					copy[i][k] = 0; //��Ͱ� ������ ���ƿ��� �ٸ� ����� ���� ���ؼ� ���� �ν��ش�.
					
				}
			}
		}
		
		System.out.println(max);
		
	}
	
	private static void dfs(int wall) {
		// TODO Auto-generated method stub
		if(wall == 3) {
			//3���� ���� ��� ������ bfsŽ���� �����غ���
			bfs();
			return;
		}
		
		//������ 2���� ���� �� �����. ������ ���ϴ� �˰����� �����Ѵ�.
		for(int i=0; i<n; i++) {
			for(int k=0; k<m; k++) {
				if(copy[i][k]==0) {//���� ���� ���ٸ�,,,
					copy[i][k] = 1;
					dfs(wall+1);
					copy[i][k] = 0; //��Ͱ� ������ ���ƿ��� �ٸ� ����� ���� ���ؼ� ���� �ν��ش�.
					
				}
			}
		}
		
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		//�湮�迭�� �ʱ�ȭ���� �� ���� bfs�� �����Ҷ����� ���� �����
		visit = new boolean[n][m];
		Queue<Virus> q = new LinkedList<>();
		
		//�̸� ���ο��� �����ϸ� bfs�� �������� ���Ӱ� �ʱ�ȭ�� ���־�� �ϹǷ� �׳� ���⼭ �����Ѵ�.
		virus_map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				virus_map[i][j] = copy[i][j];
			}
		}
		
		//���� �Է¹��� ��, ������ ���̷����� ��ġ�� ť�� �����Ѵ�. �̰� �丶��� ���� ������� Ž���ϸ� �� ��
		for(int i=0; i<virus.size(); i++) {
			Virus v = virus.get(i);
			visit[v.x][v.y] = true;
			q.add(new Virus(v.x, v.y));
		}
		
		while(!q.isEmpty()) {
			Virus now = q.poll();
			
			for(int i=0; i<4; i++) {
				int xx = now.x + dx[i];
				int yy = now.y + dy[i];
				
				if(xx < 0 || yy < 0 || xx >= n || yy >= m ) continue;
				if(visit[xx][yy]) continue;
				
				if(virus_map[xx][yy] == 0) {//���� �ƴ϶��
					visit[xx][yy] = true;
					virus_map[xx][yy] = 2;
					q.add(new Virus(xx, yy));
				}
			}
		}
		
		countSafeArea();
	}

	private static void countSafeArea() {
		// TODO Auto-generated method stub
		int cnt = 0;
		for(int i=0; i<n;i++) {
			for(int j=0; j<m; j++) {
				if(virus_map[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		max = Math.max(max, cnt);
	}

}

/*
 	���� ���� ��ġ �������� Ž���ؾ�- �Ѵ�. 
 	���������� �ִ� -> ���̷����� �ּҷ� ������ ���ƾ� �Ѵ�.
 	���� ���� ���� DFS�� ������ ���ϴ� ����Ǽ��� �������� 
 	�� ������ ���̷����� ������ Ž�������� BFS�� �ϴ� ���� ���� ��
*/
