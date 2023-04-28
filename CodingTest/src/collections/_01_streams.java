package collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class _01_streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�迭 ��Ʈ�� ���� 
		String arr[] = new String[] {"a", "b", "c"};
		Stream<String> stream = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
		
		//�÷��� ��Ʈ�� 
		List<String> list = Arrays.asList("a", "b", "c");
		Stream<String> streamC = list.stream();
		Stream<String> parallelStream = list.parallelStream();// ����ó�� �ý���
		
		//��� �ִ� ��Ʈ�� 
		//��Ұ� ���� �� null��� ���
		//public Stream<String> streamOf(List<String> list) {
		//	return list == null || list.isEmpty() ? Stream.empty() : list.stream();
		//}
		
		//Stream.builder()
		//������ ����ϸ� ��Ʈ���� ���������� ���ϴ� ���� ���� �� �ִ�. �������� build�޼ҵ�� ��Ʈ���� �����Ѵ�. 
		Stream<String> builderStream = Stream.<String>builder().add("Eric").add("Elena").add("Java").build();
		//[Eric, Elena, Java]�Էµȴ�.
		
		//Stream.generate()
		//supplier<T>�� �ش��ϴ� ���ٷ� ���� ���� �� �մ�. supplier�� ���ڰ� ���� ���ϰ��� �ִ� �Լ��� �������̽�
		//�̶� �����Ǵ� ��Ʈ���� ũ�Ⱑ ������ ���� �ʰ� �����ϱ� ������ Ư�� ������� �ִ� ũ�⸦ �����ؾ��Ѵ�.
		Stream<String> generatedStream = Stream.generate(() -> "gen").limit(5); //-> 5���� "gen"�� �� ��Ʈ���� �����ȴ�.
		
		
	}
	

}
