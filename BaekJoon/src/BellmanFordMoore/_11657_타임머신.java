package BellmanFordMoore;

/*
	��� : Ư�� ��� ��忡�� �ٸ� ��� �������� �ִ� ��� Ž��
	Ư¡ : ������ ����ġ�� �������� ���� ���� 
		   ��ü �׷������� ���� ����ġ ���� ���� �ľ� ����
		   ������ �߽����� �����ϹǷ� ��������Ʈ�� ����
	�ð� ���⵵ : O(VE)
	
	����
	1. "��������Ʈ"�� �׷����� �����ϰ� �ִܰ�� �迭 �ʱ�ȭ 
		�ִܰŸ� �迭���� ������Ʈ Ƚ���� (��� ���� - 1)
		���� ����Ŭ�� ���ٸ�, N���� ���� �ִܰŸ��� �����ϱ� ���� ������ �� �ִ� ������ �ִ� ������ N���� ��带 1�ڷ� �� �ÿ����� �����ϴ� ���(����Ʈ��)���� N-1�̴�. 
	
	2. ��� ������ Ȯ���ϸ鼭 ���� �迭 ������Ʈ 
		������Ʈ ����. ��߳��s, ������e, ����ġw
		�� �ִ� �Ÿ� �迭�� ���� ���Ѵ��̸�, e������ �ִ� ��� > s������ �ִ� ��� + �� ������ �Ÿ�(w)�̸� ������Ʈ �Ѵ�.
		�� ���� "����Ŭ"�� ���ٸ� N-1�� ���� ���Ƚ���� �ݺ��ϸ� ��߳��� ��� ��尣�� �ִܰŸ��� �˷��ִ� ����迭 �ϼ�.
		�׷����� �ϼ��� �Ŀ� ���� ����Ŭ�� �ִ��� �ݵ�� Ȯ���� ��
		
	3. ���� ����Ŭ ���� Ȯ��
		��� ������ �� ���� �ٽ� ����� ������Ʈ �Ǵ� ��尡 �߻��Ѵٸ� -> ���������� �ݺ��Ǵ� ����Ŭ�� �ִٴ� ���̴�.
		���� ��� 2�ܰ迡�� �õ��� ����� ���ǹ��� ����� �ǰ�, �ִ� �Ÿ��� ã�� �� ���� �׷������ ���̴�.
		
		���� ����Ŭ�� �����ϸ� �� ����Ŭ�� �����ϰ� ������ ����ġ�� ��� �����ϱ� ������ �ִ� �Ÿ��� ���� �� ����. 
		Ư�� ��� ��忡���� ������ ��� �������� �ִܰŸ��� ���ϴ� ���̹Ƿ�, ��𿡼� ����ϴ����� ���� ���� ����Ŭ�� �������� �ְ� ���������� �ִ�. 
		���� �ݵ�� ���� ����Ŭ ������ Ȯ���ؾ� �Ѵ�.
		
		���� ���׿����� �ִܰŸ� �˰������� ���� ���带 ���⺸�ٴ� ���� ����Ŭ�� ������ Ȯ���ϴµ� �� ����ϰ� ���� �ȴ�.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11657_Ÿ�Ӹӽ� {
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		//������ ��n (����), �����뼱�� �� m(����)
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		//������ ������ ������ �迭(��������Ʈ), �ִܰŸ��� ������ �迭
		edge []edges = new edge[m+1];
		long []dist  = new long[n+1];
		
		//�ִܰŸ��迭 ���Ѵ밪���� �ʱ�ȭ 
		Arrays.fill(dist, INF);
		
		//��������Ʈ �ʱ�ȭ
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end   = Integer.parseInt(st.nextToken());
			int val   = Integer.parseInt(st.nextToken());
			edges[i] = new edge(start, end, val);
		}
		
		//����-���� ���� -> Ư�� ��忡�� ����ؼ� ��� ��忡 ���� �ִܰŸ� ���ϱ� 
		
		dist[1] = 0;//���۳���� �ִܰŸ��� 0
		for(int i=1; i<n; i++) {//�ݺ�Ƚ���� n-1�̶�� �ߴ�. 
			for(int k=0; k<m; k++) {
				edge e = edges[k];//�ִܰŸ� �迭�� ä���� ���̴�.   
				
				if(dist[e.start] != INF && dist[e.end] > dist[e.start] + e.val) {
					dist[e.end] = dist[e.start] + e.val;
				}
			}
		}
		
		boolean isCycle = false;
		
		//���� ����Ŭ ���� Ȯ���ϱ� -> �ϼ��� ���� �迭�� �������� ��� ������ ���� �ٽ� Ž���ؼ� ������ �̷������ ��������Ŭ�� �����ϴ� ����
		for(int i=0; i<m; i++) {
			edge e = edges[i];
			
			if(dist[e.start] != INF && dist[e.end] > dist[e.start] + e.val) {
				isCycle = true;
			}
		}
		
		if(!isCycle) {//���� ����Ŭ�� ���ٸ�,,,
			for(int i=2; i<=n; i++) {//1����忡�� ��������Ƿ� 2�������� ���
				//1->2, 1->3, 1->4�� ����Ǽ��� ���غ��� ���̴�. 
				if(dist[i] == INF) {
					sb.append(-1).append('\n');
				}else {
					sb.append(dist[i]).append('\n');
				}
				
				
			}
			
		}else {//���� ����Ŭ�� �����Ѵٸ�,,, 
			sb.append(-1).append('\n');
			
		}
		
		System.out.println(sb);
	}

}

class edge{
	int start, end, val;

	public edge(int start, int end, int val) {
		super();
		this.start = start;
		this.end = end;
		this.val = val;
	}
}

