package BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10757_ū������ {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		st = new StringTokenizer(br.readLine());
		
		String str_A = st.nextToken();
		String str_B = st.nextToken();
		
		//ū ���� ���ڿ��� �о�ͼ� ���ڿ��� ���̸�ŭ�� �迭�� �����Ѵ�. ��, �̶� ���̰� �� �� ���ڿ��� ���̷� �迭�� ũ�⸦ �����Ѵ�. �׷��� ������ �ε������� ������ �������� ��, ���̰� ª������ outofindex�߻� ����
		int str_length = str_A.length() > str_B.length() ? str_A.length() : str_B.length();
		
		int A[] = new int[str_length+1];
		int B[] = new int[str_length+1];
		int result[] = new int[str_length+1];
		
		
		//����� ���Ǽ��� ���ؼ� ���ڿ��� �ڿ��� ���Ͱ��� �Է��Ѵ�. 
		/*
			1234 + 123�� �����Ϸ� �ϴµ� 
			
			�̷��� ������ �ڸ����� ���� ������ ���Ѵ�.
			1234
		+	123
			
			4321
		+	321
		�׷��� �̷��� ���� �Ŵ�.
		*/
		
		//���� A �ʱ�ȭ�ϱ� //�ʱ�ȭ ���� ���� �ε����� 0���� �ʱ�ȭ ��
		for(int i=(str_A.length()-1), k =0 ; i>=0; i--, k++) {
			A[k] = str_A.charAt(i) - '0';
		}
		
		//���� B �ʱ�ȭ�ϱ� //�ʱ�ȭ ���� ���� �ε����� 0���� �ʱ�ȭ ��
		for(int i=(str_B.length()-1), k =0 ; i>=0; i--, k++) {
			B[k] = str_B.charAt(i) - '0';
		}
		
		
		//�ø����� ��� �ø� ���ΰ�
		for(int i=0; i < str_length; i++) {
			int hap = A[i] + B[i];
			
			if(hap>=10) {
				//0~9������ �� ������ ���ؼ� ���� �� �ִ� �ִ� ĳ���� ũ��� 1�̴�. 
				result[i+1] += 1;
				result[i]   += hap%10;
				
			}else { //ĳ���� �߻����� ������ ���������� �ִ´�. ������ ���� 0��
				result[i] += hap%10;
				if(result[i] >= 10) {
					result[i+1] += 1;
					result[i]   = result[i]%10;
					
				}
				
			}
			
		}
		
		
		
		
		
		/*
		 * for(int i=0; i<str_length; i++) { System.out.print(A[i]); }
		 * System.out.println(); for(int i=0; i<str_length; i++) {
		 * System.out.print(B[i]); } System.out.println();
		 */
		for(int i=result.length-1; i>=0; i--) {
			if(i==result.length-1 && result[i]==0) continue;
			System.out.print(result[i]);
		}
		
	}

}

