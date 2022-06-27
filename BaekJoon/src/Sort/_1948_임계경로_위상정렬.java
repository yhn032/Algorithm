package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1948_�Ӱ���_�������� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//������ ��(���)n, ������ ��(����)m
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		//��������Ʈ ���� �� �ʱ�ȭ
		List<ArrayList<node>> list 		  = new ArrayList<ArrayList<node>>();
		List<ArrayList<node>> list_reverse = new ArrayList<ArrayList<node>>();
		
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<node>());
			list_reverse.add(new ArrayList<node>());
		}
		
		//�������� �迭 ���� �� �ʱ�ȭ 
		int []inDegree = new int[n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			//��߳�� a, ������� b, ����ġ e
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.get(a).add(new node(b, e));
			list_reverse.get(b).add(new node(a, e));
			inDegree[b]++;
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end   = Integer.parseInt(st.nextToken());
		
		//���� ���� �����ϱ� 
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);//�Ϲ����� �������İ��� �ٸ��� �������� ���ϰ� �����ؾ� �Ѵ�. 
		
		//������������ ����� ���������� ������ ������ ��ĥ �� �ִ� ��� ��� �߿���(�̵��ð��� ���� �� ����� �ð��� ����) -> ���� �������� �����ϴ� ����� ����?
		int []ans = new int[n+1];
		while(!q.isEmpty()) {
			int now = q.poll();
			for(node next : list.get(now)) {
				inDegree[next.nextNode]--;
				
				//							������ġ������ �ð�		����ð� + �� ��带 �̵��ϴµ� �ɸ��� �ð� �� �ִ��� �����Ѵ�.
				ans[next.nextNode] = Math.max(ans[next.nextNode], ans[now] + next.val);
				
				if(inDegree[next.nextNode]==0) {
					q.add(next.nextNode);
				}
			}
		}
		
		//���� ���������� ����� ���� �����ɸ��� ����� ans[end]�� ����Ǿ���. 
		
		//���� �Ӱ���(1�е� �����ʾƾ� �ϴ� ���η� �̵��ϴ� ����� ��)�� ������
		//1�е� �����ʾƾ� �ϴ� ���ο� ����� ��常�� ������� �ĺ��̴�. �ߺ��湮�� �����ؾ� �Ѵ�. 
		//���� ������ ���̵� Ȱ��. ���� ���ø� ��������� �Ͽ� �Ųٷ� ���������� �����Ѵ�.
		int ansCnt=0;
		boolean visit[] = new boolean[n+1];
		
		q = new LinkedList<Integer>();
		q.add(end);
		visit[end] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(node next : list_reverse.get(now)) {
				//���������� Ž���� �ϸ鼭 ���� �Ÿ��� ���� �ð��� ans�迭�� �������ѿԴ�.
				//������ ���������� Ž���ϰ� �ֱ� ������, ans[����]���� ans[�������] + ������ ������ ���ٸ� ���� ����� ��尡 �Ӱ��ο� ���ԵǴ� �Ÿ���� ���̴�. 
				if(ans[now] == ans[next.nextNode] + next.val) {
					ansCnt++;
					
					
					//�ߺ� ���� �湮 ó��
					if(!visit[next.nextNode]) {
						visit[next.nextNode] = true;
						q.add(next.nextNode);//���� ��η� ����
					}
				}
			}
		}
		
		
		System.out.println(ans[end]);
		System.out.println(ansCnt);
	}

}
class node{
	int nextNode, val;

	public node(int nextNode, int val) {
		super();
		this.nextNode = nextNode;
		this.val = val;
	}
}