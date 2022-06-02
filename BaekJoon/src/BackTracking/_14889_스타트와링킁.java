package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14889_��ŸƮ�͸�ů {
	static int n;
	static int ability[][];
	static int min = Integer.MAX_VALUE;
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		ability = new int[n][n];
		visit = new boolean[n];
		
		for(int i=0; i<n; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int k=0 ;k<n; k++) {
				ability[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		
		backtracking(0, 0);
		
		
		System.out.println(min);
	}
	private static void backtracking(int idx, int count) {
		// TODO Auto-generated method stub
		if(count == (n/2)) {
			diff();
			return;
		}
		
		
		//1,2�� �����̰ų� 2,1�� ������ ���� �ϳ��� ����� ���̴�. 
		//1,1�� ���� ���� �� ����. 
		//�ߺ��� ������ ������ ������.
		for(int i=idx; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				backtracking(i+1, count+1);
				visit[i] = false;
			}
		}
	}
	private static void diff() {
		// TODO Auto-generated method stub
		int start = 0; 
		int link  = 0;
		
		for(int i=0; i<n-1; i++) {
			for(int k=i+1; k<n; k++) {
				
				if(visit[i] == true && visit[k] == true) {
					start += ability[i][k];
					start += ability[k][i];
				}else if (visit[i]==false && visit[k]==false) {
					link += ability[i][k];
					link += ability[k][i];
				}
			}
		}
		
		int val = Math.abs(start-link);
		
		if(val == 0) {
			//�ּڰ��� 0���� �� ���� �� �����Ƿ� �����Ѵ�. 
			System.out.println(val);
			System.exit(0);
		}
		
		min = Math.min(min, val);
	}

}
