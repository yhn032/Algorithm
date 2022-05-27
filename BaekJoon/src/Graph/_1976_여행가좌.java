package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1976_���డ�� {
	static int[] travel;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		//���ù�ȣ 1 ~ n
		travel = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			travel[i] = i;
		}
		
		//�־��� ���� ������ �����ϱ� 
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n ; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp==1) {
					union(i,j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		//������ �����
		int start = find(Integer.parseInt(st.nextToken()));
		for(int i=1; i<m; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			//��ߵ��ÿ������� ����Ǿ� ���� ������,,, -> ���� ����� �θ������ �ڽ� ��尡 �ƴ϶�� ���� ��ΰ� �ƴϴ� .
			if(start != find(now)) {
				sb.append("NO").append('\n');
				System.out.println(sb);
				return;
			}
		}
		
		sb.append("YES").append('\n');
		
		System.out.println(sb);
	}

	private static void union(int x, int y) {
		// TODO Auto-generated method stub
		x = find(x);
		y = find(y);
		if(x!=y) {
			if(x<y) {
				travel[y]=x;
			}else {
				travel[x]=y;
			}
		}
	}

	private static int find(int x) {
		// TODO Auto-generated method stub
		if(x == travel[x]) {
			return x;
		}
		
		return travel[x] = find(travel[x]);
	}

}
