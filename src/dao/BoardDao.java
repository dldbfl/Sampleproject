package dao;

import java.util.ArrayList;

import vo.BoardVO;





public interface BoardDao {
	
	void insertBoard(BoardVO board);
	
	ArrayList<BoardVO> SelectBoardList();

}
