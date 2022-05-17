package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _7568_��ġ {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		person p[] = new person[n];

		// ��ü �迭 �ʱ�ȭ
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			p[i] = new person(weight, height, i);

		}

		/*
		 * for (person pp : p) { System.out.println(pp.weight + " " + pp.height + " " +
		 * pp.idx + " " + pp.rank); } System.out.println();
		 */

		// ��ü ����
		Arrays.sort(p, new Comparator<person>() {

			@Override
			public int compare(person o1, person o2) {
				// TODO Auto-generated method stub
				if (o1.weight == o2.weight) {
					return o1.height - o2.height;
				} else {
					return o1.weight - o2.weight;
				}
			}

		});

		/*
		 * for (int i = 1; i < n; i++) { // ���ǿ� �����Ҷ��� ����(���� �� �ε�����ȣ�� Ȱ���ؾ� 3,4�� ���� 5��
		 * ��°���) if (p[i].weight < p[i - 1].weight && p[i].height < p[i - 1].height) {
		 * p[i].rank = i + 1; } else { // �ƴϸ� ���� ���� ��� p[i].rank = p[i - 1].rank; } }
		 */
		
		//ranking algorithm
		for(int i=0; i<n ;i++) {
			int w = p[i].weight;
			int h = p[i].height;
			int cnt = 0;
			for(int k=i+1 ; k<n; k++) {
				if(w < p[k].weight && h < p[k].height) {
					cnt++;
				}
			}
			p[i].rank += cnt;
		}

		/*
		 * for (person pp : p) { System.out.println(pp.weight + " " + pp.height + " " +
		 * pp.idx + " " + pp.rank); }
		 */

		int arr[] = new int[n];
		while (n-- > 0) {
			arr[p[n].idx] = p[n].rank;
		}

		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

}

class person {

	int weight;
	int height;
	int idx;
	int rank;

	public person(int weight, int height, int idx) {
		this.weight = weight;
		this.height = height;
		this.idx = idx;
		this.rank = 1;
	}

}
