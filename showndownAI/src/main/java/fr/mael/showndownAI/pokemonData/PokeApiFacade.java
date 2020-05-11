package fr.mael.showndownAI.pokemonData;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class PokeApiFacade {

	private final Logger LOGGER = LogManager.getLogger(getClass());

	private static final String BASE_URL = "https://pokeapi.co/api/v2/";
	private static final String MOVE_URL = "move/%s";
	private static final String POKEMON_URL = "pokemon/%s";
	private Gson gson = new Gson();
	private Map<String, Pokemon> knownPokemons;
	private Map<String, Move> knownMoves;

	private PokeApiFacade() {
		knownPokemons = new HashMap<>();
		knownMoves = new HashMap<>();
	}

	/** Holder */
	private static class PokeApiHolder {
		private final static PokeApiFacade instance = new PokeApiFacade();
	}

	/** Access Point */
	public static PokeApiFacade getInstance() {
		return PokeApiHolder.instance;
	}

	public Pokemon getPokemon(String pokemonName) {
		if (!knownPokemons.containsKey(pokemonName)) {
			knownPokemons.put(pokemonName, getFromApi(pokemonName, Pokemon.class));
		}
		return knownPokemons.get(pokemonName);
	}

	public Move getMove(String moveName) {
		if (!knownMoves.containsKey(moveName)) {
			knownMoves.put(moveName, getFromApi(moveName, Move.class));
		}
		return knownMoves.get(moveName);
	}

	private <T> T getFromApi(String name, Class<T> clazz) {
		String strUrl = BASE_URL + (Pokemon.class.equals(clazz) ? POKEMON_URL : MOVE_URL);
		HttpGet get = new HttpGet(String.format(strUrl, name));
		get.addHeader("Content-Type", "application/json");
		try (CloseableHttpClient client = HttpClientBuilder.create().build();) {
			// send the post request
			HttpResponse response = client.execute(get);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String strResponse = EntityUtils.toString(response.getEntity(), "UTF-8");
				return gson.fromJson(strResponse, clazz);
			}
		} catch (IOException | JsonSyntaxException e) {
			LOGGER.error("", e);
		}

		return null;
	}

}
