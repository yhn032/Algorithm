package Main;

import java.util.ArrayList;
import java.util.List;

public class _4673_셀프넘버 {
	static List<Integer> list = new ArrayList<Integer>(10000);
	public static void main(String[] args) {
		//생성자가 없는 숫자를 셀프넘버라고 한다. 
		//33 -> d(33) = 33 + 3 + 3 = 39
		
		
		for(int i=1; i<=10000;i++) {
			self_number(i);
			if(list.contains(i)) 
				continue;
			System.out.println(i);
		}
	}

	private static void self_number(int i) {
		// TODO Auto-generated method stub
		int tmp = 0;
		
		if(i<10) { //한 자리 수
			tmp = i + i;
		}else if(i<100) { //두 자리 수
			tmp = i/10 + i%10 + i;
		}else if(i >= 100 && i < 1000) { //세자리 수
			tmp = i/100 + (i/10)%10 + (i%10) + i;
		}else { //네자리수
			tmp = i/1000 + (i/100)%10 + (i/10)%10 + i%10 + i;
		}
		
		list.add(tmp);
	}
}
