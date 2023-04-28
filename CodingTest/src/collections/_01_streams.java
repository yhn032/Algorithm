package collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class _01_streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//배열 스트림 생성 
		String arr[] = new String[] {"a", "b", "c"};
		Stream<String> stream = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
		
		//컬렉션 스트림 
		List<String> list = Arrays.asList("a", "b", "c");
		Stream<String> streamC = list.stream();
		Stream<String> parallelStream = list.parallelStream();// 병렬처리 시스템
		
		//비어 있는 스트림 
		//요소가 없을 때 null대신 사용
		//public Stream<String> streamOf(List<String> list) {
		//	return list == null || list.isEmpty() ? Stream.empty() : list.stream();
		//}
		
		//Stream.builder()
		//빌더를 사용하면 스트림에 직접적으로 원하는 값을 넣을 수 있다. 마지막에 build메소드로 스트림을 리턴한다. 
		Stream<String> builderStream = Stream.<String>builder().add("Eric").add("Elena").add("Java").build();
		//[Eric, Elena, Java]입력된다.
		
		//Stream.generate()
		//supplier<T>에 해당하는 람다로 값을 넣을 수 잇다. supplier는 인자가 없고 리턴값만 있는 함수형 인터페이스
		//이때 생성되는 스트림은 크기가 정해져 있지 않고 무한하기 때문에 특정 사이즈로 최대 크기를 제한해야한다.
		Stream<String> generatedStream = Stream.generate(() -> "gen").limit(5); //-> 5개의 "gen"이 들어간 스트림이 생성된다.
		
		
	}
	

}
