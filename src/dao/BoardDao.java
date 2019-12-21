package dao;
	//데이터 엑세스 오브젝트의 약자
import java.util.ArrayList;
//import java.util.HashMap;

import vo.BoardVO;

public interface BoardDao {
	
//	BOARDVO SELECTUSER(STRING);

	void insertUser(BoardVO user);

	BoardVO selectUser(ArrayList<String> param);

	ArrayList<BoardVO> selectUserList();
	
	

}
