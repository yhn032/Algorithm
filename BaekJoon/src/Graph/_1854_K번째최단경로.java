package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1854_K��°�ִܰ�� {
	static final int INF = 200000000;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int N,M,K;
		int [][]W = new int[1001][1001];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		//����(=���)�� ����
		N = Integer.parseInt(st.nextToken());
		//������ �� 
		M = Integer.parseInt(st.nextToken());
		//K��° �ִܰ��
		K = Integer.parseInt(st.nextToken());
		
		//�ִܰŸ� �迭�� ������ �켱���� ť ���� 
		PriorityQueue<Integer>[] distq = new PriorityQueue[N+1];
		
		Comparator<Integer> cp = new Comparator<Integer>() {//���� ���� �����

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 < o2 ? 1 : -1 ;
			}
			
		};
		
		for(int i=0; i<=N; i++) {
			//���� ������ �������ָ鼭 �켱����ť ����
			distq[i] = new PriorityQueue<Integer>(K, cp);
		}
		
		//���� ��Ŀ� �׷��� ������ ���� 
		for(int i=0; i< M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			W[a][b] = c;
		}
		
		PriorityQueue<Node2> pq = new PriorityQueue<>();
		//��߳�带 ť�� �����Ѵ�. �� �κ��� ���� ���ͽ�Ʈ�� �˰���� �����ϴ�. �ִܰŸ� �迭�� �켱���� ť�� ������ �͸� �ٸ�. 
		pq.add(new Node2(1, 0));
		distq[1].add(0);
		while(!pq.isEmpty()) {
			Node2 n = pq.poll();
			//W�� �ʱ�ȭ ���� ���� ��ġ�� 0���� �ʱ�ȭ �Ǿ� �ִ�. ��, 0�� �ƴ϶�� ���� ����� ������ �����ϰ� �ִٴ� ��
			for(int node = 1; node <= N ; node++) {
				//���� ���� ����� ��� ��� �˻��ϱ� 
				if(W[n.node][node] != 0) {
					//�켱���� ť�� ������ �ִܰŸ� �迭�� ����� ��ΰ� K���� �۴ٸ� �׳� �߰��ϱ� 
					if(distq[node].size() < K) {
						distq[node].add(n.cost + W[n.node][node]);
						pq.add(new Node2(node, n.cost + W[n.node][node]));
						
					} else if(distq[node].peek() > n.cost + W[n.node][node]) {// ����� ��ΰ� K�� �̻��� ��, ���� ���� ū ������ ���� ���� �߰��ϱ� -> �켱����ť�� ����ؼ� ť�� ���� �պκ��� ���� ū ���� �����Ѵ�.(������ ���ı����� �־ �������� ������ �ߴ�.)
						distq[node].poll();//front�� �� ���� 
						distq[node].add(n.cost + W[n.node][node]); //�ű� ��η� ����
						pq.add(new Node2(node, n.cost + W[n.node][node]));
					}
				}
			}//end-for-node
		}//end-while
		
		//K��° ��θ� ����ϱ� 
		for(int i=1; i<=N; i++) {
			if(distq[i].size() == K) {
				sb.append(distq[i].peek()).append('\n');
			} else { 
				sb.append(-1).append('\n');
			}
		}
		
		System.out.println(sb);
	}

}

class Node2 implements Comparable<Node2>{
	int node;//����ȣ 
	int cost;//��带 �̵��� �� �ɸ��� �ð�
	Node2(int node, int cost){
		this.node = node;
		this.cost = cost;
	}
	@Override
	public int compareTo(Node2 o) {
		// TODO Auto-generated method stub
		return this.cost < o.cost ? -1 : 1;
	}

	
}
/*
	K��° �ִܰ�� ã�� ���� �� �׳� ������� ���� 
	�������� �������� �־�����. �׷������� ������ �ִ�. (a -> b�� �̵��ϴ� ������ ������ ����)
	�ִܰ�� �迭�� �켱���� ť�� ��������. -> �ִ� ��ο� ���Ҿ� �ִܰ�κ��� K��° �ִ� ��� ���� �켱������ ���߾� ǥ������
	K��° ��θ� ã�� ���ؼ� ���� ��带 �ߺ��ݺ��ص� �ȴٰ� �ߴ� -> �湮�� ���� �湮 �迭�� ǥ���ϰ�, ��湮���� �ʴ� ���� �����ؼ� ��������.
	
	�켱����ť�� �����ϴ� �ִܰŸ� �迭 ä��� 
	1. ���� ��忡 ����� ��ΰ� K�� �̸��� �� �ű� ��� �߰� -> K��° �ִܰ�ζ�� ���� ��� K���� �ִܰ�δ� �־�� �Ѵ�. 
	2. ��ΰ� K�� �϶�, �ʱ�ȭ �� ����� �ִ� ��ο� �ű� ��θ� ���ؼ� �ű� ��ΰ� �� """�ִܰŸ�"""�϶��� �ִܰŸ� �迭�� �����Ѵ�. 
	3. �湮�迭�� ǥ���ϰ� ��湮���� �ʴ� ��츸 �����Ѵ�. 
	
	
	
*/
