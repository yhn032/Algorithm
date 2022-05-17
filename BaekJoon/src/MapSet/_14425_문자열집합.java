package MapSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _14425_���ڿ����� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		//����S�� ��� ����
		int n = Integer.parseInt(st.nextToken());
		
		//������ �ʿ��� �׽�Ʈ ���̽�
		int m = Integer.parseInt(st.nextToken());
		
		Set<String> hs = new HashSet<String>();
		
		int cnt=0;
		for(int i=0; i<m+n; i++) {
			if(i < n ) {
				hs.add(br.readLine());
				continue;
			}
			
			if(hs.contains(br.readLine())) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
