package data;

import java.util.ArrayList;

import vo.BoardVO;
import vo.UserVO;

public class Database {

private static Database instance; //싱글톤
	
	private Database(){}
	
	public static Database getInstance(){
		if(instance == null){
			instance = new Database();
		}
		return instance;
	}
	
	
	//UserVO를 ArrayList에 담는다
	public ArrayList<UserVO> tb_user = new ArrayList<>(); //유저테이블(유저의 정보를 담는 곳)
	
	{ //기본 데이터를 넣어둔다
		UserVO user = new UserVO();
		user.setId("admin");
		user.setPassword("admin");
		user.setName("관리자");
		tb_user.add(user);
		
	}
	
	public ArrayList<BoardVO> tb_board = new ArrayList<>();
	
	{
		BoardVO board = new BoardVO();
		tb_board.add(board);
	}
	
	
	
	
	
	
}
