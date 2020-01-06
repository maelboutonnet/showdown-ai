package fr.mael.showndownAI;

import java.io.IOException;
import java.net.URISyntaxException;

import fr.mael.showndownAI.network.WebsocketFacade;

public class Main {
	
	

	public static void main(String[] args) throws URISyntaxException, IOException {
		System.out.println("Hey, it's me ! Arak-with-a-brain !");
		init();
		
	}

	private static void init() throws URISyntaxException, IOException {
		
		WebsocketFacade facade = new WebsocketFacade();
		 
		facade.sendMessage("|/msg Arakasi, Hello there!");
		
		while(true) {}
		
	}

}
