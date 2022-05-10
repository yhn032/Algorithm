package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class _1448_triangle {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//���� �亯�� ���̰� ������ �κ��� �պ��� �۾ƾ� �Ѵ�.
		//���� ū �ﰢ���� ���ϰ� �ʹ�.
		//���� ���̸� ������������ �������� ���� ū���� �������� ������ �κ��� �� ������ ū�� Ȯ��
		//���� �ﰢ���� ���������� �����ϴ� �� �߿��� �ִ밪�� ������
		
		List<Integer> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
			
		});
		
		Integer a1;
		Integer a2;
		Integer a3;
		int max = 0;
		for(int i=0; i<N-2;i++) {
			a1 = list.get(i);
			a2 = list.get(i+1);
			a3 = list.get(i+2);
			
			//������������ ���������� ���� ū 3���� �ذ��� ���� ������, ������ �� �ؿ��� �� �������� �ֱ⶧����
			//�� ���� ���� ���� ū������ Ŭ �� ����. �ᱹ�� ����ū ������ ����������, ������ �Ǹ� �װ��� �ִ��̴�. 
			//20 14 8 7 5 3
			//���� ���� �����Ͱ� ���� ��, 20 14 8�ε� �ﰢ���� �����ǰ�, 20 14 7�ε� �ﰢ���� ���������� ������ ���̰� �ִ��� ����̹Ƿ� ���ڰ� ����
			if(a2+a3 > a1) {
				max = max > (a1+a2+a3) ? max : (a1+a2+a3);
			}
		}
		if(max == 0) {
			System.out.println(-1);
		} else {
			System.out.println(max);
		}
		
		for(int i : list) {
			System.out.println(i);
		}
		
	}

}

