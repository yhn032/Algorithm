package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5547_�Ϸ�̳��̼� {
								//��       �»�       ��      ����    ����    ���
	static int moveOdd[][]  = { {0, -1}, { -1,  0}, {0, 1}, {1, 1}, {1,  0}, {-1, 1}};//Ȧ�� ��
	static int moveEven[][] = { {0, -1}, { -1, -1}, {0, 1}, {1, 0}, {1, -1}, {-1, 0}};//¦�� ��
	static int map[][];
	static int isInjac[][];
	static boolean visit[][];
	static int w, h;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//��(w), ��(h)
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map     = new int[h+2][w+2];
		isInjac = new int[h+2][w+2];
		visit   = new boolean[h+2][w+2];
		
		for(int i=1; i<=h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					visit[i][j] = true;
				}
			}
		}
		
		//�ǹ��� ������ �ܺ��� ǥ���ϱ�
		//1. �ǹ��� ��ġ�� �������� ����� �ǹ��� Ž���ϸ鼭 ������ �ǹ��� 1�� �ƴ� 0�� �ǹ��� üũ�ϸ� �ǹ� �ܺθ� üũ�� �� ������
		//�ǹ� ���α��� ���Եȴٴ� ������ �����Ѵ�. �� ������ �ٽ��� �ǹ��� ������ �ƴ� �ܺ����� üũ�ؾ� �Ѵٴ� ���̴�.
		//2. ���� ��� ���� Ž���ϸ鼭 ���� ��ġ���� ���������� �̵��� �� �ִ� ��츦 Ž���ϸ鼭 1�� ��쿡�� ���� ��ġ�� ��ŷ�� �Ѵ�. 
		//3. ���� ��ġ�� 1�̶�� ������ ��ŷ�� �� �����Ƿ� �ǳʶڴ�. ������ġ�� �ݵ�� 0�϶��� �����ϴ�.
		
		//Ž���� ���ؼ� 0, h+2, w+2��� ������ ����������, �̰����� �ǹ��� ���� ������ Ž���� �����θ� �� �� bfsŽ���� ��󿡼� �����Ѵ�.
		//�ܺ��� ��ġ�� �ǹ��� Ž�� ����������� �����Ѵ�.
		/*
		for(int i=0; i<= h+1; i++) {
			for(int j=0; j<= w+1; j++) {
				if(map[i][j] == 1) continue;
				if(!visit[i][j]) {
					bfs(i, j);
				}
			}
		}*/
		bfs(0,0);
		
		int ans = 0;
		for(int i=0; i<isInjac.length; i++) {
			for(int j=0; j<isInjac[i].length; j++) {
				if(isInjac[i][j] == 0) continue;
				ans += isInjac[i][j];
			}
		}
		
		System.out.println(ans);
		
		/*
		 * for(int a[] : isInjac) { for(int aa : a) { System.out.print(aa + " "); }
		 * System.out.println(); }
		 */
	}
	
	private static void bfs(int x, int y) {
		// TODO Auto-generated method stub
		Queue<hex> q = new LinkedList<hex>();
		q.add(new hex(x, y));
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			hex now = q.poll();
			int nextX = 0;
			int nextY = 0;
			
			for(int i=0; i<6; i++) {
				if(now.x % 2 == 0) {//������ġ�� y�� ¦�����
					nextX = now.x + moveEven[i][0];
					nextY = now.y + moveEven[i][1];
				}else {//���� ��ġ�� y�� Ȧ�����
					nextX = now.x + moveOdd[i][0];
					nextY = now.y + moveOdd[i][1];
				}
				
				//���� �����ϱ�
				if(nextX <0 || nextY < 0 || nextX >= h+2 || nextY >= w+2) continue;
				
				if(map[nextX][nextY] == 1) {
					isInjac[now.x][now.y]++;
					continue;
				}
				
				if(visit[nextX][nextY] || isInjac[nextX][nextY] != 0) continue;
				
				
				visit[nextX][nextY] = true;
				q.add(new hex(nextX, nextY));
				
			}
		}
	}
}
class hex{
	int x, y;
	public hex(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
/*
	������ġ(x, y)
	������ -> (x+1, y)
	��  �� -> (x-1, y)
	y�� Ȧ���� ��, 
	�Ʒ��� -> (x, y+1)
	��  �� -> (x, y-1)
	y�� ¦���� ��, 
	�Ʒ��� -> (x, y+1)
	��  �� -> (x, y-1)
*/
