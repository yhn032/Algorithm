package Main;

import java.util.Arrays;
import java.util.Comparator;

interface ExLamdaInterface{
	public void method();
}

public class LambdaTest {
	
//	void anonymousClass() {
//		final Server server = new HTTPServer();
//		waitFor(new Condition() {
//			public Boolean isSatisfied(){
//				return !server.isRunning();
//			}
//		})
//	}
//	
//	void closure() {
//		Server server = new HTTPServer();
//		waitFor(() -> !server.isRunning());
//	}
//	
//	private String firstName = "Jack";
//	
//	public void example() {
//		Function<String, String> addSurName = surname -> {
//			return firstName + " " + surname;
//		}
//	}
//	public class ShadowingExample{
//		
//		private String firstName = "Charlie";
//		
//		public void ShadowingExample(String firstName) {
//			Function<String, String> addSurName = surname -> {
//				//firstName : 매개변수
//				//this.firstName : "Charlie:
//				return this.firstName + " " + surname;
//			}
//		}
//	}
	
	public static void main(String[] args) {
		//Arrays.sort()와 익명 클래스 
		Integer numbers[] = new Integer[] {1,2,3,4,5};
		Arrays.sort(numbers, new Comparator<Integer>() {
		
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
//		@SuppressWarnings("rawtypes")
//		public static final List EMPTY_LIST = new EmptyList<>();
//		@SuppressWarnings("unchecked")
//		public static final <T> List<T> emptyList() {
//		    return (List<T>) EMPTY_LIST;
//		}
//		
//		
//		static void processNames(List<String> names) {
//			for(String name : names) {
//				System.out.println("Hello " + name);
//			}
//		}
//		
//		List<String> name = Collections.emptyList();		//타입  추론 가능
//		processNames(Collections.emptyList());				//타입 추론 불가능
		
		//Arrays.sort()와 람다 
		Arrays.sort(numbers, (first, second) -> first.compareTo(second));
	}
}
