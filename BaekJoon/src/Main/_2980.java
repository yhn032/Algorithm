package Main;

import java.util.Scanner;
import java.util.StringTokenizer;

public class _2980 {
	static class TrafficLight{
		int R;
		int G;
		public TrafficLight(int R, int G) {
			// TODO Auto-generated constructor stub
			this.R = R;
			this.G = G;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringTokenizer st1 = new StringTokenizer(sc.nextLine(), " ");
		//��ȣ�� ����
		int N = Integer.parseInt(st1.nextToken());
		//���� ����
		int L = Integer.parseInt(st1.nextToken());
		
		//�迭 ����. ũ��� L+1. 0base�̱� ����. �Ÿ��� ������ �������� �ʾƾ� ��
		TrafficLight [] doro = new TrafficLight[L+1];
		
		StringTokenizer st2;
		//��ȣ���� ������ ��ü �迭�� ����
		for(int i=0; i<N; i++) {
			st2 = new StringTokenizer(sc.nextLine(), " ");
			//��ȣ���� ��ġ
			int D = Integer.parseInt(st2.nextToken());
			//���� �� ���� �ð�
			int R = Integer.parseInt(st2.nextToken());
			//�Ķ� �� ���� �ð�
			int G = Integer.parseInt(st2.nextToken());
			
			//��ȣ���� �ִ� ��ġ���� �ʱ�ȭ�Ѵ�. ������ �ε����� ���� ���� �ʱ�ȭ ���� �ʾ����� null
			doro[D] = new TrafficLight(R,G);
		}
		
		//���ӽð��� ������� ��ġ
		int time = 0, sang =0;
		
		while(sang < L) {
			
			time++;
			sang++;
			
			if(doro[sang] != null) {
				//��ȣ���� �ִٸ� �ش� ���������� �ð��� ���� ���������� �ƴ��� ����ؾ� �Ѵ�. 
				//��ȣ���� "������ �ֱ�"�� ������ �ȴ�. ���ӵǴ� �ð��� ��ü ����Ŭ�� �ð����� ���� ���� �������� �����Һ��� �۴ٸ� ���� �������̶�� �� 
				//���� ���, R = 7, G = 3�̶� �ϰ�, 4�ʰ� �����ٸ�, 4%10 = 4 <= 7 �̹Ƿ� ������,, 9�ʰ� �����ٸ� 9%10 =  9 > 7 �̹Ƿ� �Ķ����̴�. 
				//��ü �ð��߿��� �������� ������ ������ ����Ͽ� ���� �ð��� �����Ұ� �Ķ����� ��� ������ �����ִ����� Ȯ���ϴ� ���̴�.
				int check = time%(doro[sang].R + doro[sang].G);
				
				//�������� ��� ��ٷȴٰ� ��
				if(check <= doro[sang].R) {
					time += (doro[sang].R - check);
				}
				
			}
			
			
		}
		
		System.out.println(time);
	}

}
