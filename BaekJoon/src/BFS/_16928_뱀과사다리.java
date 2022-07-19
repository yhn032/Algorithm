package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16928_�����ٸ� {
	static int map[]   = new int[101];//1��~100�� ���; 0���� ����
	static boolean visit[] = new boolean[101];//1��~100�� ���; 0���� ����
	static int ans[]   = new int[101];//1��~100�� ���; 0���� ����
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int sadari = Integer.parseInt(st.nextToken());
		int snake  = Integer.parseInt(st.nextToken());
		
		
		for(int i=0; i<sadari + snake; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			map[start] = end;
		}
		
		bfs();
		

	}
	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<Integer>();
		ans[1]= 0;
		visit[1] = true;
		q.add(1); //������ 1�� ���
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == 100) {
				System.out.println(ans[cur]);
				return;
			}
			
			for(int i=1; i<=6; i++) {
				int next = cur + i;
				
				//if(next >100) continue;
				//if(visit[next]) continue;
				
				if(next <= 100 && !visit[next]) {
					
					visit[next] = true;
					
					if(map[next] !=0 ) {//��ٸ� �Ǵ� ���̶��
						if(!visit[map[next]]) {
							visit[map[next]] = true;
							ans[map[next]] = ans[cur]+1;
							q.add(map[next]);//�迭�� ����� ������ �̵�
							
						}
					}else {
						q.add(next);
						ans[next] = ans[cur] + 1;
					}
					
					
					
					/*
						if(map[next]!=0 && !visit[map[next]]) -> ��� ��ٸ��� �ְ�(1), �湮���� ���� ���(1)
						�� ���ǹ��� �ݷʴ� ������ ����
						1. ��� ��ٸ��� ������(1) �湮�� ���(0) 					-> ������ �湮���� �� üũ�� ���� �� +1�ϹǷ� �߸��� ��� ����
						2. ��� ��ٸ��� ������(0) �湮�� �� ���(1)				-> ������ �̵� ��ų �� ���� ������ �׳� +1
						3. ��� ��ٸ��� ������(0) �湮 �� ���(0)					-> ������ �̵� ��ų �� ���� ������ �׳� +1
						
						���� �ݷʵ��� else�� �ϳ��� ���� �ټ� ����... 
						else����  ����ؼ� ���� ������ �ݷ��� ��쿡�� count�� 1�������״µ�, �̷��� �ϸ� ���� �ٸ� �ݷʿ� ����
						����� ó���� �߱⶧���� ��Ȯ�� ���� �ȳ��� �� �ۿ� ����.
						��������� 1�� �ݷʿ� ���� ������� ���ϴ� ���ǹ��̾���. ���ǹ��� ������ �� ���� �Ĳ��ϰ� ������ ����.
						
						if(map[next]!=0) -> ��� ��ٸ��� �ִ� ��� 
						�� ���ǹ��� �ݷʴ� �ϳ����̴�. 
						1. ��� ��ٸ��� ���� ��� -> �׳� count�� ������Ų��. 
					*/
				}
			}
		}
	}

}

