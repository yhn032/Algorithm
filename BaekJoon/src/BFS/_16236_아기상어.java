package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16236_�Ʊ��� {
	static int n;							//map�� ũ��
	static int eatCnt = 0;					//�Ʊ�� ���� ����� ��
	static int minX, minY, minDist;			//���� ��ġ���� �̵��� �� �ִ� �ּҰŸ�, �׶��� x,y��ǥ
	static int map[][];						//Ž���� ������ map
	static int dist[][];					//�湮 üũ �� �ִ� �Ÿ� ���� �迭
	static int dx[] = {-1, 1,  0, 0};		//�����¿� �̵�(x)
	static int dy[] = { 0, 0, -1, 1};		//�����¿� �̵�(y)
	static int count=0;						//�Ʊ� ����� ��ü �̵� �ð�
	static int size = 2;					//�ʱ� �Ʊ� ����� ũ��
	static int INF = Integer.MAX_VALUE;	//�ּڰ��� ã�� ���� �ʱ갪
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		int sharkX = 0;
		int sharkY = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {//�Ʊ� ����� ��ġ
					sharkX = i;
					sharkY = j;
					map[i][j] = 0;
				}
			}
		}
		
		int time = eatFish(sharkX, sharkY);
		
		System.out.println(time);
		
	}
	private static int eatFish(int sharkX, int sharkY) {
		// TODO Auto-generated method stub
		while(true) {
			//�湮üũ�� �Ÿ��迭
			dist = new int[n][n];
			minX = INF;
			minY = INF;
			minDist = INF;
			
			//Ž���ϸ鼭 �Ÿ��迭 �ֽ�ȭ
			bfs(sharkX, sharkY);
			
			if(minX != INF && minY != INF) {//���� ���ŵǾ��ٸ� -> ���� �� �ִ� ����⸦ ã�Ҵٸ�
				eatCnt++;
				map[minX][minY] = 0;
				sharkX = minX;
				sharkY = minY;
				count += minDist;
				
				if(eatCnt == size) {
					size++;
					eatCnt = 0;
				}
			}else {//���� ���ŵ��� �ʾҴٸ� -> ���� �� �ִ� ����⸦ ã�� ���ߴٸ�
				return count;
			}
		}
	}
	
	private static void bfs(int sharkX, int sharkY) {
		// TODO Auto-generated method stub
		Queue<position> q = new LinkedList<position>();
		q.add(new position(sharkX, sharkY));
		
		while(!q.isEmpty()) {
			position now = q.poll();
			
			for(int i=0; i<4; i++) {
				int xx = now.x + dx[i];
				int yy = now.y + dy[i];
				
				
				//�迭 ���� ���̸� skip, ����Ⱑ ���� ũ�ų�, �̹� �ִܰŸ��� ǥ�õǾ� ������ skip
				if(xx < 0 || yy < 0 || xx >= n || yy >= n) continue;
				if(map[xx][yy] > size || dist[xx][yy] != 0) continue; 
				
				dist[xx][yy] = dist[now.x][now.y] + 1;
				
				if(map[xx][yy] != 0 && map[xx][yy] < size) {//���� �� �ִ� �������
					
					if(minDist > dist[xx][yy]) {//���� ����� �Ÿ����(������ �ִܰŸ� ���� �۴ٸ�)
						minDist = dist[xx][yy];
						minX = xx;
						minY = yy;
						
					}else if(minDist == dist[xx][yy]) {//���� �ִܰŸ��� �Ÿ��� �����ϴٸ� -> �Ÿ��� ����� ����Ⱑ �����������,
						if(minX == xx) {//���� ���� �ִ� ����Ⱑ �켱������ ������ �� �͵� ����������� ���� ���ʿ� �ִ� ����Ⱑ �켱. -> ���� �� �������� ���ʿ� �ִ�.
							if(minY > yy) {
								minX = xx;
								minY = yy;
							}
						}else if(minX > xx) {//���� ���� �ִ� ����Ⱑ �켱 ������ ����.
							minX = xx;
							minY = yy;
						}
					}
					
				}
				q.add(new position(xx, yy));
			}
		}
	}
}

class position{
	int x, y;
	public position(int x, int y) {
		this.x = x; 
		this.y = y;
	}
}
/*
	�� ���� ũ���� ����⸸ ���� �� �ִ�. 
	���� ũ���� ������ ���� �� �� �ִ�. 
	�� ū ũ���� ������ ���� �� ����. 
	�ڽ��� ũ�⸸ŭ�� ������ �Ծ�� ũ�Ⱑ �����Ѵ�. 3�� ��� 3������ �Ծ�� ũ�� ��
	�������� ������� ���� �ð����� ������ �� �ִ°�? 
*/
