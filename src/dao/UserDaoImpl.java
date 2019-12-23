package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import vo.UserVO;
import data.Database;

public class UserDaoImpl implements UserDao { //UserDao를 상속받는 클래스
	
	private static UserDaoImpl instance;
	
	private UserDaoImpl(){}
	
	public static UserDaoImpl getInstance(){
		if(instance == null){
			instance = new UserDaoImpl();
		}
		return instance;
	}

	Database database = Database.getInstance(); //Database 메서드를 database에 담음
	
	@Override
	public UserVO selectUser(String key, String value) { //key 파라미터 : id뿐만 아니라 다른걸로도 유저를 찾을 수 있다
		for(int i = 0; i < database.tb_user.size(); i++){
			UserVO user = database.tb_user.get(i);
			
			if(key.equals("ID")){
				if(user.getId().equals(value)){
					return user;
				}
			}else if(key.equals("NAME")){ //key를 name으로 넘기면 이름으로 검색된다
				if(user.getName().equals(value)){
					return user;
				}
			}
		}
		return null;
	}

	@Override
	public void insertUser(UserVO user) {
		database.tb_user.add(user);
		
	}

	@Override
	public UserVO selectUser(HashMap<String, String> param) { //아이디와 패스워드 둘 다 일치하는 데이터 리턴
		UserVO rtnUser = null;
		for(int i = 0; i < database.tb_user.size(); i++){
			UserVO user = database.tb_user.get(i);
			boolean flag = true;
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
		return rtnUser;
	}

	@Override
	public ArrayList<UserVO> selectUserList() {
		return database.tb_user;
	}

}
