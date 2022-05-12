package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1107_remote {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		//��ǥ ä��
		int N = Integer.parseInt(br.readLine());
		
		//���峭 ��ư��
		int M = Integer.parseInt(br.readLine());
		
		boolean error[] = new boolean[10];
		if(M != 0) { //���峭 ��ư�� �ִ� ���� �Ҹ� �迭 ����
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				int n = Integer.parseInt(st.nextToken());
				error[n] = true;//���峭 ��ư�� �ε����� �ش��ϴ� ��ġ���� true���� �־� ���峲�� ǥ��������. -> �������� �⺻���� false
			}
		} 
		//���峭 ��ư�� ���� ���� ��� false���·� ����
		
		/*
		 * for(int i =0; i<error.length;i++) { System.out.println(error[i]); }
		 */
		//+,-��ư���θ� �̵��ؾ� �ϴ� ����, ���ڹ�ư�� ������ �ٻ簪���� �̵��� �Ŀ� +,-���� �߰� �̵��ϴ� ��� 2���� ����� �ּҰ��� ���Ѵ�.
		
		
		//1. 0~9������ ��ư�� ��� ���峪�� +,-��ư���θ� �����Ѵٸ� �׶��� ��ư�� ������ �ϴ� ����� ��
		int result = Math.abs(N-100);
		
		//��ǥ ä�ΰ� �ٻ��� ���ڸ� �����Ŀ� +,-�� �̵��ϴ� ���
		//�ٻ��� ���� ã�� ����Ǽ��� �ʹ� ���Ƽ� �׳� ������ �� �˻����� [����Ž��]
		//�⺻������ ���ڹ�ư�� ������ Ƚ���� ���ڼ��� �޾Ƽ� ī��Ʈ���ش�.
		/*
			0~999999�� ��� ���ڸ� Ž���ҰŴ�. 
			�־��� ��츦 �����ϸ� �ִ� ä�ι�ȣ�� 500000���� �̵��ؾ��� �� �ڸ����� �����ϴ� ä���� 6�ڸ����� �ִ��̰�, ��ư �� ���� ū�� 9�� �����ϰ� ��� ���峵�ٰ� ������ ��, 
			999999���� �̵��ؼ� +,-��ư���θ� �̵��ؾ� �� ��������(100���� ���� �̵��ϴ°� �ּڰ��� ���� ������ ���峪�� ���� ��ư�� 9�� �ִٰ� �����ϸ� �ִ밪�� 999999�̴�.)
		*/
		
		for(int i =0; i<=999999; i++) {
			//���� ��ư�� ������ �̵��ϰ��� �ϴ� ���� ���̸� ���Ѵ�. ���̰� ���ڹ�ư�� ������ Ƚ���� �Ǹ���.
			String str = String.valueOf(i);
			int len = str.length();
			
			boolean broken = false;
			//2-1
			//�ٻ簪���� ������ ���� ���� ���峭 ��ư�� ������ �ϴ� ��Ȳ�� �´ٸ� �ٷ� �н��ع�����.
			for(int j=0; j<len;j++) {
				//���ڿ��� ����ȭ ��Ű��
				if(error[str.charAt(j)-'0']) {
					//���⼭ true�� �־����� �ؿ� ������ �˻����� �ʰ� �ٷ� �������� �Ѿ��. 
					broken= true;
					break;
				}
			}
			if(broken==true) continue;
			//2-2
			if(!broken) {//�̵��� �� �ִ� �� �߿��� ��� ���ڸ� ��ư���� ���� �� �ִ� ��� 
				//�ʱ���ġ 100���� ��ư���� ������ �̵��� �� �ִ� ��ġ i���� ���̸� ���ϰ�, ��ư�� ������ Ƚ���� ���ڿ��� �����̹Ƿ� �����ش�. 
				//�̷������� ��� ����Ǽ��� Ž���ϸ鼭 �ּڰ��� �����ִ� ������ �ݺ��ϸ� �ݺ����� ����Ǿ��� ���� ���� ���� ���� �����ְ���,,,?
				int min = Math.abs(N-i) + len;
				result = Math.min(min, result);
			}
		}
		System.out.println(result);
		
	}

}
