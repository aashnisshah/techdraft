package battleship;

import org.json.JSONObject;

public class Board {
	
	JSONObject board;
	String url = "https://student.people.co/api/challenge/battleship/56d54b92e1fa/boards";
	
	private void setBoard(JSONObject board) {
		this.board = board;
	}
	
	public static void main(String[] args) throws Exception{
		Board http = new Board();
		
//		System.out.println("Test 1");
//		String board = http.sendGet("https://student.people.co/api/challenge/battleship/56d54b92e1fa/boards");
//		System.out.println("board: " + board);
//		JSONObject boards = new JSONObject(board);
//		
//		System.out.println("board specific output: " + boards.getString("board_id"));
//		
//		String singleBoard = http.sendGet("https://student.people.co/api/challenge/battleship/56d54b92e1fa/boards/test_board_1");
//		System.out.println("single board: " + singleBoard);
//		
//		String shot = http.sendGet("https://student.people.co/api/challenge/battleship/56d54b92e1fa/boards/test_board_1/A1");
//		System.out.println("shot: " + shot);
		
//		System.out.println("Getting board");
//		JSONObject boards = http.sendGet("https://student.people.co/api/challenge/battleship/56d54b92e1fa/boards", 0);
//		JSONObject board = http.sendGet("https://student.people.co/api/challenge/battleship/56d54b92e1fa/boards/test_board_1", 1);
////		System.out.println("board id: " + boards.getString("board_id"));
////		System.out.println("board setup: " + board.getString("board_id"));
//		setBoard(board);
//		gameOn();
		
		gameOn game = new gameOn();
		JSONObject board = game.sendGet("https://student.people.co/api/challenge/battleship/56d54b92e1fa/boards", 0);
		game.setBoard(board);
		game.gameTime();
	}
	
	
	
	

}
