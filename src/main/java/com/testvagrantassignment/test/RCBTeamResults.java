package com.testvagrantassignment.test;

import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Sathyaraj on 2023-01-19.
 * This class holds all the test methods, and defines all methods related to printing output to console
 */

public class RCBTeamResults extends JsonHelper {
	JSONArray jsonArray;

	RCBTeamResults() throws ParseException, IOException{
		loadJsonTestSuiteFile();
		String jsonDataString = getTestSuiteJson().toString();
		JSONObject jsonObject = new JSONObject(jsonDataString);
		jsonArray =  (JSONArray) jsonObject.getJSONArray("player");    
	}

	/**
	 * Test 1: Write a test that validates that the team has only 4 foreign players
	 * Parameter: expectedPlayersCount :: which accepts expected count for validation.
	 * Expected Result: Should contains only 4 Foriegn players
	 * @throws Exception 
	 */	

	@Test
	@Parameters("expectedPlayersCount")
	public void GET4ForeignPlayers(int expectedPlayersCount) throws Exception{
		Logger.logOutput(String.format("RCB Team Has Total %s Players", jsonArray.length()));
		int count = printAndGetForignPlayersListCount(jsonArray);
		Assert.assertEquals(count, expectedPlayersCount);
		Logger.logAction(String.format("RCB Team has %s Foriegn Players", count));
	}

	/**
	 * Test 2: Write a test that validates that there is at least one wicket keeper
	 * @throws Exception 
	 */
	@Test
	@Parameters("expectedKeepersCount")
	public void GETWicketKeeper(int expectedKeepersCount) throws Exception {
		Logger.logOutput("Wicket Keeper Information");
		int count = printAndGetWicketKeepersCount(jsonArray);
		Assert.assertEquals(count, expectedKeepersCount);
		Logger.logAction(String.format("RCB Team has %s Wicket-keeper ", count));
	}
}
