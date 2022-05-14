package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2798_블랙잭 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		// 카드의 개수
		int n = Integer.parseInt(st.nextToken());

		// 근접해야 하는 값
		int m = Integer.parseInt(st.nextToken());

		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		// 카드의 적힌 수의 종류 초기화
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			// System.out.print(arr[i] + " ");
		}

		// 세장의 수의 합이 m에 근접해야한다. 하지만 수의 합이 M보다 작다는 말이 있기 때문에 조건이 아주 편함

		int sum = 0;
		int max = 0;
		for (int i = 0; i < n - 2; i++) {
			// 합이 m을 넘지 않으므로 skip한다.
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

					// 세장의 카드의 합이 m보다 작은 범주에서, 이전 반복에서 구한합보다 합이 크다면 max값 갱신 -> 점점 m에 접근하는중,,
					if (max < sum && sum < m) {
						max = sum;
					}
				} // end-for-k
			} // end-for-j
		} // end-for-i

		System.out.println(max);

	}

}
