package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _2563 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//��ü ����
		int sumArea=0;
		
		//��ü �������� ��
		int N = Integer.parseInt(br.readLine());
		int cp_pos [][] = new int[100][100];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			//�޺����� �Ÿ� (���� ������)
			int x = Integer.parseInt(st.nextToken());
			//�غ����� �Ÿ� (���� ������)
			int y = Integer.parseInt(st.nextToken());
			
			for(int k=y; k<y+10; k++) {
				for(int j = x; j<x+10;j++){
					cp_pos[k][j] = 1;
				}
			}
						
		}
		//�����̿� ������ �ش��ϴ� ��/����ġ�� 1�� ����. ���߿� 1�� �� ���ؼ� ������ ���ϸ� ��. ��ġ�� ������ 1�� ��� �������
		//ex> 10x10 �迭�� ��� 1�� �ְ� �� ���ϸ� �������� ���� 100�� ���´�.
		for(int i = 0; i < cp_pos.length; i++) {
			for(int k=0; k < cp_pos[i].length; k++) {
				if(cp_pos[i][k] == 1)
					sumArea += cp_pos[i][k];
			}
			
		}
		System.out.println(sumArea);
		
	}

}
