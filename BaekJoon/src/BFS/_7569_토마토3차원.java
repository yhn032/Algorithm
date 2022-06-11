package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7569_�丶��3���� {
	//				    �� ��  �� ��  �� ��
	static int dx[] = {-1, 1,  0, 0, 0,  0};
	static int dy[] = { 0, 0, -1, 1, 0,  0};
	static int dz[] = { 0, 0,  0, 0, 1, -1};
	
	//					  ���࿭
	static int        map[][][];
	static boolean visit[][][];
	static int x, y, z;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		//����(��)
		y = Integer.parseInt(st.nextToken());
		//����(��)
		x = Integer.parseInt(st.nextToken());
		//����(z��)
		z = Integer.parseInt(st.nextToken());
		
		map   = new     int[z][x][y];
		visit = new boolean[z][x][y];
		Queue<Node> q = new LinkedList<Node>();
		int day = 0;
		
		for(int i=0; i<z; i++) {
			for(int j=0; j<x; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<y; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					
					if(map[i][j][k] == 1) {
						visit[i][j][k] = true;
						q.add(new Node(j, k, i, 0));
					}
				}
			}
		}
		if(q.size() == z*x*y) {
			System.out.println(0);
			return;
		}
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			for(int i=0; i<6; i++) {
				int xx = now.x + dx[i];
				int yy = now.y + dy[i];
				int zz = now.z + dz[i];
				
				//�迭�� ���� ���̰ų� �湮�߰ų� �̹� �;��ų� ����ִ� ĭ�̶�� skip
				if(xx < 0 || xx >= x || yy < 0 || yy >= y || zz < 0 || zz >= z) continue;
				if(visit[zz][xx][yy] || map[zz][xx][yy] == 1 || map[zz][xx][yy] == -1) continue;
					
				visit[zz][xx][yy] = true;
				map[zz][xx][yy] = 1; //�丶�� ���� ó�� 
				q.add(new Node(xx, yy, zz, now.dist+1));
				
			}
			
			day = now.dist;//���� ����
		}
		
		//��� ���. �ʱ⿡ ���� ��尡 �ϳ��� ���ٸ� ���� �ݺ��� ��ġ�� �ʰ� �ٷ� �Ϸ� ��
		for(int i=0; i<z; i++) {
			for(int j=0; j<x; j++) {
				for(int k=0; k<y; k++) {
					if(map[i][j][k] == 0) { //������ �丶�䰡 �ϳ��� �ִٸ� ����!
						System.out.println(-1);
						return;
					}
				}
			}
		}
		
		//�丶�䰡 ��� �;��ٸ� day���
		System.out.println(day);
	}

}

class Node{
	int x;
	int y;
	int z;
	int dist;
	public Node(int x, int y, int z, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.dist = dist;
	}
	public Node() {
		super();
	}
	
	
}

