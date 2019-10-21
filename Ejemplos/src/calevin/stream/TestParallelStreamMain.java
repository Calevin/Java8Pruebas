package calevin.stream;

import java.util.Optional;
import java.util.concurrent.ForkJoinPool;

import entidades.Empleado;

public class TestParallelStreamMain {

	public static void main(String[] args) {
		casoNormal();
		casoNormalRelentizado();
		casoNormalParallel();
		casoForkJoinParallel();
	}

	public static void casoNormal() {
		System.out.println("------- casoNormal() -------");
		long t1 = System.currentTimeMillis();
		Optional<Integer> salarioSum = Empleado.empleadosParaTest()
		.stream()
		.map(Empleado::getSalario)
		.reduce(Integer::sum);
		
		long t2 = System.currentTimeMillis();
		
		System.out.println("Salario sum " + salarioSum);
		System.out.println("------- casoNormal() tardo: " + (t2-t1) + "-------");
	}

	public static void casoNormalRelentizado() {
		System.out.println("------- casoNormalRelentizado() -------");
		long t1 = System.currentTimeMillis();
		Optional<Integer> salarioSum = Empleado.empleadosParaTest()
		.stream()
		.peek(System.out::println)
		.map(Empleado::getSalario)
		.map(TestParallelStreamMain::duplicarSueldoRelentizar)
		.reduce(Integer::sum);
		
		long t2 = System.currentTimeMillis();
		
		System.out.println("Salario sum " + salarioSum);
		System.out.println("------- casoNormalRelentizado() tardo: " + (t2-t1) + "-------");
	}
	
	public static void casoNormalParallel() {
		System.out.println("------- casoNormalParallel()() -------");
		long t1 = System.currentTimeMillis();
		Optional<Integer> salarioSum = Empleado.empleadosParaTest()
		.parallelStream()
		.peek(System.out::println)
		.map(Empleado::getSalario)
		.map(TestParallelStreamMain::duplicarSueldoRelentizar)
		.reduce(Integer::sum);
		
		long t2 = System.currentTimeMillis();
		
		System.out.println("Salario sum " + salarioSum);
		System.out.println("------- casoNormalParallel()() tardo: " + (t2-t1) + "-------");
	}
	
	public static void casoForkJoinParallel() {
		System.out.println("------- casoForkJoinParallel()() -------");
		long t1 = System.currentTimeMillis();
		
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);
		Optional<Integer> salarioSum = Optional.empty();
		
		try {
			salarioSum = forkJoinPool.submit( ()->{
				
				return Empleado.empleadosParaTest()
				.parallelStream()
				.peek(System.out::println)
				.map(Empleado::getSalario)
				.map(TestParallelStreamMain::duplicarSueldoRelentizar)
				.reduce(Integer::sum);
				
				
			}).get();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long t2 = System.currentTimeMillis();
		
		System.out.println("Salario sum " + salarioSum);
		System.out.println("------- casoForkJoinParallel()() tardo: " + (t2-t1) + "-------");
	}
	
	public static Integer duplicarSueldoRelentizar(Integer numero) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return numero*2;
	}
	
}
