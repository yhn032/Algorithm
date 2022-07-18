package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class bricks{
	int x; 
	int y;
	boolean isBroken;
	int dist;
	
	public bricks() {
		super();
	}

	public bricks(int x, int y, boolean isBroken, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.isBroken = isBroken;
		this.dist = dist;
	}
}

public class _2206_���ձ� {
	static int n, m;
	static int map[][];
	static boolean visit[][][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		
		//���� �ν������� Ȯ���� 3�߹迭
		visit = new boolean[n][m][2];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
				
			}
		}
		
		
		
		BFS(0, 0);
		
	}

	private static void BFS(int x, int y) {
		// TODO Auto-generated method stub
		Queue<bricks> q = new LinkedList<bricks>();

		//�ʱ���ġ�� 0�� ����Ǿ� �ִ�. �湮üũ + �ν� ����
		visit[x][y][0] = false;
		q.add(new bricks(x, y, false, 1));

		while (!q.isEmpty()) {
			bricks now = q.poll();
			
			if(now.x == n-1 && now.y == m-1) {
				System.out.println(now.dist);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int xx = now.x + dx[i];
				int yy = now.y + dy[i];
				
				if (xx >= 0 && yy >= 0 && xx < n && yy < m) {
					
					if(map[xx][yy]== 0) {//���� �ƴϸ�
						//���� �νź��� ���ٸ� 
						if(!now.isBroken && !visit[xx][yy][0]) {
							visit[xx][yy][0] = true;
							q.add(new bricks(xx, yy, false, now.dist+1));
						}else if(now.isBroken && !visit[xx][yy][1]) {//���� �� �� �ν� ���� �ִٸ�
							visit[xx][yy][1] = true;
							q.add(new bricks(xx, yy, true, now.dist+1));
						}
					}else if (map[xx][yy] == 1) {//���̸�
						if(!now.isBroken) {//�� ���� �μ� ���� ���ٸ� �ν���
							visit[xx][yy][1] = true;
							q.add(new bricks(xx, yy, true, now.dist+1));
						}
					}
				}
			}
		}//end-while
		
		System.out.println(-1);
	}

}
