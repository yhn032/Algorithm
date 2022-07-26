package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2589_보물섬2 {
	
	static boolean map[][];
	static boolean visit[][];
	static int injac[];
	static int w, h;
	static int dx[] = {-1, 1,  0, 0};
	static int dy[] = { 0, 0, -1, 1};
	static int copy[][];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		//가로(h), 세로(w)
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map   = new boolean[w][h];
		
		int count = 0;
		for(int i=0; i<w; i++) {
			String str = br.readLine();
			for(int j=0; j<h; j++) {
				char c = str.charAt(j);
				if(c == 'L') {//육지인 경우만 true처리 나머지 바다는 false;
					map[i][j] = true;
					count++;
				}
			}
		}
		List<Integer> list = new ArrayList<Integer>(count);
		
		//모든 육지를 시작점으로 해서 bfs탐색
		//탐색의 결과는 가장 먼 지점까지의 최단 시간을 반환한다.
		//반환값을 리스트에 저장
		for(int i=0; i<w; i++){
			for(int j=0; j<h; j++) {
				if(map[i][j])
					list.add(bfs(i,j));
			}
		}
		
		//오름차순으로 정렬
		Collections.sort(list);
		
		//가장 큰 값을 출력
		System.out.println(list.get(count-1));
		
		
		
		/*
		 * System.out.println(min); for(int a[] : injac) { for(int aa : a) {
		 * System.out.print(aa + ""); } System.out.println(); }
		 */
		
	}

	private static int bfs(int x, int y) {
		// TODO Auto-generated method stub
		copy = new int[w][h];
		Queue<pos> q = new LinkedList<>();
		visit = new boolean[w][h];
		visit[x][y] = true;
		q.add(new pos(x, y));
		
		int finishX=0;
		int finishY=0;
		
		while(!q.isEmpty()) {
			pos now = q.poll();
			
			for(int i=0; i<4; i++) {
				int xx = now.x + dx[i];
				int yy = now.y + dy[i];
				
				if(xx < 0 || yy < 0 || xx >= w || yy >= h) continue;	//배열의 범위를 벗어나거나
				if(!map[xx][yy]) continue;								//바다이거나
				if(visit[xx][yy]) continue;								//방문했으면 스킵
				
				copy[xx][yy] = copy[now.x][now.y]+1;
				visit[xx][yy] = true;
				q.add(new pos(xx, yy));
			}
			finishX = now.x;
			finishY = now.y;
			
		}
		
		return copy[finishX][finishY];
	}
	
	static class pos{
		int x, y; 
		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}

