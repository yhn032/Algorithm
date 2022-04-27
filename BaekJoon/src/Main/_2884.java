package Main;

import java.util.Scanner;
import java.util.StringTokenizer;

public class _2884 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int hour   = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		
		int interval = minute - 45;
		if(interval < 0) {
			hour -= 1;
			minute = 60 - Math.abs(interval);
		} else {
			minute = interval;
		}
		
		if(hour < 0) {
			hour = 24 - Math.abs(hour);
		}
			
		
		System.out.printf("%d %d", hour, minute);
		sc.close();
	}

}
