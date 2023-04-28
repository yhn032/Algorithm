package Main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {
		String[] arr = new String[] {"A", "V", "D"};
//		Stream<String> stream = Arrays.stream(arr);					//배열을 스트림으로 만들기
//		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);//배열의 일부분을 스트림으로 만들기

//		List<String> list = Arrays.asList("a", "b", "c");
//		Stream<String> stream = list.stream();
//		Stream<String> parallelStream = list.parallelStream();//병렬처리 스트림
		
		
//		Stream<String> builderStream = 
//				Stream.<String>builder()
//				.add("java").add("is").add("fun")
//				.build();
		
		
		//5개의 "java"가 들어간 스트림 생성
//		Stream<String> generatedStream = Stream.generate(() -> "java").limit(5);
		
//		//[30, 32, 34, 36, 38]
//		Stream<Integer> iteratedStream = Stream.iterate(30, n -> n+2).limit(5);
		
//		IntStream intStream = IntStream.range(1, 5);	//[1, 2, 3, 4] : 종료지점 포함x
//		LongStream longStream = LongStream.rangeClosed(1, 5);	//[1, 2, 3, 4, 5] : 종료지점 포함o
		
		
//		IntStream ints = new Random().ints(3);
//		LongStream longs = new Random().longs(3);
//		DoubleStream doubles = new Random().doubles(3);
		
//		IntStream charStream = "Stream".chars(); //[83, 116, 114, 101, 97, 109]
//		Stream<String> stringStream = Pattern.compile(", ").splitAsStream("Java, Is, Fun"); //[Java, Is, Fun]
	
//		try {
//			Stream<String> lineStream = Files.lines(Paths.get("file.txt"), Charset.forName("UTF-8"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		//List<Product> productList = new ArrayList<>();
		
		//병렬 스트림 생성 
		//Stream<Product> parallelStream = productList.parallelStream();
		
		//병렬 여부 확인 
		//boolean isParallel = parallelStream.isParallel();
		
		//각 작업을 스레드를 이용해 병렬 처리 
		//스트림에서 amout값을 꺼내서 10을 곱한 후 
		//결과값이 200보다 큰 값을 모두 찾는다.
//		boolean isMany = parallelStream
//				.map(product -> product.getAmount()*10)
//				.anyMatch(amount -> amount > 200);
//		
//		//배열을 이용해서 병렬 스트림 만들기 
//		Arrays.stream(arr).parallel();
//		
//		//스트림 연결하기 
//		Stream<String> stream1 = Stream.of("Java", "Scala", "C");
//		Stream<String> stream2 = Stream.of("Python", "Go", "Swift");
//		Stream<String> concat = Stream.concat(stream1, stream2);
		
		
//		List<String> codes = Arrays.asList("Java", "C", "Python", "Javascript", "Go");
		
//		Stream<String> stream = codes.stream()
//				.filter(c -> c.contains("a"));
				
//		Stream<String> stream = codes.stream()
//				.map(String::toUpperCase);
		
//		//중첩 리스트 예제 [[a], [b]]
//		List<List<String>> list = Arrays.asList(Arrays.asList("a"), Arrays.asList("b"));
//		List<String> flatList = list.stream()
//				.flatMap(Collection::stream)
//				.collect(Collectors.toList());

//		List<Integer> list = IntStream.of(14, 11, 20, 39, 23)
//			.sorted()
//			.boxed()
//			.collect(Collectors.toList());
//		System.out.println(list.toString());
		
//		List<String> lang = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");
//		lang = lang.stream()
//				.sorted(Comparator.reverseOrder())
//				.collect(Collectors.toList());
//		System.out.println(lang.toString());
//		
//		lang = lang.stream()
//		.sorted(Comparator.comparingInt(String::length))
//		.collect(Collectors.toList());
//		System.out.println(lang.toString());
//		
//		lang = lang.stream()
//				.sorted((s1, s2) -> s2.length() - s1.length())
//				.collect(Collectors.toList());
//		System.out.println(lang.toString());
		
//		int sum = IntStream.of(1, 3, 5, 7, 9)
//				.peek(System.out::print)
//				.sum();
		
//		long count = IntStream.of(1, 3, 5, 7, 9).count();
//		long sum = IntStream.of(1, 3, 5, 7, 9).sum();
//		
//		//빈스트림인 경우 count와 sum은 0을 출력하며 되지만, 
//		//평균, 최대의 경우에는 표현할 수가 없기 때문에 
//		//마찬가지로 java 8에 등장한 NULL처리 방법인 optional로 감싸서 리턴한다.
//		OptionalInt min = IntStream.of(1, 3, 5, 7, 9).min();
//		OptionalInt max = IntStream.of(1, 3, 5, 7, 9).max();
//		
//		//스트림에서 바로 처리할 수도 있다. 
//		DoubleStream.of(1.1, 2.2, 3.3, 4.4, 5.5)
//			.average()
//			.ifPresent(System.out::println);
//		
//		OptionalInt reduced = IntStream.range(1, 4)
//				.reduce((a,b) -> {
//					return Integer.sum(a, b);
//				});
//		System.out.println(reduced);
//		
//		int reduce = IntStream.range(1, 4)
//				.reduce(10, Integer::sum);
//		System.out.println(reduce);
//		
//		
//		Integer reduceParallel = Arrays.asList(1, 2, 3)
//				.parallelStream()
//				.reduce(10, Integer::sum, (a,b) ->{
//					System.out.println("combiner was called");
//					return a+b;
//				});
//		
//		System.out.println(reduceParallel);
//		
//		List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
//												new Product(14, "orange"),
//												new Product(13, "lemon"),
//												new Product(23, "bread"),
//												new Product(13, "sugar")
//				);
//		
//		List<String> collectorCollection = productList.stream()
//				.map(Product::getName)
//				.collect(Collectors.toList());
//		System.out.println(collectorCollection.toString());
//		
//		String listToString = productList.stream()
//				.map(Product::getName)
//				.collect(Collectors.joining());
//		System.out.println(listToString);
//		
//		String listToString2 = productList.stream()
//				.map(Product::getName)
//				.collect(Collectors.joining(",", "<", ">"));
//		System.out.println(listToString2);
//		
//		
//		List<String> names = Arrays.asList("Eric", "Elena", "Java");
//
//		boolean anyMatch = codes.stream()
//		  .anyMatch(c -> c.contains("a"));
//		boolean allMatch = codes.stream()
//		  .allMatch(c -> c.length() > 3);
//		boolean noneMatch = codes.stream()
//		  .noneMatch(c -> c.endsWith("s"));
//		System.out.println(anyMatch);
//		System.out.println(allMatch);
//		System.out.println(noneMatch);
//		
//		codes.stream().forEach(System.out::println);
//		
//		Double averageAmount = productList.stream()
//				.collect(Collectors.averagingInt(Product::getAmount));
//		System.out.println(averageAmount);
		
//		Integer summingAmount = productList.stream()
//				.collect(Collectors.summingInt(Product::getAmount));
//		System.out.println(summingAmount);
		
//		Integer summingAmount = productList.stream()
//				.mapToInt(Product::getAmount)
//				.sum();
//		System.out.println(summingAmount);
//		
//		IntSummaryStatistics statistics = productList.stream()
//				.collect(Collectors.summarizingInt(Product::getAmount));
//		System.out.println(statistics);
//		
//		Map<Integer, List<Product>> collectMapOfLists = productList.stream()
//				.collect(Collectors.groupingBy(Product::getAmount));
//		System.out.println(collectMapOfLists);
//		
//		Map<Boolean, List<Product>> mapPartitioned = productList.stream()
//				.collect(Collectors.partitioningBy(res -> res.getAmount() > 15));
//		System.out.println(mapPartitioned.toString());
//		
//		Set<Product> unmodifiableSet = productList.stream()
//				.collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
//	
//		
//		Collector<Product, ?, LinkedList<Product>> toLinkedList = Collector.of(LinkedList::new,
//				LinkedList::add, (first, second) -> {
//					first.addAll(second);
//					return first;
//				});
//		
//		LinkedList<Product> linkedListOfPersons = productList.stream()
//				.collect(toLinkedList);
		
		//Match 1 : for-loop vs 순차 스트림
		Random r = new Random();
		int []ints = new int[500000];
		List<Integer> list = new ArrayList<Integer>(500000);
		
		for(int i=0; i<ints.length;i++) {
			ints[i] = r.nextInt();
			list.add(r.nextInt());
		}
		
		//for-loop
		long start = System.currentTimeMillis();
		int [] a = ints;
		int e = a.length;
		int m = Integer.MIN_VALUE;
		for(int i=0; i<e; i++) {
			if(a[i] > m) m = a[i];
		}
		long end = System.currentTimeMillis();
		System.out.println("for-loop : " + (end-start) + "ms");
		
		
		//sequential stream 
		start = System.currentTimeMillis();
		m = Arrays.stream(ints)
				.reduce(Integer.MIN_VALUE, Math::max);
		end = System.currentTimeMillis();
		System.out.println("sequential stream  : " + (end-start) + "ms");
		
		//result 1 : 압도적인 속도 차이가 발생한다. 하지만 이는 primitive type이기 때문인점도 있는데 아래를 이어서 보자구
		
		
		
		
		//Match 2 : Wrapper Type
		m = Integer.MIN_VALUE;
		
		//for-loop
		start = System.currentTimeMillis();
		for(Integer i : list) {
			if(i > m) m = i;
		}
		
		end = System.currentTimeMillis();
		end = System.currentTimeMillis();
		System.out.println("for-loop : " + (end-start) + "ms");
		
		//sequential stream
		start = System.currentTimeMillis();
		m = list.stream().mapToInt(x -> x).max().orElseThrow(NoSuchElementException::new);
		end = System.currentTimeMillis();
		System.out.println("sequential stream : " + (end-start) + "ms");
		
		
		//result 2 : wrapper type은 그 차이가 크게 줄어든 것을 확인할 수 있다. 리스트를 순회하는 비용 자체가 크기 때문에 성능 차이를 압도하는 것이다.
		//또한 int와 같은 primitive 타입은 직접 참조 방식으로 stack에 실데이터가 존재하는 주소를 저장하기 때문에 한 번에 접근이 가능하지만 
		//wrapper타입은 힙 메모리에 데이터가 저장되고 이 데이터의 주소를 중간의 핸들 메모리가 갖고 있으며, 스택에 있는 참조변수는 이 핸들 메모리의 주소를 기억하고 있기에 총 두번의 참조가 일어나서 래퍼가 비교적 더 느린거임
		
		//즉, 자주 참조되는 변수가 객체는 직접 참조 방식이 월등하게 빠르기 때문에 1번째 결과에서는 압도적인 성능 차이를 보였지만, 두 번쨰는 간접 참조를 함으로써 for-loop의 컴팡이러 최적화 이점이 사라진 것이다. 
		
		
		
		//지금까지의 비교는 순회 비용(모든 요소 순회)이 계산비용(대소 비교)보다 높은 것에 대한 고찰이었다. 
		//이번엔 순회비용보다 계산비용이 더 높은 예시를 보자.w
		
		
	}
	
	public Stream<String> streamOf(List<String> list){
		return (list == null || list.isEmpty()) ? Stream.empty() : list.stream();
	}
	
	static class Product {
		int amount = 0;
		String name = "";
		
		public Product(int amount, String name) {
			this.amount = amount;
			this.name = name;
		}
		
		public int getAmount() {
			return this.amount;
		}
		
		public String getName() {
			return this.name;
		}
	}
}
