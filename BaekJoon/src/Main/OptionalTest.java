package Main;

import java.util.Optional;

public class OptionalTest {
	public static void main(String[] args) {
		Optional<String> optional = Optional.empty();
		System.out.println(optional);	//Optional.empty
		System.out.println(optional.isPresent()); //false
		
		//Optional안에서는 값이 있을 수도 있고 빈 객체 일수도 있다.
		Optional<String> optional2 = Optional.ofNullable(getString());
		String result = optional2.orElse("other"); //값이 없으면 other를 리턴
		System.out.println(result);
		
//		String val = null;
//		String res = "";
//		try {
//			result = val.toUpperCase();
//		} catch (NullPointerException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
//		String value = null;
//		Optional<String> valueOpt =  Optional.ofNullable(value);
//		String res = valueOpt.orElseThrow(CustomException::new).toUpperCase();
	}

	private static String getString() {
		// TODO Auto-generated method stub
		return "java";
	}
	
}
