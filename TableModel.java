package application;

public class TableModel {
	String id;
	String pw;
	String phone;
	
	public TableModel(String id, String pw, String phone) {
		this.id = id;
		this.pw = pw;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
