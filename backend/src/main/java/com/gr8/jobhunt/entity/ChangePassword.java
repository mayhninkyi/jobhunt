package com.gr8.jobhunt.entity;

public class ChangePassword {
	String current_pwd;
	String new_pwd;
	String con_new_pwd;	
	int ori_id;
	public String getCurrent_pwd() {
		return current_pwd;
	}
	public void setCurrent_pwd(String current_pwd) {
		this.current_pwd = current_pwd;
	}
	public String getNew_pwd() {
		return new_pwd;
	}
	public void setNew_pwd(String new_pwd) {
		this.new_pwd = new_pwd;
	}
	public String getCon_new_pwd() {
		return con_new_pwd;
	}
	public void setCon_new_pwd(String con_new_pwd) {
		this.con_new_pwd = con_new_pwd;
	}
	public int getOri_id() {
		return ori_id;
	}
	public void setOri_id(int ori_id) {
		this.ori_id = ori_id;
	}
	@Override
	public String toString() {
		return "ChangePassword [current_pwd=" + current_pwd + ", new_pwd=" + new_pwd + ", con_new_pwd=" + con_new_pwd
				+ ", ori_id=" + ori_id + "]";
	}
	
	

}
