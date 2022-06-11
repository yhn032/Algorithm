package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7569_토마토3차원 {
	//				    앞 뒤  좌 우  상 하
	static int dx[] = {-1, 1,  0, 0, 0,  0};
	static int dy[] = { 0, 0, -1, 1, 0,  0};
	static int dz[] = { 0, 0,  0, 0, 1, -1};
	
	//					  면행열
	static int        map[][][];
	static boolean visit[][][];
	static int x, y, z;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		//가로(열)
		y = Integer.parseInt(st.nextToken());
		//세로(행)
		x = Integer.parseInt(st.nextToken());
		//높이(z축)
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
				
				//배열의 범위 밖이거나 방문했거나 이미 익었거나 비어있는 칸이라면 skip
				if(xx < 0 || xx >= x || yy < 0 || yy >= y || zz < 0 || zz >= z) continue;
				if(visit[zz][xx][yy] || map[zz][xx][yy] == 1 || map[zz][xx][yy] == -1) continue;
					
				visit[zz][xx][yy] = true;
				map[zz][xx][yy] = 1; //토마토 익음 처리 
				q.add(new Node(xx, yy, zz, now.dist+1));
				
			}
			
			day = now.dist;//날자 증가
		}
		
		//결과 출력. 초기에 익은 노드가 하나도 없다면 위의 반복을 거치지 않고 바로 일로 옴
		for(int i=0; i<z; i++) {
			for(int j=0; j<x; j++) {
				for(int k=0; k<y; k++) {
					if(map[i][j][k] == 0) { //안익은 토마토가 하나라도 있다면 실패!
						System.out.println(-1);
						return;
					}
				}
			}
		}
		
		//토마토가 모두 익었다면 day출력
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

