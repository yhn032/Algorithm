package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7576_�丶�� {
	static int n, m;
	static boolean visit[][];
	static int map[][]; 
	static Queue<int []> q = new LinkedList<int[]>();
	//	�� ��  �� ��
	static int dx[] = {-1, 1,  0, 0};
	static int dy[] = { 0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		//���ΰ��� -> y
		m = Integer.parseInt(st.nextToken());
		//���ΰ��� -> x
		n = Integer.parseInt(st.nextToken());
		
		//0 ������ �丶��, 1 ���� �丶��, -1 �� ĭ
		
		map = new int[n][m];
		visit = new boolean[n][m];
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a == -1) {//-1�� ���� ������ �湮�� �� ������ �湮 ó�� �صα�
					visit[i][j] = true;
				}
				
				//������ �⺻������ 0�̱� ������ -1�� 1�϶��� �迭�� ���� �ʱ�ȭ
				if(a == -1 || a == 1) {
					map[i][j] = a;
				}
				
				//�丶���� ��ġ�� ��� ť�� ��Ƶд�.
				if(a == 1) {
					visit[i][j] = true;
					q.add(new int[] {i, j});
				}
			}
		}
		
		if(q.size() == 0) {
			System.out.println(-1);
			System.exit(0);
		}else if(q.size() == n*m) {
			System.out.println(0);
			System.exit(0);
		}
		
		int start[] = q.peek();
		BFS(start[0], start[1]);
		
		
		int max = 0;
		for(int i[] : map) {
			for(int a : i) {
				max = max < a ? a : max;
			}
		}
		
		
		if(checkTomato(map)) {
			System.out.println(max-1);
		}else {
			System.out.println(-1);
		}
		
		
	}
	private static boolean checkTomato(int[][] map2) {
		// TODO Auto-generated method stub
		for(int i[] : map2) {
			for(int a : i) {
				if(a == 0) {
					return false;
				}
			}
		}
		
		return true;
	}
	private static void BFS(int startX, int startY) {
		// TODO Auto-generated method stub
		
		
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			
			
			for(int i=0; i<4; i++) {
				   
				int x = cur[0] + dx[i];
				int y = cur[1] + dy[i];
				if(x >=0 && y >=0 && x < n && y <m) {
					if(!visit[x][y] && map[x][y] == 0) {
						visit[x][y] = true;
						map[x][y] = map[cur[0]][cur[1]]+1;
						q.add(new int[] {x, y});
					}
				}
			}
		}
	}

}
