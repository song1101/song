package chenglulu.model;

public class User {
	String account;
	String password;
	String nickname;
	String phone;
	public User() {}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account=account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname=nickname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone=phone;
	}
}
