package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1916_�ּҺ�� {
	static int N, M;
	static ArrayList<Node> list[];
	static int dist[];
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		//������ ����(����=���)
		N = Integer.parseInt(br.readLine());
		//������ ����
		M = Integer.parseInt(br.readLine());
		
		//��������Ʈ
		list = new ArrayList[N+1];
		//�ִܺ��(=�ִܰŸ� �迭)
		dist = new int[N+1];
		//�湮�迭
		visited = new boolean[N+1];
		
		//��������Ʈ ����
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		//�ִ� �Ÿ� �迭 ���Ѵ� ������ �ʱ�ȭ
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		//��������Ʈ�� ������ �ֱ� 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			//��߳�� = ��� ���� ��ȣ
			int start = Integer.parseInt(st.nextToken());
			//���� ��� = ���� ���� ��ȣ
			int end = Integer.parseInt(st.nextToken());
			//����ġ(���)
			int weight = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		//���� �����
		int startIdx = Integer.parseInt(st.nextToken());
		//���� �����
		int endIdx = Integer.parseInt(st.nextToken());
		sb.append(dijkstra(startIdx, endIdx)).append('\n');
		System.out.println(sb);

	}
	private static int dijkstra(int startIdx, int endIdx) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.add(new Node(startIdx, 0));
		dist[startIdx] = 0;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			int nowNode = now.targetNode;
			
			//�湮���� �ʾҴٸ� �湮�ض�
			if(!visited[nowNode]) {
				visited[nowNode] = true;
				
				//������ ��� ��� �� ���� �湮���� ���� ��带 Ž���ϰ� �ִܰŸ��迭 ����
				for(Node n : list[nowNode]) {
					if(!visited[n.targetNode] && dist[n.targetNode] > dist[nowNode] + n.value) {
						dist[n.targetNode] = dist[nowNode] + n.value;
						q.add(new Node(n.targetNode, dist[n.targetNode]));
					}
				}
			}
		}
		
		return dist[endIdx];
	}

}

class Node implements Comparable<Node>{
	int targetNode;
	int value;
	
	public Node(int targetNode, int value) {
		this.targetNode = targetNode;
		this.value = value;
	}
	
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.value - o.value;
	}
	
}
