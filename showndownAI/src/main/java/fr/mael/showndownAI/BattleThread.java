package fr.mael.showndownAI;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

import fr.mael.showndownAI.network.WebsocketFacade;

public class BattleThread implements Runnable {
	
	WebsocketFacade facade;
	
	

	public BattleThread() throws URISyntaxException, IOException {
		facade = new WebsocketFacade();
	}

	@Override
	public void run() {
		facade.sendChallenge("[Gen 8] Unrated Random Battle");
		try (Scanner reader = new Scanner(System.in)) {
			// Reading from System.in
			reader.useDelimiter("\r\n");
			System.out.println("Enter a command: ");
			String line = reader.next();
			while(!"exit".equals(line)) {
				facade.sendCommand(line);
				System.out.println("Enter a command: ");
				line = reader.next();
			}

		}
	}

}
