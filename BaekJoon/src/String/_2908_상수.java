package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2908_��� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		//��Ʈ�������� ���� �߰��ϰ�, ������ ����� string���·� ��ȯ�Ѵ�.
		a = sb.append(a).reverse().toString();
		
		//��Ʈ�������� �ʱ�ȭ ��Ų��. ������ 0���� ��������
		//delete�޼ҵ带 ����ϰų� �����ڸ� ����� ���ο� ��ü�� 
		//����� ����� ������ �ð��� �� ���� �ɸ���. 
		sb.setLength(0);
		b = sb.append(b).reverse().toString();
		
		int aa = Integer.valueOf(a);
		int bb = Integer.valueOf(b);
		
		
		System.out.println(aa>bb?aa:bb);
	}

}
