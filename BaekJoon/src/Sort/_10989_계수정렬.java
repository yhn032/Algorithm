package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10989_������� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		
		int counting[] = new int[10001]; //���� ���� 1~10000
		
		for(int i=0; i<n; i++) {
			counting[Integer.parseInt(br.readLine())]++;//�󵵼��� �������� �Ѵ�.
		}
		
		//���� ������ ��ġ�� counting�迭���� �� ������ �󵵼��� �Էµȴ�. -> �� counting[5]�� ���� �Է� ���� 5�� ������ ��Ÿ����. 
		//���� ī���ü�Ʈ�� �ִ� ���� 0�̵� �� ���� -1�� �ϸ鼭 ����迭�� ������ش�.
		
		//0�� ���� ������ ���Ե��� �����Ƿ� skip
		//�ε����� �ش��ϴ� ���� 0�̸� �ǳ� �ٱ� ������ �迭�� ��⿣ �ε��� ó���� ��ġ���� �ٷ� ���
		for(int i=1; i<counting.length; i++) {
			while(counting[i] > 0) {
				sb.append(i).append('\n');
				counting[i]--;
			}
		}
		System.out.println(sb);
		
		
	}

}
