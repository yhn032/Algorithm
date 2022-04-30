package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3048 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// �� -> ���������� �̵��ϴ� ���� ��
		int N1 = Integer.parseInt(st.nextToken());
		// ���� -> �������� �̵��ϴ� ���� ��
		int N2 = Integer.parseInt(st.nextToken());

		// ���������� �̵��ϴ� ���̵��� ���� ����
		String temp1 = br.readLine();
		char ant_left_right[] = new char[N1];
		for (int i = 0; i < N1; i++) {
			ant_left_right[i] = temp1.charAt(N1 - 1 - i);// �ڿ������� �о�´�.
		}

		String temp2 = br.readLine();
		char ant_right_left[] = new char[N2];
		ant_right_left = temp2.toCharArray();

		// ��ü���� ��ġ�� ��Ÿ�� ���ڹ迭, ������ ��Ÿ���� ���¹迭. true(right), false(left)
		char ant[] = new char[N1 + N2];
		boolean check[] = new boolean[N1 + N2];

		for (int i = 0; i < N1; i++) {
			ant[i] = ant_left_right[i];
			check[i] = true;
		}

		for (int i = N1; i < N1 + N2; i++) {
			ant[i] = ant_right_left[i - N1];
			check[i] = false;
		}

		
		/*
		 * for (char s : ant) { System.out.print(s); } System.out.println();
		 */
		
		// ���� ���ϸ鼭 swap�غ���
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			for (int i = 0; i < ant.length - 1; i++) {
				if (check[i] == true && check[i + 1] == false) {
					// ������ ��ġ�� swap
					char tmp = ant[i];
					ant[i] = ant[i + 1];
					ant[i + 1] = tmp;
					// ������ ������ ��Ÿ���� ���º����� swap
					boolean tmp2 = check[i];
					check[i] = check[i + 1];
					check[i + 1] = tmp2;
					/*
					T�� 1�ʾ� �����Կ� ���� ���ϴ� ���¸� ������ ���̴�. 
					�񱳸� ������ġi���� ������ġ i+1�� ���ϴµ�, �ڸ��� �ٲٰ� 
					i++�� ������ �ʴ´ٸ�, �Ȱ��� ���̸� ��� �񱳸� �ؼ� 
					�ᱹ 1�ʵ��� A���̴� ���ֺ��� ���� ������ ���̵��� ��� �����ϰ� �ȴ�. 
					���� �ڸ��� �ٲپ��ٸ�,�ݺ��� ������ i�� �����ϴµ� 
					i���� i+1��ġ�� �� A�� �� �˻����� �ʱ� ���ؼ� i�� �������� +1���־� 
					A�� �� �� ��� ���� �ʵ��� �Ѵ�. 
					���� T���� ������ �� A�� ����ĥ�ٵ� �׶� �ڸ��� �����ϸ� �� 
					*/
					i++;
				}
			}

		}
		

		// T�� 0�̶�� ���� while�� �������� �ʰ� �ٷ� �ʱ� ���¸� ����Ѵ�.
		for (char tmp : ant) {
			System.out.print(tmp);
		}

		/*for (boolean s : check) {
			System.out.print(s + " ");
		}*/

	}

}
