package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1325_ȿ��������ŷ2 {
	static List<ArrayList<Integer>> list;
	static int ans[];
	static int n, m;
	static boolean visit[];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ans = new int[n+1];
		
		
		list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		long start = System.currentTimeMillis();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(b).add(a);
		}
		
		//��� ��带 �湮�ϴ� ���� �߿��� ���� �ƴ϶� �� ��带 �ŷ��ϴ� ����� ""����""�� ã�ƾ� �Ѵ�. 
		//�� ���� �ִ��� ����� ��带 ��ŷ�ϸ� �ִ񰪸�ŭ�� ��ǻ�͸� ��ŷ����
		//�� ��忡�� ���������, �ִ��� ����Ǽ��� ���ؾ��Ѵ�.
		//������ �ִ� �׷����̱� ������ ����Ŭ�� �̷��� �ʴ´ٸ�, Ư�� ��带 ��߳��� �������, Ž���� �ƿ� ���� �ʴ� ��찡 ������ �� �ִ�. 
		//���� ��� ��带 ��������� ��Ƽ� Ž���� �����ؾ� �Ѵ�.
		for(int i=1; i<=n;i++) {
			visit = new boolean[n+1];
			BFS(i);
		}
		
		int max = Integer.MIN_VALUE;
		
		//�ִ� ã��
		for(int i=1; i<=n;i++) {
			max = Math.max(max, ans[i]);
		}
		
		for(int i=1; i <=n ; i++) {
			if(ans[i]==max) {
				System.out.print(i + " ");
			}
		}

		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000.0);
	}
	private static void BFS(int i) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<Integer>();
		visit[i] = true;
		q.add(i);
		int count = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int a : list.get(now)) {
				if(!visit[a]) {
					count++;
					visit[a] =true;
					//���� ��� now���� a���� �̵��� �� �ִٴ� ���� 
					//now�� a�� �ŷ��Ѵٴ� ���̴�.
					q.add(a);
				}
			}
		}
		
		ans[i] = count;
	}

}

/*
	A�� B�� �ŷ��Ѵ�. -> A�� B�� �湮�Ѵ�. 
	���� ���� ��ǻ�͸� ��ŷ�ϱ� ���ؼ� ���� ���� ��忡�� �ŷڹ޴� ��带 ã�ƾ� �Ѵ�. 
	��, ���� ���� ���� ����� ��带 ã�ƾ� ��
	A�� B�� �ŷ��ϴµ�, B�� C�� �ŷ��Ѵٰ� �����غ���. C�� ��ŷ�ϸ� C�� �ŷ��ϴ� A, B ��� ��ŷ�� �� �ִ�.
*/
