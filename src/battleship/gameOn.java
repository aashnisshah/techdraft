package battleship;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import org.json.JSONException;
import org.json.JSONObject;

public class gameOn {
	
	JSONObject board;
	String url = "https://student.people.co/api/challenge/battleship/56d54b92e1fa/boards";

	public void setBoard(JSONObject board) {
		this.board = board;
	}
	
	public void gameTime() throws Exception{
		while(isFinished() == false){
			String nextShot = getRandomChar() + getRandomPos();
			String shotURL = url + board.getString("board_id") + nextShot;
			JSONObject updatedBoard = sendGet(shotURL, 1);
			setBoard(updatedBoard);
		}
	}
	
	public int getRandomPos(){
		Random rand = new Random();
		int randInt = rand.nextInt(10);
		return randInt;
	}
	
	public String getRandomChar(){
		Random rand = new Random();
		int randInt = rand.nextInt();
		String alpha = "ABCDEFGHIJ";
		String randChar = "" + alpha.charAt(randInt);
		return randChar;
	}
	
	public boolean isFinished() throws JSONException{
		boolean status = (Boolean) board.get("is_finished");
//		if(status.equalsIgnoreCase("true")){
//			return true;
//		} else {
//			return false;
//		}
		return status;
	}
	
	public JSONObject sendGet(String urlString, int req) throws Exception {
//		String urlString = "https://student.people.co/api/challenge/battleship/56d54b92e1fa/boards";
		URL obj = new URL(urlString);
		
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		 
		// optional default is GET
		con.setRequestMethod("GET");
 
		int responseCode = con.getResponseCode();
//		System.out.println("\nSending 'GET' request to URL : " + obj);
//		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
//		System.out.println(response.toString());
		String jsonFriendlyOutput = response.toString();
		if(req == 0){
			jsonFriendlyOutput = jsonFriendlyOutput.substring(2, jsonFriendlyOutput.length()-2);
		}
		JSONObject json = new JSONObject(jsonFriendlyOutput);
		return json;
	}
}
