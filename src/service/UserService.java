package service;

public interface UserService { //유저와 관련된 데이터
	
	//추상메서드들
	void join(); //회원가입
	
	void login(); //로그인
	
	void userList(); //회원 전체 목록 출력
	
	void write(); //글쓰기
	
	void boardList(); //글목록

}
