package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2667_������ȣ {
	//					   �� ��  ��  ��
	static int moveX[] = {-1, 1,  0,  0};
	static int moveY[] = { 0, 0, -1,  1};
	static boolean [][]visit;
	static int [][]danji;
	static int n;
	static int danjiNum=0;
	static int count=0;
	//���� ������ ���Ե� ����Ʈ�� ������ ������ �迭 
	static int apart[];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		danji = new int[n][n];
		
		visit = new boolean[n][n];
		apart = new int[n*n];
		
		//�� �ʱ�ȭ
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				danji[i][j] = str.charAt(j)-'0';
				if(danji[i][j] == 0) {
					visit[i][j] = true; //���� ���ٸ� �̸� �湮ó���� �ص����ν� ���Ŀ� �湮 üũ�� �Ҷ� ������� ����ȭ ��Ų��.
				}
			}
		}
		
		/*
		 * for(int i[] : danji) { for(int a : i) { System.out.print(a + " "); }
		 * System.out.println(); }
		 */
		
		//Ž�� ���� 
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visit[i][j]) {
					danjiNum++;
					count=0;
					bfs(i,j);
				}
			}
		}
		
		Arrays.sort(apart);
		sb.append(danjiNum).append('\n');
		
		for(int i : apart) {
			if(i==0) continue;
			sb.append(i).append('\n');
		}
		
		System.out.println(sb);
	}
	private static void bfs(int x, int y) {
		// TODO Auto-generated method stub
		//���⼭ ���� ���� �̾ Ǯ���!
		Queue<pos> q = new LinkedList<pos>();
		
		
		visit[x][y] = true;
		q.add(new pos(x, y));
		apart[danjiNum]++;//������ȣ�� ���� ����Ʈ�� ���� �����ش�. 
		
		while(!q.isEmpty()) {
			pos cur = q.poll();
			int curX = cur.x;
			int curY = cur.y;
			
			for(int i=0; i<4; i++) {//���� ��ġ���� �����¿�� ����������.
				int nextX = curX + moveX[i];
				int nextY = curY + moveY[i];
				
				//���� �湮���� �ʾҰ�, �ε����� ����� �ʴ� ���
				if( nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visit[nextX][nextY]) {
					visit[nextX][nextY] = true;
					q.add(new pos(nextX, nextY));
					apart[danjiNum]++;
				}
			}
			
		}
	}

}
class pos{
	int x;
	int y;
	
	
	public pos() {
		super();
	}


	public pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
}

/*
	map -> Ž�� ����� �����ϴ� ��ü �� 
	visit -> �ߺ� �湮 ������ �湮�迭(boolean) 
	
	BFS(R){ -> R�� ��� ��� Ȥ�� ��� ����
	
		Queue -> �湮�� ��带 ������ ť�� ����. Enqueue�ϴ� ������ ���� �湮�� �ƴ϶�, �湮 �ؾ��� ����� ����Ʈ�� FIFO������ �����ϴ� ���̴�.
		visit[R] = true -> ���� ��忡 ���� �湮 ó���� ���ش�. �⺻������ �湮 ó���� ���� �ϰ� ť�� enqueue�Ѵ�. 
		Queue.add(R)    => ť�� ���� ��带 ��ť �Ѵ�. 
		
		
		while(!Queue.isEmpty()){ ť�� �� �̻� �湮�ؾ��� ��尡 ���� ������ �Ʒ��� ������ �ݺ��Ѵ�.
			int a = q.poll()    -> ť���� ���� �տ� �ִ� ��带 ������. �� ������ ������ ��带 �湮�ϴ� �����̶�� ����.
			
			����  -> ������ ���� �������� �� �� ���͸��� ���ش�. 
			
			if(!visit[a]){ 
				//���� �湮���� �ʾҴٸ� �湮 ó���� ���ְ� ��ť���ִ� ������ �ݺ��Ѵ�. 
				visit[a] = true;
				Queue.add(a);
			}
		}
	}
	
	
*/
