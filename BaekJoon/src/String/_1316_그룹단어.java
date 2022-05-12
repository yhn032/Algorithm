package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1316_�׷�ܾ� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		List<Character> list = new ArrayList<Character>();
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		OUT:
		for(int i=0 ; i<n; i++) {
			String str = br.readLine();
			list.clear();
			for(int k=1; k<str.length();k++) {
				char c1 = str.charAt(k-1);
				char c2 = str.charAt(k);
				
				if(c1 != c2) {//�������� �������� �ٸ��ٸ�,,,
					
					if(!list.contains(c1) && !list.contains(c2)) {//���� ���� ���� ���� ������ ���� �־��.
						list.add(c1);
						//list.add(c2);
					}else {//�ش� ���� ���� �ִµ� �ǳ��°Ŵ�.
						continue OUT;
					}
				}
				
			}
			cnt++;
		}
		
		System.out.println(cnt);
	}

}

/*
	���ڰ� �ݺ��ؼ� �����ؾ� �Ѵ�.
	�ϳ��� ���ڵ� 1���� �������� ������ �Ѵ�. 
	��, �ݺ������� �����ϴµ� �� ���̿� �ٸ� ���ڰ� ���������� �׷�ܾ �ƴϴ�. 
	
	�ݺ��� ���������� -> ���� �ٲ𶧸��� list�� �ٲ�� ������ ���� �ִ´�. 
	���� �ֱ� ���� ����Ʈ�� ���� �ִ��� �˻��Ѵ�. -> ������ �ְ�, ���� �ִٸ� �տ��� �����ߴµ� �ǳ��Դٴ� �ǹ��̹Ƿ� �׷�ܾ �ƴϴ�.
*/

