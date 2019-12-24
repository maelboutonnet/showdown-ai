package fr.mael.showndownAI;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hey, it's me ! Arak-with-a-brain !");
		init();
	}

	private static void init() {
		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		try {
			container.connectToServer(WebsocketClient.class, new URI("ws://sim.smogon.com:8000"));
		} catch (DeploymentException | IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {}
	}

}
