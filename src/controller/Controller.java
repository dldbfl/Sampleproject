package controller;

import java.util.Scanner;

import service.UserService;
import service.UserServiceImpl;

public class Controller {
	
	UserService userService = UserServiceImpl.getInstance(); //userservice 클래스에 있는 추상 메서드들을 사용하기 위해 씀
	
	public static void main(String[] args) {
		/*
		 * Controller : 메뉴 선택 //프로그램이 시작하는 메인메서드 (웹에서 메인화면)
		 * Service : 메뉴 기능 수행 //메인화면의 메뉴 기능을 메서드로 구현(데이터를 가져올 필요가 있으면 Dao클래스에서 메서드 호출)
		 * Dao : 데이터 베이스 접속 //(VO에 저장한)데이터를 가져오거나 넣는 작업
		 * VO : 데이터를 담는 클래스
		 */
		
		new Controller().begin();
	}
	
	private void begin(){
		Scanner s = new Scanner(System.in); //유저에게 어떤 행동을 할건지 물어본다
		
		 int menu;
		 
		 do{ //사용자가 프로그램 종료하고 싶을때까지 반복
			 System.out.println("----------메뉴---------");
			 System.out.println("1. 회원가입");
			 System.out.println("2. 로그인");
			 System.out.println("3. 회원목록");
			 System.out.println("4. 글쓰기");
			 System.out.println("5. 글목록");
			 System.out.println("0. 프로그램 종료");
			 System.out.println("----------------------");
			 System.out.println("메뉴에 해당하는 번호 입력>");
			 
			 menu = Integer.parseInt(s.nextLine());
			 
			 switch (menu){
			 case 1 : //회원가입
				 userService.join();
				 break;
			 case 2 : //로그인
				 userService.login();
				 break;
			 case 3 : //회원목록
				 userService.userList();
				 break;
			 case 4 : //글쓰기
				 userService.write();
				 break;
			 case 5 : //글목록
				 userService.boardList();
				 break;	 
			 case 0 : //프로그램 종료
				 System.out.println("프로그램 종료");
				 break;
			 }
		 }while(menu != 0);

	}

}
