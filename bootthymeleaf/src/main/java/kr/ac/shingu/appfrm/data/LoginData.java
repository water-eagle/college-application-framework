package kr.ac.shingu.appfrm.data;

public class LoginData {
	private String userId;
	private String userPwd;

	public LoginData() {
	}

	public LoginData(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Override
	public String toString() {
		return "LoginData [userId=" + userId + ", userPwd=" + userPwd + "]";
	}
}
