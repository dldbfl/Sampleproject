package dao;

import java.util.ArrayList;
import java.util.HashMap;

import vo.UserVO;

public interface UserDao {
	
	UserVO selectUser(String key, String value); //id 중복 체크

	void insertUser(UserVO user);

	UserVO selectUser(HashMap<String, String> param);

	ArrayList<UserVO> selectUserList();
	
	

}
