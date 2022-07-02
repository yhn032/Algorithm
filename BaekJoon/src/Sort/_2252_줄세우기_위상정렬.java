package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2252_�ټ����_�������� {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//1. ��������Ʈ ���� �� �ʱ�ȭ
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		//2. ���� ���� �迭 ���� �� �ʱ�ȭ 
		int inDegree[] = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list.get(A).add(B);
			inDegree[B]++; //A->B�̹Ƿ� B�� ���������� 1 ������Ų��. 
		}
		
		//3. ���� ���� ť�� ���� ���������� ���� �����ϱ� 
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			if(inDegree[i] == 0) {
				q.add(i);
			}
		}
		
		//���� ����ť�� ���� ���� ������ �ݺ��Ѵ�. 
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append(' ');
			for(int node : list.get(now)) {//4. ��� now�� ����Ű�� ������ ���������� 1�� ���ҽ�Ų��.
				inDegree[node]--;
				
				if(inDegree[node] == 0) {//5. ������ ����� 0�̶�� ���� ť�� �߰��Ѵ�. 
					q.add(node);
					
				}
			}
		}
		
		System.out.println(sb);
		
	}
}
