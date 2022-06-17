package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1753_�ִܰ�� {
	static int V;
	static int K;
	static int E;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<Edge> list[];
	static PriorityQueue<Edge> q = new PriorityQueue<>();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		//Vertex. ���� =����� ����
		V = Integer.parseInt(st.nextToken());
		
		//Edge�� ����
		E = Integer.parseInt(st.nextToken());
		
		//��߳��
		K = Integer.parseInt(br.readLine());
		
		//0������ ������ �򰥸��� �ʰ� ����� ��ȣ�� ������ 1�������� ����� �Ŵϱ� ũ�� +1�ϱ�
		//�ִܰŸ� �迭
		distance = new int[V+1];
		
		//�湮 üũ �迭
		visited = new boolean[V+1];
		
		//��������Ʈ�� ũ�� ����(1���� �迭�� ����)
		list = new ArrayList[V+1];
		
		//���� ����Ʈ �����ϱ� 
		for(int i=0; i<V+1; i++) {
			list[i] = new ArrayList<Edge>();
		}
		
		//�ִܰŸ� �迭 �ʱ�ȭ�ϱ� (�ʱ⿡�� ���Ѵ��� ���� �ش�.)
		for(int i=0; i<V+1;i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		//��������Ʈ�� ����ġ �� �ʱ�ȭ�ϱ� 
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());//���۳��
			int v = Integer.parseInt(st.nextToken());//�������
			int w = Integer.parseInt(st.nextToken());//�� ��带 �����ϴ� ������ ����ġ
			list[u].add(new Edge(v, w));
		}
		
		//���۳�带 K�� �����ϱ�
		q.add(new Edge(K, 0));
		distance[K] = 0;
		
		//ť�� �������� �ݺ��� �����ϸ鼭 �ִܰŸ� �迭�� �ϼ��Ѵ�. 
		//���ͽ�Ʈ�� �˰��� ����
		while(!q.isEmpty()) {
			Edge current = q.poll();
			//���� ����ȣ�� ����
			int current_v = current.vertex;
			
			//�̹� �湮�ߴٸ�, �Ʒ��� ����� �������� �ʰ� �ǳʶٱ�
			if(visited[current_v]) continue;
			
			//false��� �湮 ǥ�ø� ���ش�.
			visited[current_v] = true;
			
			//���� ����� ��������Ʈ�� Ž���Ѵ�. ��, ���� ���� ����� ����� ������ Ž���ϸ鼭 �ִܰŸ� �迭�� �����Ѵ�. 
			for(int i=0; i<list[current_v].size(); i++) {
				Edge tmp = list[current_v].get(i);//���� ��� ��ȣ�� ����� ����� ��ȣ�� ���� ������ �����´�. 
				int next  = tmp.vertex; //������ ��ȣ
				int value = tmp.value;  //�� ��ȣ�� ����� ������ ����ġ
				
				//�ִܰŸ��� ������Ʈ�ϱ�
				if(distance[next] > distance[current_v] + value) {
					distance[next] = value + distance[current_v];
					//�ʺ�켱 Ž������ó�� ���������� ������ ��带 ��� Ž��
					q.add(new Edge(next, distance[next]));
				}
			}//end-for
		}//end-while
		
		//�ִܰŸ� �迭 ����ϱ� 
		for(int i=1; i<V+1;i++) {
			//�湮�� ���� �ִܰŸ� �迭 ���
			if(visited[i]) {
				System.out.println(distance[i]);
			} else {//5������ �湮�� �� �ִ� ����� ���� ����.
				System.out.println("INF");
			}
		}
		
	}

}

//�̸� ���ؼ� �켱���� ť�� ���� ������ �����Ѵ�.
class Edge implements Comparable<Edge>{
	
	int vertex, value;
	Edge(int vertex, int value){
		this.vertex = vertex;
		this.value  = value;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		
		return this.value - o.value;
	}
	
}
