package ch04_pjt_01.ems.member;

public class DBConnectionInfo {
	//데이터베이스 정보를 넣을 곳
	private String url; //서버 주소
	private String userId; //유저 아이디
	private String userPw; //유저 패스워드
	
	//DBConnectionInfo의 기본 생성자
	public DBConnectionInfo() { }
	
	//마우스 우클릭 Source로도 Getters and Setters 만들 수 있음
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	
}
