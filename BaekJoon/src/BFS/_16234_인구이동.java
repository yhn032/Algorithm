package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16234_인구이동 {
	static int []dx = {-1, 1,  0, 0};
	static int []dy = { 0, 0, -1, 1};
	static List<nnode> list;
	static int map[][]; 
	static boolean visit[][];
	static int n, L, R;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		//차이의 최소(L), 최대(R)
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day = move();
		
		System.out.println(day);
	}
	private static int move() {//더 이상 인구이동이 일어나지 않을 때까지 반복한다. 
		// TODO Auto-generated method stub
		int res = 0;
		while(true) {
			boolean isMove = false;
			visit = new boolean[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visit[i][j]) {//아직 방문하지 않았다면
						int sum = bfs(i,j);//탐색을 통해서 국경선이 열린 국가는 연합으로 취급하고 원래 있던 인구수의 누적합을 구한다. 
						if(list.size() > 1) {//연합이 하나라도 존재한다면
							changeMap(sum);
							isMove = true;
						}
					}
				}
			}
			
			//인구 이동이 일어나지 않았다면,,,
			if(!isMove) return res;
			//인구 이동이 일어났다면,,,
			res++;
		}
	}
	
	private static void changeMap(int sum) {
		// TODO Auto-generated method stub
		int avg = sum / list.size(); //int형을 사용해 몫연산을 진행한다. 
		for(nnode n : list) {
			map[n.x][n.y] = avg;
		}
	}
	private static int bfs(int x, int y) {
		// TODO Auto-generated method stub
		Queue<nnode> q = new LinkedList<>();
		list = new ArrayList<nnode>();
		
		visit[x][y] = true;
		q.add(new nnode(x, y));
		list.add(new nnode(x, y));
		
		int sum = map[x][y];
		while(!q.isEmpty()) {
			nnode now = q.poll();
			for(int k=0; k<4; k++) {
				int xx = now.x + dx[k];
				int yy = now.y + dy[k];
				
				//인덱스 범위를 벗어나거나 이미 방문했다면 스킵
				if(xx < 0 || yy < 0 || xx >= n || yy >= n || visit[xx][yy]) continue;
				
				int tmp = Math.abs(map[now.x][now.y] - map[xx][yy]);
				if(tmp >= L && tmp <= R) {
					//연합한 전체 나라의 수
					visit[xx][yy] = true;
					q.add(new nnode(xx, yy));
					list.add(new nnode(xx, yy));
					sum += map[xx][yy];
					
				}
				
			}
			
		}
		return sum;
	}
}
class nnode{
	int x, y;

	public nnode(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
