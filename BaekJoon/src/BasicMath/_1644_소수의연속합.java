package BasicMath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _1644_�Ҽ��ǿ����� {

	static List<Integer> p_list = new ArrayList<Integer>(283146);
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		// n���� ���� �Ҽ��� ��� ������ �����佺�׳׽��� ü
		int arr[] = new int[n + 1];
		// n�� ���� 0�� ������ 1�� �Ҽ��� �ƴϴ� 0���� �ʱ�ȭ
		for (int i = 2; i <= n; i++) {
			arr[i] = i;
		}

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (arr[i] == 0)
				continue;

			for (int k = i + i; k <= n; k += i) {
				arr[k] = 0;
			}
		}
		/*
		 * int count =0; for(int i : arr) { if(i==0) continue; count++; }
		 * System.out.println(count);
		 */

		for (int i : arr) {
			if (i == 0)
				continue;
			p_list.add(i);
		}

		/*
		 * for (int i : p_list) { System.out.print(i + " "); }
		 */

		int start = 0;
		int end = 0;
		int cnt = 0;// n�� ��츦 �̸� ī��Ʈ
		int sum = 0;

		while (true) {
			if (end == p_list.size() || start == p_list.size() || start > end) {
				break;
			}

			sum = sum_2(start, end);
			if (sum == n) {
				cnt++;
				end++;
			} else if (sum > n) {
				start++;

			} else {
				end++;
			}

		}


		System.out.println(cnt);
		/*
		 * for(int i: arr) { System.out.print(i + " "); }
		 */

	}

	private static int sum_2(int start, int end) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += p_list.get(i);
		}
		return sum;
	}

}
