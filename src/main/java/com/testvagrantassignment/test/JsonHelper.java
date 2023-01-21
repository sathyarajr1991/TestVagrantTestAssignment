package com.testvagrantassignment.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

/**
 * Created by Sathyaraj on 2023-01-19.
 * This class is responsible for reading JSON file and parsing it to get necessary data
 */
public class JsonHelper {

	private static JSONObject testSuiteJson;
	private static String TEST_SUITE_FILENAME = "/test_suite.json";


	public static JSONObject getTestSuiteJsonObject() {
		return getTestSuiteJson();
	}

	public static String getTestSuiteFilename() {
		return TEST_SUITE_FILENAME;
	}

	public static JSONObject getTestSuiteJson() {
		return testSuiteJson;
	}

	public static void setTestSuiteJson(JSONObject testSuiteJson) {
		JsonHelper.testSuiteJson = testSuiteJson;
	}

	/**
	 * Read the test suite json file, and sets the json object representing test suite file
	 * @return json list
	 * @throws IOException 
	 * @throws Exception
	 */
	public static void loadJsonTestSuiteFile() throws ParseException, IOException {
		String inputStr;
		JSONParser parser = new JSONParser();
		InputStream stream = JsonHelper.class.getResourceAsStream(TEST_SUITE_FILENAME);
		if (stream == null) {
			throw new NullPointerException(String.format("Test suite json file not found: %s", TEST_SUITE_FILENAME));
		}
		BufferedReader streamReader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
		StringBuilder strBuilder = new StringBuilder();

		while ((inputStr = streamReader.readLine()) != null) {
			if (inputStr.trim().startsWith("//")) {
				// Skip lines that were comments within the test config JSON file
				continue;
			}
			strBuilder.append(inputStr.trim());
		}
		setTestSuiteJson((JSONObject) parser.parse(strBuilder.toString().trim()));
	}

	/**
	 * Accepts all players list and prints only forign players list and returns foriegn players count
	 * @param JSONArray accepts players list
	 * @return total numbers of foriegn players count
	 * @throws Exception
	 */
	public static int printAndGetForignPlayersListCount(JSONArray jsonArray) throws Exception {
		int count=0; 
		for (int i = 0; i < jsonArray.length(); i++) {
			String country = jsonArray.getJSONObject(i).getString("country");
			if(!country.equalsIgnoreCase("India")){
				String name = jsonArray.getJSONObject(i).getString("name");
				Logger.logComment(name);
				count++;
			}
		}
		return count;
	}

	/**
	 * Accepts all players list and prints only forign players list and returns foriegn players count
	 * @param JSONArray accepts players list
	 * @return total numbers of foriegn players count
	 * @throws Exception
	 */
	public static int printAndGetWicketKeepersCount(JSONArray jsonArray) throws Exception {
		int count=0; 
		for (int i = 0; i < jsonArray.length(); i++) {
			String role = jsonArray.getJSONObject(i).getString("role");
			if(role.equalsIgnoreCase("Wicket-keeper")){
				Assert.assertEquals("Wicket-keeper",role);
				Logger.logComment(jsonArray.getJSONObject(i).getString("name"));
				Logger.logComment(jsonArray.getJSONObject(i).getString("role"));
				Logger.logComment(jsonArray.getJSONObject(i).getString("country"));
				Logger.logComment(jsonArray.getJSONObject(i).getString("price-in-crores"));
				count++;
			}
		}
		return count;
	} 
}
