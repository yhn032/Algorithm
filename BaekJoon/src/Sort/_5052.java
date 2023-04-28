package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _5052 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t --> 0) {
			int n = Integer.parseInt(br.readLine());
			
			String [] phone_number = new String[n];
			
			for(int i=0; i<n; i++) {
				phone_number[i] = br.readLine();
			}
			
			/*
				��ȭ��ȣ�� ������������ ���ĵǾ� �ִٰ� �����ϸ�, 
				���ξ� ���迡 �ִ� ���� �ݵ�� �����ϰ� �Ǿ� �ִ�. 
				���ξ� ���� O -> NO
				���ξ� ���� X -> YES
				EX> 
					114
					1145
					1156
				 ���� ��ȣ �� 1,2�� ���ξ� ���迡 �ִ�. 
				 ��, Ư�� ��ȣ �� or �ڷ� ���ξ� ���谡 �ִ��� Ȯ���ϸ� �Ǵµ�
				 �̸� ���� �޼ҵ�� String.startWith('���ڿ�') �޼ҵ带 ����Ͽ�
				 Ư�� ���ڿ��� ��ȣ �ȿ� ���ڿ��� �����ϸ� true, �ƴϸ� false�� ��ȯ�Ѵ�.
			*/
			Arrays.sort(phone_number);
			
			if(isPrefix(n, phone_number)) {
				sb.append("YES").append('\n');
			}else {
				sb.append("NO").append('\n');
			}
		}
		
		System.out.println(sb.toString());
	}

	private static boolean isPrefix(int n, String[] phone_number) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<n-1;i++) {
			if(phone_number[i+1].startsWith(phone_number[i])) return false;
		}
		return true;
	}
}
