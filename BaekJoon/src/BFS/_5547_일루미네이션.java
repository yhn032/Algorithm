package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5547_일루미네이션 {
								//좌       좌상       우      우하    좌하    우상
	static int moveOdd[][]  = { {0, -1}, { -1,  0}, {0, 1}, {1, 1}, {1,  0}, {-1, 1}};//홀수 행
	static int moveEven[][] = { {0, -1}, { -1, -1}, {0, 1}, {1, 0}, {1, -1}, {-1, 0}};//짝수 행
	static int map[][];
	static int isInjac[][];
	static boolean visit[][];
	static int w, h;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//열(w), 행(h)
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
		
		//건물과 인접한 외벽에 표시하기
		//1. 건물의 위치를 기준으로 연결된 건물을 탐색하면서 인접한 건물중 1이 아닌 0인 건물을 체크하면 건물 외부를 체크할 수 있지만
		//건물 내부까지 포함된다는 결점이 존재한다. 이 문제의 핵심은 건물의 내벽이 아닌 외벽만을 체크해야 한다는 점이다.
		//2. 따라서 모든 맵을 탐색하면서 현재 위치에서 육방향으로 이동할 수 있는 경우를 탐색하면서 1인 경우에만 현재 위치에 마킹을 한다. 
		//3. 현재 위치가 1이라면 내벽이 마킹될 수 있으므로 건너뛴다. 현재위치는 반드시 0일때만 가능하다.
		
		//탐색을 위해서 0, h+2, w+2라는 가벽을 세워뒀지만, 이곳에는 건물이 없기 때문에 탐색의 범위로만 둘 뿐 bfs탐색의 대상에서 제외한다.
		//외벽을 설치한 건물은 탐색 출발지점에서 제외한다.
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
				if(now.x % 2 == 0) {//현재위치의 y가 짝수라면
					nextX = now.x + moveEven[i][0];
					nextY = now.y + moveEven[i][1];
				}else {//현재 위치의 y가 홀수라면
					nextX = now.x + moveOdd[i][0];
					nextY = now.y + moveOdd[i][1];
				}
				
				//조건 설정하기
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
	현재위치(x, y)
	오른쪽 -> (x+1, y)
	왼  쪽 -> (x-1, y)
	y가 홀수일 때, 
	아래쪽 -> (x, y+1)
	위  쪽 -> (x, y-1)
	y가 짝수일 때, 
	아래쪽 -> (x, y+1)
	위  쪽 -> (x, y-1)
*/
