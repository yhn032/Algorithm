package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1167 {
	static int V;
	static boolean[] visited;
	static ArrayList<edge2> []list;
	static int dist[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//����� ����
		V = Integer.parseInt(br.readLine());
		
		//�ڷᱸ�� �ʱ�ȭ(�ʱ���� : V+1)
		list = new ArrayList[V+1];
		
		//����ȣ�� 1������ �����ϹǷ� 0������ ������ �ϴ°� �� ���ϴ�
		
		for(int i=1; i<=V;i++) {
			list[i] = new ArrayList<edge2>();
		}
		
		//��������Ʈ �ʱ�ȭ 
		for(int i=0; i<V; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			while(true) {
				int node = Integer.parseInt(st.nextToken());
				if(node == -1) {
					break;
				}
				
				int edge = Integer.parseInt(st.nextToken());
				list[S].add(new edge2(node, edge));
			}
		}
		
		dist = new int[V+1];
		visited = new boolean[V+1];
		
		//������ ��忡�� ����, ���ǻ� 1�� ��忡�� ����ϰڴ�/ 
		BFS(1);
		
		int max = 1;
		for(int i=2; i<=V; i++) {//1�� ��忡������ ��������� ������ dist[1]�� 0�̴� ���� ����
			if(dist[i] > dist[max]) {
				max = i;//���� BFS�� �����, �� Ʈ���� ������ �̷�� ����ȣ�� ã�ƾ� �Ѵ�.
			}
		}
		
		Arrays.fill(dist, 0);
		Arrays.fill(visited, false);
		
		BFS(max);
		
		Arrays.sort(dist);
		System.out.println(dist[V]);
		
	}
	private static void BFS(int i) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		visited[i] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(edge2 k : list[cur]) {//���� ���� ����� ��� ��ȣ�� ����ġ(�Ÿ�)���� �о�´�.
				int node = k.node;
				int value = k.value;
				if(!visited[node]) {
					//���� �湮���� ���� ���̶�� 
					visited[node] = true;
					q.add(node);
					dist[node] = dist[cur] + value; //���� ��ġ�� �������� �Ÿ����� �߰���
				}
				
			}
		}
	}

}

class edge2 {
	int node;
	int value;
	public edge2(int node, int value) {
		this.node = node;
		this.value = value;
	}
}
/*
	Ʈ���� �����ϴ� ��� �� �� ��� ������ �Ÿ��� ���� �� ���� Ʈ���� �����̶�� �Ѵ�. 
	"������ ��忡�� ���� �� ��η� ����Ǿ� �ִ� ���� Ʈ���� ������ �ش��ϴ� �� ��� �� �ϳ��̴�."
	��> ������ ��忡�� ���. �Ÿ��迭 �����Ͽ� ���� �� �Ÿ��� �ִ� ���(Ʈ���� ���� �� �ϳ�)�� ã�� �� ��带 ���������� BFS�Ͽ� ���� �� �Ÿ��� �ִ� ���(Ʈ���� ���� �� �ϳ�)�� ã�´�.
	��> ��, �ι��� �Ÿ��迭 �ʱ�ȭ�� �ϸ鼭 Ʈ���� ������ �̷�� ��� �ΰ��� ã�Ƴ��� ���޾� �Ÿ� ��, ���� ���� ���Ѵ�.
	
*/
