package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node1 implements Comparable<Node1>{
	int end;
	int weight;
	
	public Node1(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node1 o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}
	
}

public class _1504_Ư�����ִܰ�� {
	//������ �׷��� ��, ������ ����ġ�� ����
	//������ �ִ� 1�� -> �ϳ��� ����ġ�� �����϶�
	//������ �� ������ ���ļ� ���� ���� ���ٸ� -1�� ����϶� 
	//����� ���� �Ǵ� ������ �ٽ� ���� ���� �ֱ� ������ �湮�迭�� ������ �ʴ´�.
	static int N, E;
	static ArrayList<ArrayList<Node1>> list;
	static int dist[];
	static boolean check[];
	static int INF = 200000000;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		dist = new int[N+1];
		check = new boolean[N+1];
		
		//�ִܰŸ� �迭 �ʱ�ȭ 
		Arrays.fill(dist, INF);
		
		//��������Ʈ ����
		for(int i=0; i<=N;i++) {
			list.add(new ArrayList<>());
		}
		
		
		//��������Ʈ�� ����ġ �� �ʱ�ȭ
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			//��������� �̵� �����ϱ� ������ ���� �� �����ϱ�
			list.get(start).add(new Node1(end, weight));
			list.get(end).add(new Node1(start, weight));
		}
		
		//�ݵ�� ���ľ� �ϴ� ������ �Է¹޴´�. 
		st = new StringTokenizer(br.readLine());
		
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int res1 = 0;
		res1 += dijkstra(1, v1);
		res1 += dijkstra(v1, v2);
		res1 += dijkstra(v2, N);
		
		int res2 = 0;
		res2 += dijkstra(1, v2);
		res2 += dijkstra(v2, v1);
		res2 += dijkstra(v1, N);
		
		
		int min = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);
		
		System.out.println(min);
		/*
		 * if(res1 >= INF && res2 >= INF) { System.out.println(-1); } else { int min =
		 * res1 > res2 ? res2 : res1;
		 * 
		 * System.out.println(min);
		 * 
		 * }
		 */
		//�� 3���� ���ͽ�Ʈ�� �˰��� ����
		//������ ���� ������ �����ϴ� ��� �����÷ο츦 �����ϱ� ���ؼ� �ڷ����� long���� �Ѵ�. 
		//���� ���� ����� integer.max_value���� ũ�ų� ���ٸ� �ּҰ��� maxvalue��� ���̹Ƿ� ��θ� ã�� ���ߴٴ� ���̴�. -> INF = -1
		//1 -> v1 -> v2 -> N
		//1 -> v2 -> v1 -> N
		//1�� ��忡�� ����մϴ�.
		br.close();
		
	}
	private static int dijkstra(int start, int end) {
		// TODO Auto-generated method stub
		//�� ���긶�� ���� �湮 �迭�� �ִܰŸ� �迭�� �����ϹǷ� �ʱ�ȭ ���Ѿ� �մϴ�.
		Arrays.fill(dist, INF);
		Arrays.fill(check, false);
		
		PriorityQueue<Node1> pq = new PriorityQueue<Node1>();
		boolean []check = new boolean[N+1];
		pq.offer(new Node1(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node1 curNode = pq.poll();
			//���� ����� ��ȣ
			int cur = curNode.end;
			
			if(!check[cur]) {
				check[cur] = true;
				
				for(Node1 node : list.get(cur)) {
					
					if(!check[node.end] && dist[node.end] > dist[cur] + node.weight) {
						dist[node.end] = dist[cur] + node.weight;
						pq.add(new Node1(node.end, dist[node.end]));
					}
				}
			}
					
		}
		
		return dist[end];
	}

}



