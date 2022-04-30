package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs {
	//����� �ִ밪
	static final int MAX_N = 10;
	static int N, E;
	//�����迭�� �׷��� ǥ���ϱ�
	static int[][] Graph = new int[MAX_N][MAX_N];
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//����� ����
		N = sc.nextInt();
		//������ ����
		E = sc.nextInt();
		
		//������ ������ �̵��� �� �ִ� ��� �̹Ƿ� ������ ������ŭ �ݺ��ϸ鼭 ����� ���� �о���δ�.
		for(int i=0; i<E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			//u��忡�� v���� �� �� �ִٴ� �ǹ��̹Ƿ� 1�� ��. ���⼺�� ���� �׷����̹Ƿ� v -> u�� ���� ���⵵ ���� ������ ���� 1�� �����ش���. 
			Graph[u][v] = Graph[v][u] = 1; 
		}
		//�Է����� ���۳���� ��ġ�� �����Ѵ�.
		bfs(0);
	}



	private static void bfs(int node) {
		// TODO Auto-generated method stub
		//�ʱⰪ�� false�� ����˴ϴ�. 
		boolean []visited = new boolean[MAX_N];
		
		//�ڷᱸ���� ť�� ���
		Queue<Integer> q = new LinkedList<>();
		//Ǫ���ϱ� ���� �ش� ��ġ�� �湮�ߴٴ� ǥ�ø� ���ݴϴ�. 
		//DFS�ʹ� �޸� ť�� ������ FIFO�̹Ƿ� ������ ����  ť�� ���� ��Ұ� ���� ���� ������ �˴ϴ�.[���� ���� Ž���� �մϴ�]
		//���� �湮�� �ϰ� ���� �湮 ǥ�ø� �ϴ� ���� ������ ��Ҹ� ť�� �� ���� ���̱� ������ �ǹ̰� �����ϴ�.
		//��, �湮 ǥ�ø� �ϰ�! enqueue�� ����! ť�� ���� ���� ���� ������ �湮�� �����մϴ�.
		visited[node] = true; 
		q.add(node);
		
		//ť�� �������� -> ��� ��带 Ž���� ������
		while(!q.isEmpty()) {
			//ť�� ���� ���� ���� ��Ҹ� �̾Ƽ� �湮�մϴ�. 
			int curr = q.remove();
			
			System.out.print(curr + " ");
			
			//1�� ���� ������ ��带 �湮�մϴ�.
			for(int next = 0; next<N;++next) {
				//�湮���� �ʾҰų�, ������ġ curr���� ���� ��ġnext�� �Ѿ �� �ִ� ���.(�������� ����Ǿ� �̵��� �� �ִ°�?) 
				//graph�迭�� ��带 �����ϴ� ������ ����, �� �̵������� ��θ� ������ �迭�Դϴ�. 
				//(0:����x) (1:����o)  
				if(!visited[next] && Graph[curr][next] != 0) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
	}

}
