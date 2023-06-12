package com.javaex.vo;

import java.util.Date;

public class UserVo {
    private int userNo;
    private String id;
    private String userName;
    private String password;
    private Date joinDate;
	
    
    // 생성자, getter 및 setter 메서드 등 필요한 코드를 추가할 수 있습니다.
    public UserVo() {
		super();
	}
    
    public UserVo(int userNo, String id, String userName, String password, Date joinDate) {
		super();
		this.userNo = userNo;
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.joinDate = joinDate;
	}

    //getter 및 setter
	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	//toString()
	@Override
	public String toString() {
		return "UserVo [userNo=" + userNo + ", id=" + id + ", userName=" + userName + ", password=" + password
				+ ", joinDate=" + joinDate + "]";
	}
}
