package fr.mael.showndownAI;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
	
	

	public static void main(String[] args) throws URISyntaxException, IOException {
		init();
		BattleThread thread1 = new BattleThread();
		thread1.run();
	}

	private static void init() throws URISyntaxException, IOException {
		
	}

}
