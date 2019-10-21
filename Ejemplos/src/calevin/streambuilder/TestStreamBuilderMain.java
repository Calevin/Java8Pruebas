package calevin.streambuilder;

import java.util.stream.Stream;

public class TestStreamBuilderMain {

	public static void main(String[] args) {

		streamNumerosPares(99).forEach(System.out::println);
	}

	public static Stream<Integer> streamNumerosPares(int limite){
		
		Stream.Builder<Integer> builderInteger = Stream.builder();
		
		for (int i = 0; i < limite; i++) {
			if(i % 2== 0) {
				builderInteger.add(i);
			}
		}
		
		return builderInteger.build();
	}
	
}
