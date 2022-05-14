package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2798_���� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		// ī���� ����
		int n = Integer.parseInt(st.nextToken());

		// �����ؾ� �ϴ� ��
		int m = Integer.parseInt(st.nextToken());

		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		// ī���� ���� ���� ���� �ʱ�ȭ
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			// System.out.print(arr[i] + " ");
		}

		// ������ ���� ���� m�� �����ؾ��Ѵ�. ������ ���� ���� M���� �۴ٴ� ���� �ֱ� ������ ������ ���� ����

		int sum = 0;
		int max = 0;
		for (int i = 0; i < n - 2; i++) {
			// ���� m�� ���� �����Ƿ� skip�Ѵ�.
			if (arr[i] > m)
				continue;

			for (int j = i+1; j < n - 1; j++) {
				if (arr[i] + arr[j] > m)
					continue;

				for (int k = j+1; k < n; k++) {
					if (arr[i] + arr[j] + arr[k] > m)
						continue;

					sum = arr[i] + arr[j] + arr[k];
					// System.out.print(sum + " ");

					if (sum == m) {
						System.out.println(sum);
						return;
					}

					// ������ ī���� ���� m���� ���� ���ֿ���, ���� �ݺ����� �����պ��� ���� ũ�ٸ� max�� ���� -> ���� m�� �����ϴ���,,
					if (max < sum && sum < m) {
						max = sum;
					}
				} // end-for-k
			} // end-for-j
		} // end-for-i

		System.out.println(max);

	}

}
