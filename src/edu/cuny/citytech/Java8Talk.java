package edu.cuny.citytech;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Stream;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Demonstrate Java 8 features.
 *
 * @author <a href="mailto:rkhatchadourian@citytech.cuny.edu">Raffi
 * Khatchadourian</a>.
 */
public class Java8Talk {

	public static void main(String[] args) {
//		listExample();
//		buttonExample();
//		threadExample();
//		doubleAccumExample();
//		longAdderExample();
//		streamExample();
	}

	private static void listExample() {
		List<String> list = Arrays.asList("Moe", "Larry", "Curly");

		for (String s : list)
			System.out.println(s);

//		list.forEach(s -> System.out.println(s));
//		list.forEach(System.out::println);
	}

	private static void buttonExample() {
		Button btn = new Button();
		final PrintStream pStream = null; //...;
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				pStream.println("Button Clicked!");
			}
		});

//		btn.setOnAction(e -> pStream.println("Button clicked!"));
	}

	private static void threadExample() {
		new Thread() {
			@Override
			public void run() {
				System.out.println("Printing in a new thread");
			}
		}.start();

//		new Thread(() -> System.out.println("Printing in a new thread")).start();
	}

	private static void doubleAccumExample() {
		DoubleAccumulator da = new DoubleAccumulator((x, y) -> x + y, 0.0);
		List<Double> doubles = Arrays.asList(1.0, 2.0, 3.0, 4.0, 10.0);
		doubles.forEach(da::accumulate);

		System.out.println("Result: " + da.doubleValue());
	}

	private static void longAdderExample() {
		LongAdder la = new LongAdder();
		List<Long> longs = Arrays.asList(10L, 20L, 30L, 40L, 100L);
		longs.forEach(la::add);

		System.out.println("Result: " + la.longValue());
	}

	private class Student {
	}

	private static void streamExample() {
		Set<Student> set = new LinkedHashSet<>();
		Stream stream = set.stream();

		Random random = new Random();
		Stream<Integer> randomNumbers = Stream.generate(random::nextInt);
	
		Stream concat = Stream.concat(stream, randomNumbers);
	}

}
