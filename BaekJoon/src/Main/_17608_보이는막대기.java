package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _17608_���̴¸���� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int building[] = new int[N];
		for(int i=0; i<N;i++) {
			building[i] = Integer.parseInt(br.readLine());
			//System.out.print(building[i] + " ");
		}
		int count=1;
		int max = building[N-1];
		for(int i=N-2; i>=0;i--) {
			if(max < building[i]) {
				count++;
				//7 8 5�� ����Ⱑ �־����ٸ� �����ʿ��� ���� ��, 7�� 8�� �������� ������ �ʴ´�.
				//���� ���� �ƽ������� �� ū���� ������ �ִ밪�� �����ؼ� �ִ밪���� ū ���븸 ���̵��� �ؾ��Ѵ�.
				max = building[i];
			}
		}
		System.out.println(count);
	}
}
