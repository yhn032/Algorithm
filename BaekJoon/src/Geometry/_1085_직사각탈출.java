package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1085_���簢Ż�� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		//���� ���� : w
		//���� ���� : h
		
		int []l = new int[4];
		l[0] = x; //�޺����� �Ÿ�
		l[1] = y; //�Ʒ������� �Ÿ�
		l[2] = w-x; //���������� �Ÿ�
		l[3] = h-y; //�������� �Ÿ�
		
		Arrays.sort(l);
		
		System.out.println(l[0]);
	}
}
