package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _9370_��Ȯ�ε�����_100 {
	static int min_dist[];
	static int n,m,t, T;
	static List<List<Node9370>> list;
	static boolean visit[];
	static final int INF = 100000000;
	static class Node9370 implements Comparable<Node9370>{
		int node, weight;

		public Node9370(int node, int weight) {
			super();
			this.node = node;
			this.weight = weight;
		}
		//�켱 ����ť�� ���� ����(�켱���� ����) ����. -> �������� ���� ���� �� ����(�ִܰŸ�) -> �ּ� �� 
		@Override
		public int compareTo(Node9370 o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//�׽�Ʈ���̽� ��
		T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			//�������� ���� = ���� ����
			n = Integer.parseInt(st.nextToken());
			//������ ����   = ���� ����
			m = Integer.parseInt(st.nextToken());
			//������ �ĺ��� ����
			t = Integer.parseInt(st.nextToken());
			
			//�ִܰŸ� �迭
			min_dist = new int[n+1];
			//�ִ� �Ÿ� �迭 �ʱ�ȭ (���Ŀ� ���۳��� 0���� �ʱ�ȭ)
			Arrays.fill(min_dist, INF);
			
			//���� ����Ʈ ����
			list = new ArrayList<>(n+1);
			//���� ����Ʈ �ʱ�ȭ
			for(int i=0; i<=n; i++) {
				list.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			//����������� ��� ���
			int s = Integer.parseInt(st.nextToken());
			//������ ����� Ȯ���� �������� �� ����
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			//��������Ʈ�� ���� ���� �ʱ�ȭ 
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				//�� ���� a, b������ ����ġ
				int d = Integer.parseInt(st.nextToken());
				
				if((a==g && b ==h) || (a==h && b == g)) {//�ݵ�� ������ ������ Ȧ����
					list.get(a).add(new Node9370(b, d*2-1));
					list.get(b).add(new Node9370(a, d*2-1));
				}else {
					list.get(a).add(new Node9370(b, d*2));
					list.get(b).add(new Node9370(a, d*2));
				}
			}
			
			//�ĺ� ����
			List<Integer> target = new ArrayList<Integer>();
			for(int k=0; k<t; k++) {
				target.add(Integer.parseInt(br.readLine()));
			}
			
			dijkstra(s);
			
			Collections.sort(target);
			
			for(int num : target) {
				if(min_dist[num] % 2 == 1) {
					sb.append(num).append(' ');
				}
			}
			sb.append('\n');
			
		}//end-while-t
		
		System.out.println(sb);
		
	}
	private static void dijkstra(int start) {
		// TODO Auto-generated method stub
		//�湮 �迭
		visit = new boolean[n+1];
		//���ͽ�Ʈ�� �˰��� ����
		PriorityQueue<Node9370> pq = new PriorityQueue<Node9370>();
		//���۳��� �Ÿ����� �ʱ�ȭ(���۳���� �ִܰŸ��迭�� 0)
		min_dist[start] = 0;
		pq.add(new Node9370(start, 0));
		
		while(!pq.isEmpty()) {
			Node9370 currentNode = pq.poll();
			
			if(visit[currentNode.node]) continue;
			//�湮 ó��
			visit[currentNode.node] = true;
			
			//���� ��忡�� ���� ��带 Ž��
			for(Node9370 node : list.get(currentNode.node)) {
				
				//�ִܰŸ� �迭 ������Ʈ �ϱ� 
				if(!visit[node.node] && min_dist[node.node] > min_dist[currentNode.node] + node.weight) {
					min_dist[node.node] = min_dist[currentNode.node] + node.weight;
					pq.add(new Node9370(node.node, min_dist[node.node]));
				}
			}
		}
	}
}