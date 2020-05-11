package fr.mael.showndownAI;

import java.io.IOException;
import java.net.URISyntaxException;

import fr.mael.showndownAI.pokemonData.PokeApiFacade;

public class Main {

	public static void main(String[] args) throws URISyntaxException, IOException {
		init();
		// BattleThread thread1 = new BattleThread();
		// thread1.run();
	}

	private static void init() throws URISyntaxException, IOException {
		PokeApiFacade.getInstance().getMove("ice-beam");
	}

}
