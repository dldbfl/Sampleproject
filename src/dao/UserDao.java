package dao;
	//데이터 엑세스 오브젝트의 약자
import java.util.ArrayList;
import java.util.HashMap;

import vo.UserVo;

public interface UserDao {
	
	UserVo selectUser(String key, String value);

	void insertUser(UserVo user);

	UserVo selectUser(HashMap<String, String> param);

	ArrayList<UserVo> selectUserList();
	
	

}
