package com.member;

import java.sql.Timestamp;

public class MemberDTO { 
	private String memberId;
	private String memberPasswd;
	private String memberName;
	private String memberEmail;
	private String memberTel;
	private Timestamp regDate;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPasswd() {
		return memberPasswd;
	}
	public void setMemberPasswd(String memberPasswd) {
		this.memberPasswd = memberPasswd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberTel() {
		return memberTel;
	}
	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [memberId=" + memberId + ", memberPasswd=" + memberPasswd + ", memberName=" + memberName
				+ ", memberEmail=" + memberEmail + ", memberTel=" + memberTel + ", regDate=" + regDate + "]";
	}
	
}