package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import vo.BoardVO;
import data.Database;

public class BoardDaoImpl implements BoardDao {
		//Impl은임플리먼트의 약자
		private static BoardDaoImpl instance;
		
		private BoardDaoImpl(){}
		
		public static BoardDaoImpl getInstance() {
			if(instance== null){
				instance = new BoardDaoImpl();
			}
			return instance;
		}
	
		Database database = Database.getInstance();
		
		
	
		@Override
		public BoardVO selectUser(String key, String value){
			for(int i = 0; i < database.message_board.size();i++){
				BoardVO user = database.message_board.get(i);
				
				if(key.equals("ID")){
					if(user.getId().equals(value)){
						return user;
					}
				}else if(key.equals("NAME")){
					if(user.getName().equals(value)){
						return user;
					}
				}
				
			}
			
			return null;
								
		}

		@Override
		public void insertUser(BoardVO user) {
			database.message_board.add(user);
		}

		@Override
		public BoardVO selectUser(HashMap<String, String> param) {
			
			BoardVO rtnUser = null;
			for(int i = 0 ; i < database.message_board.size();i++){
				BoardVO user = database.message_board.get(i);
				Boolean flag = true;
				Set<String> keys = param.keySet();
				for(String key : keys){
					String value = param.get(key);
					if(key.equals("ID")){
						if(!user.getId().equals(value)) flag = false;
					}else if(key.equals("PASSWORD")){
						if(!user.getPassword().equals(value)) flag = false;
					}
				}
				if(flag) rtnUser = user;
			}
			
			ArrayList<ArrayList<String>> board = new ArrayList<>();
			
			//점수를 입력한다.
//			BoardVO rtnUser = null;			
//			for(int i = 0; i < 2; i++){
//				ArrayList<String> post = new ArrayList<>();
//				Scanner s = new Scanner(System.in);
//				post.add("1"); //글 번호
//				
//				for(int j = 0; j < board.size(); j++){
//					post.add(s.nextLine());
//				}
//				
//				board.add(post);
//			}
			
			
			
			
			
			
			
			
			
			
			return rtnUser;
			
			
			
			
			
		}

		@Override
		public ArrayList<BoardVO> selectUserList() {
			return database.message_board;
		}
}
