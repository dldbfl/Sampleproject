package dao;

import java.util.ArrayList;

import vo.BoardVO;
import data.Database;


public class BoardDaoImpl implements BoardDao {
	
	private static BoardDaoImpl instance;
	
	private BoardDaoImpl(){}
	
	public static BoardDaoImpl getInstance(){
		if(instance == null){
			instance = new BoardDaoImpl();
		}
		return instance;
	}


	Database database = Database.getInstance();
	
	@Override
	public void insertBoard(BoardVO board) {
		database.tb_board.add(board);
	}

	@Override
	public ArrayList<BoardVO> SelectBoardList() {
		return database.tb_board;
	}

	




}
