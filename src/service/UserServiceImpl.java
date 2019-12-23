package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import vo.BoardVO;
import vo.UserVO;
import dao.BoardDao;
import dao.BoardDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import data.Session;

public class UserServiceImpl implements UserService { //클래스 생성할때 interface Add함
	
	private static UserServiceImpl instance; //인스턴스 선언 //싱글톤 //생성된 객체(instance = new UserServiceImpl();)를 instance에 저장
	
	private UserServiceImpl(){} //생성자를 private으로 만들어 객체 생성 못하게 함
	
	public static UserServiceImpl getInstance(){
		if(instance == null){
			instance = new UserServiceImpl();
		}
		return instance; //null이 아니게 되면 객체를 생성하지 않고 instance에 저장되어있었던 값을 반환한다
	}
	
	UserDao userDao = UserDaoImpl.getInstance();
	

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
		
		UserVO user = new UserVO();
		
		user.setId(id);
		user.setPassword(password);
		user.setName(name);
		
		UserVO userCheck = userDao.selectUser("ID", user.getId());
		
		if(userCheck == null){ //아이디 없으면 가입 가능
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
		
		//파라미터를 여러개 들고가야할때 해시맵 사용
		HashMap<String, String> param = new HashMap<String, String>(); //param : 파라미터
		param.put("ID", id);
		param.put("PASSWORD", password);
		
		UserVO user = userDao.selectUser(param);
		
		if(user == null){
			System.out.println("아이디 혹은 비밀번호를 잘못입력하셨습니다.");
		}else{
			Session.LoginUser = user;
			System.out.println("로그인 성공!!");
			System.out.println(user.getName() + "님 환영합니다.");
		}
	}

	@Override
	public void userList() {
		ArrayList<UserVO> userList = userDao.selectUserList();
		
		System.out.println("------------------------------");
		System.out.println("번호\t아이디\t이름");
		System.out.println("------------------------------");
		for(int i = userList.size() -1; 0 <= i; i--){
			UserVO user = userList.get(i);
			System.out.println(i + 1 + "\t" + user.getId() + "\t" + user.getName());
		}
		System.out.println("------------------------------");
	}
	
	@Override
	public void write() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("제목 : ");
		String title = s.nextLine();
		System.out.println("내용 : ");
		String contents = s.nextLine();
		
		BoardVO board = new BoardVO();
		
		board.setTitle(title);
		board.setContents(contents);
		boardDao.insertBoard(board);
		
	}


	BoardDao boardDao = BoardDaoImpl.getInstance();

	@Override
	public void boardList() {

		ArrayList<BoardVO> boardList = boardDao.SelectBoardList();
		
		System.out.println("------------------------------");
		System.out.println("번호\t제목\t내용");
		System.out.println("------------------------------");
		for(int i = boardList.size()-1; 0 < i; i--){
			BoardVO board = boardList.get(i);
			System.out.println(i + "\t" + board.getTitle() + "\t" + board.getContents());
		}
		System.out.println("------------------------------");
	}


}
