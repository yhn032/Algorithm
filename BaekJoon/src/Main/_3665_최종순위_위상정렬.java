package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _3665_��������_�������� {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//������ ��
		int t = Integer.parseInt(br.readLine());
		
		
		for(int k=0; k<t; k++) {
			
			//���� ��
			int n = Integer.parseInt(br.readLine());
			
			//1. ��������Ʈ ����
			List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			for(int i=0 ; i<=n; i++) {
				list.add(new ArrayList<Integer>());
			}
			
			//2. �������� �迭 & ��������Ʈ �ʱ�ȭ
			int []inDegree = new int[n+1];
			int []ans	   = new int[n+1];
			
			//�۳� ������ ����Ѵ�. 
			int lastYear[] = new int[n+1];
			st = new StringTokenizer(br.readLine());
			//idx	0	1	2	3	4	5
			//�� 	0	5	4	3	2	1 
			for(int i=1; i<=n; i++) {
				lastYear[i] = Integer.parseInt(st.nextToken());
			}
			
			
			for(int i=1; i< n; i++) {//n-1�� �ݺ�
				int big = lastYear[i];
				for(int j=i+1; j<=n; j++) {
					list.get(big).add(lastYear[j]);
					inDegree[lastYear[j]]++;
				}
				
			}
			
			//����� ������ ���� ��θ� ���������� �������ֱ� 
			int change = Integer.parseInt(br.readLine());
			for(int i=0; i<change; i++) {
				st = new StringTokenizer(br.readLine());
				int one = Integer.parseInt(st.nextToken());
				int two = Integer.parseInt(st.nextToken());
				
				if(list.get(one).contains(two)) {
					list.get(one).remove((Integer)two);
					list.get(two).add(one);
					inDegree[one]++;
					inDegree[two]--;
					
				}else {
					//ĳ�������� ������ �ڵ� �ڽ��� ���� �ʰ�, �ε����� �����ؼ� �����ع�����. 
					list.get(two).remove((Integer)one);
					inDegree[one]--;
					//������ ���� �߰� 
					list.get(one).add(two);
					inDegree[two]++;
				}
				
			}
			
			Queue<Integer> q = new LinkedList<Integer>();
			
			int cnt = 0;
			for(int i=1; i<=n; i++) {
				if(inDegree[i] == 0) {
					cnt++;
					q.add(i);
				}
			}
			
			if(cnt > 1) {
				//�� ���� �̻��� ���Ұ� ť�� ���ٸ�, ��Ȯ�� ������ �ű� �� ���ٴ� ������ ?������Ѵ�.
				sb.append("?").append('\n');
				continue;
			}
			
			//����Ŭ�� ���� ���� �ľ��ϱ� 
			//ť�� ���� ������ ���� ��尡 ���ٴ� ���̰�, ��� ����� ���������� 0�̶�� �� ��, ����Ŭ�� �ִ°��̴�. 
			int result = 0;
			boolean isCycle = false;
			for(int i=1; i<=n; i++) {
				if(q.isEmpty()) {
					sb.append("IMPOSSIBLE").append('\n');
					isCycle = true;
					break;
				}
				
				int a = q.poll();
				result++;
				sb.append(a).append(' ');
				
				for(int to : list.get(a)) {//a���� ������ �޴� ��� ��� �������� -1
					inDegree[to]--;
					if(inDegree[to] == 0) q.add(to);
				}
			}
			sb.append('\n');
		
		}//end-for-k
		System.out.println(sb.toString());
				
	}
}
