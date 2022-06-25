package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _18352_Ư���Ÿ��ǵ���ã�� {
	static List<ArrayList<Integer>> list;
	static int []minDist;//�� ��忡 ���� �ִܰŸ��� ������ �迭
	static List<Integer> ans;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		//������ ���� = ������ ����
		int n = Integer.parseInt(st.nextToken());
		//������ ���� = ������ ���� 
		int m = Integer.parseInt(st.nextToken());
		//��߳�忡�� ������ �� �ִ� �ִ� �Ÿ�
		int k = Integer.parseInt(st.nextToken());
		//��߳�� ��ȣ
		int x = Integer.parseInt(st.nextToken());
		
		
		list = new ArrayList<ArrayList<Integer>>();
		minDist = new int[n+1];
		Arrays.fill(minDist, -1);
		
		//��������Ʈ
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		//���� ���� �ʱ�ȭ
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			//�ܹ���, ����ġ�� 1.
			list.get(u).add(v);
		}
		
		BFS(x);
		
		ans = new ArrayList<Integer>();
		//�ִܰŸ��� k�� ������ȣ�� �߰��ϱ�
		for(int i=0; i<=n; i++) {
			if(minDist[i] == k) {
				ans.add(i);
			}
		}
		
		
		if(ans.isEmpty()) {
			sb.append(-1);
		}else {
			//����
			Collections.sort(ans);
			for(int temp : ans) {
				sb.append(temp).append('\n');
			}
		}
		
		System.out.println(sb);
		
	}

	private static void BFS(int x) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<Integer>();
		minDist[x]++;
		q.add(x);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i : list.get(now)) {//���� ��带 Ž���Ѵ�.
				if(minDist[i]==-1) {//�ִܰŸ��� �ʱ�ȭ �Ǿ� ���� �ʴٸ� -> ���� �湮���� ���� ����
					minDist[i] = minDist[now] + 1;//�Ÿ� �����̴� ������ Ž���� ����� �ִܰŸ����� +1�� ���ش�. 
					q.add(i);
				}
			}
				
		}
	}

}

