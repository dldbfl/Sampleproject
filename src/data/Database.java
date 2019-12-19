package data;

import java.util.ArrayList;

import vo.UserVo;

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
	
	
	
	public ArrayList<UserVo> tb_user = new ArrayList<>();
	{
		UserVo user = new UserVo();
		user.setId("admin");
		user.setPassword("admin");
		user.setName("관리자");
		tb_user.add(user);
	}
}
