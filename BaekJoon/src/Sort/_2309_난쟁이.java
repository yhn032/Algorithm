package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _2309_������ {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//���߿� ���� �����Ҷ� �������� �޸� ����ȭ�� ���ؼ� ����Ʈ ���
		List<Integer> small_height = new ArrayList<>(9);
		int sum_height=0;
		
		//������ Ű �ʱ�ȭ �� Ű�� �� �ʱ�ȭ
		for(int i=0; i<9; i++) {
			small_height.add(Integer.parseInt(br.readLine()));
			sum_height += small_height.get(i);
		}
		
		//�̸� �������� �����ϱ� 
		Collections.sort(small_height);
		
		
		//����͸�
		/*
		 * for(int i : small_height) { System.out.println(i); }
		 * System.out.println(sum_height);
		 */
		
		
		//����Ʈ���� ������ 2���� ��
		Integer num1 = 0;
		Integer num2 = 0;
		OUT:
		for(int i =0; i < 9; i++) {
			for(int j=i+1; j<9;j++) {
				if(sum_height-small_height.get(i)-small_height.get(j) == 100) {
					num1 = small_height.get(i);
					num2 = small_height.get(j);
					break OUT;//ã���� �ٷ� Ż��
				}
			}//end-for-j
		}//end-for-i
		
		//�ε����� �����ؼ� �������� ���� ���� �ٷ� ����
		small_height.remove(num1);
		small_height.remove(num2);
		
		//int�� ������ ���
		//small_height.remove(new Integer(num1));
		//small_height.remove(new Integer(num2));
		//sum_height =  sum_height - num1 - num2;
		for(int i : small_height) {
			System.out.println(i);
		}
		//System.out.println(sum_height);
	}

}
