package fr.mael.showndownAI.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.mael.showndownAI.battleData.Battle;

public class WebsocketFacade {

	private final Logger LOGGER = LogManager.getLogger(getClass());
	private WebsocketClient client;
	private Properties prop;
	
	private Battle battle;
	
	
	public WebsocketFacade() throws URISyntaxException, IOException {
		
		LOGGER.info("Loading properties...");
		
		loadPrivateProperties();
		
		LOGGER.info("Opening websocket...");
		
		LoggerMessageHandler messageHandler = openWebsocket();
		
		LOGGER.info("Challstr received...");
		
	    login(messageHandler);
	    
	    battle = new Battle();
		
	}

	private void loadPrivateProperties() {
		prop = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("private.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            LOGGER.error("Error while loading properties", ex);
        }
	}

	private void login(LoggerMessageHandler messageHandler)
			throws UnsupportedEncodingException, IOException, ClientProtocolException {
		HttpPost post = new HttpPost("http://play.pokemonshowdown.com/action.php");

        // add request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList();
        urlParameters.add(new BasicNameValuePair("name", prop.get("bot.login").toString()));
        urlParameters.add(new BasicNameValuePair("pass", prop.get("bot.password").toString()));
        urlParameters.add(new BasicNameValuePair("challstr", messageHandler.challStrMsg[2] + "|" + messageHandler.challStrMsg[3]));
        
        urlParameters.add(new BasicNameValuePair("act", "login"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        Map<String, Object> data;
        
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {
        	String result = EntityUtils.toString(response.getEntity());
            LOGGER.info(result);
            Gson gson = new GsonBuilder().create();
            data = (Map<String, Object>) gson.fromJson(result.substring(1), Object.class);
        }
        LOGGER.info("Login sent...");
        
        client.sendMessage("|/trn "+ prop.get("bot.login").toString() + ",0,"+data.get("assertion"));
		
        LOGGER.info("Login confirmed...");
	}

	private LoggerMessageHandler openWebsocket() throws URISyntaxException {
		URI endpointURI = new URI("ws://sim.smogon.com:8000/showdown/websocket");
		client = new WebsocketClient(endpointURI);
		LoggerMessageHandler messageHandler = new LoggerMessageHandler();
		client.setMessageHandler(messageHandler);
		//client.sendMessage("Something");
		int waitingCpt = 0;
		while(messageHandler.challStrMsg == null) {
			waitingCpt++;
			if (waitingCpt == 1000) {
				LOGGER.info("Waiting for challStr message");
				waitingCpt = 0 ;
			}
			//we're waiting for challstr message to get to us.
			//will allow us to log in.
		}
		return messageHandler;
	}

	public void sendMessage(String userName, String msg) {
		client.sendMessage("|/msg "+userName+","+msg);
	}
	
	public void sendChallenge(String userName, String format) {
		BattleMessageHandler battleHandler = new BattleMessageHandler(battle);
		client.setMessageHandler(battleHandler);
		client.sendMessage("|/challenge "+userName+","+format);
	}
	
	
	/* Methods there are for tests and building purposes */
	

	public void sendMessage(String msg) {
		this.sendMessage(prop.getProperty("bot.opponent"), msg);
	}
	
	public void sendChallenge(String format) {
		this.sendChallenge(prop.getProperty("bot.opponent"), format);
	}
	
	public void sendCommand(String command) {
		StringBuilder formattedCommand = new StringBuilder();
		if (this.battle.id != null) {
			formattedCommand.append(this.battle.id);
		}
		formattedCommand.append("|");
		formattedCommand.append(command);
		client.sendMessage(formattedCommand.toString());
	}
	
	
}
