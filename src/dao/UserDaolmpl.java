package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.jws.soap.SOAPBinding.Use;

import vo.UserVo;
import data.Database;

public class UserDaolmpl implements UserDao {
		//Impl은임플리먼트의 약자
		private static UserDaolmpl instance;
		
		private UserDaolmpl(){}
		
		public static UserDaolmpl getInstance() {
			if(instance== null){
				instance = new UserDaolmpl();
			}
			return instance;
		}
	
		Database database = Database.getInstance();
		
		@Override
		public UserVo selectUser(String key, String value){
			for(int i = 0; i < database.tb_user.size();i++){
				UserVo user = database.tb_user.get(i);
				
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
		public void insertUser(UserVo user) {
			database.tb_user.add(user);
		}

		@Override
		public UserVo selectUser(HashMap<String, String> param) {
			UserVo rtnUser = null;
			for(int i = 0 ; i < database.tb_user.size();i++){
				UserVo user = database.tb_user.get(i);
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
			return rtnUser;
		}

		@Override
		public ArrayList<UserVo> selectUserList() {
			return database.tb_user;
		}
}
