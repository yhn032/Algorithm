package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1717_���Ͽ�����Ʈ {
	static int arr[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//0~n
		arr = new int[n+1];
		
		for(int i=0; i<=n; i++) {
			arr[i] = i; 
		}
		
		for(int i=0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			
			int ques = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(ques==0) {//union����
				union(a,b);
			}else {
				if(find(a) == find(b)) {
					sb.append("YES").append('\n');
				}else {
					sb.append("NO").append('\n');
				}
			}
		}
		
		System.out.println(sb);
	}

	private static void union(int a, int b) { //��ǥ ��� ���� �����ϱ� -> ��ǥ���� find�� ã�´�. 
		// TODO Auto-generated method stub
		a = find(a);
		b = find(b);
		if(a != b) {//���� �ʴٸ�,,, �̹� ���� ������ �ƴ϶��,,, ���Ķ� ���� ��ġ������ �������
			arr[b] = a;
		}
		
	}

	private static int find(int a) {
		// TODO Auto-generated method stub
		//base case
		if(a==arr[a]) return a;
		else {
			return arr[a] = find(arr[a]);
		}
	}

}

/*
	�׷��� Ȥ�� Ʈ���� ��θ� �����ؾ� �ϴ� ��찡 �ʿ��� �� ���Ͽ� ���ε带 ����Ѵ�. 
	���Ͽ� -> �� ��尡 ���� ������ 1���� ��ģ��. �� �� �ڽ� ��尡 �ƴ� �θ� ����� ���� �������� ��ģ��. 
	���ε� -> ��尡 ���� ������ �θ� ��带 ã�´�. 
	

*/


