package test;

import java.util.function.Consumer;

public class TestInit {
	
	private static final Consumer<String[]> T = (String[] args) -> Test.main(args) ;
	
	public static void main(String[] args) {
		T.accept(args);
	}
}
