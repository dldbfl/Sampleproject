package data;

import java.util.ArrayList;

import vo.BoardVO;
import vo.UserVO;

public class Database {

	private static Database instance;

	private Database() {
	}

	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}
	
	
	
	public ArrayList<UserVO> tb_user = new ArrayList<>();
	{
		UserVO user = new UserVO();
		user.setId("admin");
		user.setPassword("admin");
		user.setName("관리자");
		tb_user.add(user);
	}
	
	public ArrayList<BoardVO> message_board = new ArrayList<>();
	{
		BoardVO user = new BoardVO();
		user.setId("admin");
		user.setPassword("admin");
		user.setName("관리자");
		message_board.add(user);
	}
}
