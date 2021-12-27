import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.*;

class Ex14_6 {
	public static void main(String[] args) {
		File[] fileArr = { new File("Ex1.java"), new File("Ex1.bak"),
			new File("Ex2.java"), new File("Ex1"), new File("Ex1.txt")
		};
		
		// 파일 배열에서 파일 확장자(대문자)를 중복없이 뽑아내기
		// 1.Stream 생성
//		Stream<File> fileStream = Stream.of(fileArr);
//		fileStream.map((File f) -> f.getName()).forEach(s -> System.out.println(s));
		
		// 1.Stream 생성
		Stream<File> fileStream2 = Stream.of(fileArr);
		// 2.File의 이름 꺼내 새로운 Stream생성
		fileStream2.map(f -> f.getName())
			// 2.확장자가 없는건 제외 
			.filter(s -> s.indexOf('.')!=-1)
			.peek(s -> System.out.printf("fileName=%s%n", s))
			// 3.확장자 뒷부분만 map
			.map(s -> s.substring(s.indexOf('.')+1))
			.peek(s -> System.out.printf("'.'제거된name=%s%n",s))
			// 4.대문자로
			.map(s -> s.toUpperCase())
			// 중복 없이
			.distinct()
			// 출력
			.forEach(s -> System.out.println(s));


		
				
		
		 
		
		
//		int count = (int)fileStream.map(f -> f.getName()).filter(s -> s.indexOf('.')!= -1).count();
//		fileStream.map(f -> f.getName()).filter(s -> s.indexOf('.')!= -1).forEach(s -> System.out.println(s));
//		fileStream.map(f -> f.getName()).forEach(s -> System.out.println(s));
		
		// 파일 스트림에서 파일 확장자(대문자)를 중복없이 뽑아내기
		
		

//		Stream<File> fileStream = Stream.of(fileArr);
//
//		// map()���� Stream<File>�� Stream<String>���� ��ȯ
//		Stream<String> filenameStream = fileStream.map(File::getName);
//		filenameStream.forEach(System.out::println); // ��� ������ �̸��� ���
//
//		fileStream = Stream.of(fileArr);  // ��Ʈ���� �ٽ� ����
//
//		fileStream.map(File::getName)     // Stream<File> �� Stream<String>
//			  .filter(s -> s.indexOf('.')!=-1)   // Ȯ���ڰ� ���� ���� ����
//			  .map(s -> s.substring(s.indexOf('.')+1)) // Ȯ���ڸ� ����
//			  .map(String::toUpperCase)     // ��� �빮�ڷ� ��ȯ
//			  .distinct()                   //  �ߺ� ����
//			  .forEach(System.out::print);  // JAVABAKTXT	
//
//		System.out.println();
	}
}