package String;

import java.util.Scanner;
import java.util.StringTokenizer;

public class _2675_���ڿ��ݺ� {
	public static void main(String[] args) {
		//a~z = 26
		//97~122
		//A~Z = 26
		//65~90
		//int arr[] =new int[26];
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int t = sc.nextInt();
		sc.nextLine();
		
		//�׽�Ʈ���̽�
		for(int i=0; i<t;i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int r = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			//�����Ǳ���
			for(int k=0; k<str.length();k++) {
				//�ݺ�Ƚ��
				for(int j=0; j<r;j++) {
					sb.append(str.charAt(k));
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
		sc.close();
	}
}
