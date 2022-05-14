package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178_�̷� {
	static int N, M;
	static boolean visited[][];
	//				   �� ��  ��  ��
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};
	static int map[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int k=0; k<M; k++) {
				map[i][k] = str.charAt(k)-'0';
			}
		}
		
		/*
		 * for(int i=0; i<N; i++) { for(int k=0; k<M; k++) { System.out.print(map[i][k]
		 * + " "); } System.out.println(); }
		 */
		
		
		BFS(0,0);//�������� Ž�� ����
		
		System.out.println(map[N-1][M-1]);
		
	}
	private static void BFS(int i, int j) {
		// TODO Auto-generated method stub
		Queue<int[]> q = new LinkedList<>(); //�湮�ϴ� ���� x,y�ε��� ���� �����Ѵ�.
		q.add(new int[] {i, j});
		
		//������ �湮 ������ �ε����� �߰��ϴٰ� ť�� �������� �ݺ� �ѹ��� �ݺ�����(����) �湮�ϴ� ���� ���� �ݺ�Ƚ���� �ʱ�ȭ ���ٰŴ�.
		//������ �湮�� ���� �ٽ� �湮���� �������� �湮 �迭�� ����� ������ �ʱ⿡ ���� �˻��Ҷ��� 1�̸� �� -> ��������δ� ���° �湮���� �ش� ��带 Ž���ߴ��� ����ϰ��� ���̰� 
		//�������� �����ؼ� ī��Ʈ�϶�� �ߴµ�, ���Ǿƴϰ� �̵��� �� �ִ� ������ 1�� ���õǾ� �ֱ� ������ �׳� +1�� ���ָ� ��
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			visited[i][j] = true;
			for(int k=0; k<4;k++) {//�����¿쿡�� �̵��� �� �ִ� ��� Ž��
				int x = cur[0] + dx[k];
				int y = cur[1] + dy[k];
				
				if(x >= 0 && y >= 0 && x < N && y < M) { //��ǥ�� ����� �ʴ´ٸ�, 
					if(map[x][y] == 1 && !visited[x][y]) {
						visited[x][y] = true;
						map[x][y] = map[cur[0]][cur[1]] + 1; //�̵� Ƚ���� ��Ÿ���� ���� ���� ��ġ�� ������ +1 ���ش�.
						q.add(new int[] {x, y});
					}
					
				}
			}
		}
	}

}

