package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import vo.UserVo;
import dao.UserDao;
import dao.UserDaolmpl;
import data.Session;

public class UserServiceImpl implements UserService {
		
	private static UserServiceImpl instance;
	
	private UserServiceImpl(){}
	
	public static UserServiceImpl getInstance() {
		if(instance== null){
			instance = new UserServiceImpl();
		}
		return instance;
	}
	
	UserDao userDao = UserDaolmpl.getInstance();
	
	@Override
	public void join() {
			//회원가입
		Scanner s = new Scanner(System.in);
		
		System.out.println("아이디 : ");
		String id = s.nextLine();
		System.out.println("비밀번호 : ");
		String password = s.nextLine();		
		System.out.println("이름 : ");
		String name = s.nextLine();
		
		UserVo user = new UserVo();
		
		user.setId(id);
		user.setPassword(password);
		user.setName(name);
		
		UserVo userCheck = userDao.selectUser("ID", user.getId());
		
		if(userCheck == null){
			userDao.insertUser(user);
			System.out.println("가입해주셔서 감사합니다.");
		}else{
			System.out.println("아이디 중복");
		}
	}

	@Override
	public void login() {
		//로그인
		Scanner s = new Scanner(System.in);
		
		System.out.println("아이디 : ");
		String id = s.nextLine();
		System.out.println("비밀번호 : ");
		String password = s.nextLine();		
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("ID", id);
		param.put("PASSWORD", password);
		
		UserVo user = userDao.selectUser(param);
		
		if(user == null){
			System.out.println("아이디 혹은 비밀번호를 잘못입력하셨습니다.");
		}else{
			Session.loginUser = user;
			System.out.println("로그인 성공!!");
			System.out.println(user.getName()+"님 환영합니다.");
			
		}
	}

	@Override
	public void userList() {
		ArrayList<UserVo> userList = userDao.selectUserList();
				
		System.out.println("------------------------");
		System.out.println("번호\t아이디\t이름");
		System.out.println("------------------------");
		for(int i = userList.size() - 1; 0 <= i ; i -- ){
			UserVo user = userList.get(i);
			System.out.println(i + 1 + "\t"+user.getId()
					+ "\t" + user.getName());
		}
		System.out.println("------------------------");
		
	}

}
