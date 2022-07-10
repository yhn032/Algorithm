package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16234_�α��̵� {
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
		//������ �ּ�(L), �ִ�(R)
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
	private static int move() {//�� �̻� �α��̵��� �Ͼ�� ���� ������ �ݺ��Ѵ�. 
		// TODO Auto-generated method stub
		int res = 0;
		while(true) {
			boolean isMove = false;
			visit = new boolean[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visit[i][j]) {//���� �湮���� �ʾҴٸ�
						int sum = bfs(i,j);//Ž���� ���ؼ� ���漱�� ���� ������ �������� ����ϰ� ���� �ִ� �α����� �������� ���Ѵ�. 
						if(list.size() > 1) {//������ �ϳ��� �����Ѵٸ�
							changeMap(sum);
							isMove = true;
						}
					}
				}
			}
			
			//�α� �̵��� �Ͼ�� �ʾҴٸ�,,,
			if(!isMove) return res;
			//�α� �̵��� �Ͼ�ٸ�,,,
			res++;
		}
	}
	
	private static void changeMap(int sum) {
		// TODO Auto-generated method stub
		int avg = sum / list.size(); //int���� ����� �򿬻��� �����Ѵ�. 
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
				
				//�ε��� ������ ����ų� �̹� �湮�ߴٸ� ��ŵ
				if(xx < 0 || yy < 0 || xx >= n || yy >= n || visit[xx][yy]) continue;
				
				int tmp = Math.abs(map[now.x][now.y] - map[xx][yy]);
				if(tmp >= L && tmp <= R) {
					//������ ��ü ������ ��
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
