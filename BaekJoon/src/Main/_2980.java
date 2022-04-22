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
		//신호등 개수
		int N = Integer.parseInt(st1.nextToken());
		//도로 길이
		int L = Integer.parseInt(st1.nextToken());
		
		//배열 선언. 크기는 L+1. 0base이기 때문. 거리는 시작지 포함하지 않아야 함
		TrafficLight [] doro = new TrafficLight[L+1];
		
		StringTokenizer st2;
		//신호등의 정보를 객체 배열에 저장
		for(int i=0; i<N; i++) {
			st2 = new StringTokenizer(sc.nextLine(), " ");
			//신호등의 위치
			int D = Integer.parseInt(st2.nextToken());
			//빨간 불 지속 시간
			int R = Integer.parseInt(st2.nextToken());
			//파란 불 지속 시간
			int G = Integer.parseInt(st2.nextToken());
			
			//신호등이 있는 위치에만 초기화한다. 나머지 인덱스에 관한 값은 초기화 하지 않았으니 null
			doro[D] = new TrafficLight(R,G);
		}
		
		//지속시간과 상근이의 위치
		int time = 0, sang =0;
		
		while(sang < L) {
			
			time++;
			sang++;
			
			if(doro[sang] != null) {
				//신호등이 있다면 해당 시점에서의 시간을 통해 빨간불인지 아닌지 계산해야 한다. 
				//신호등은 "일정한 주기"로 점등이 된다. 지속되는 시간을 전체 사이클의 시간으로 나눈 값의 나머지가 빨간불보다 작다면 아직 빨간불이라는 뜻 
				//예를 들어, R = 7, G = 3이라 하고, 4초가 지났다면, 4%10 = 4 <= 7 이므로 빨간불,, 9초가 지났다면 9%10 =  9 > 7 이므로 파란불이다. 
				//전체 시간중에서 빨간불이 차지한 비율을 계산하여 현재 시간이 빨간불과 파란불중 어느 영역에 속해있는지를 확인하는 것이다.
				int check = time%(doro[sang].R + doro[sang].G);
				
				//빨간불인 경우 기다렸다가 감
				if(check <= doro[sang].R) {
					time += (doro[sang].R - check);
				}
				
			}
			
			
		}
		
		System.out.println(time);
	}

}
