package com.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.common.JDBCTemplate.*;

public class MemberDAO {
	/***********************************************************
	 * login() 메서드: 로그인 처리
	 * @param (MemberDTO dto)
	 * @return MemberDTO 자료형 리턴.
	 ***********************************************************/
	public MemberDTO login(MemberDTO dto){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDTO memberDTO = null; // 인스턴스의 값이 null 그대로 이면 일치하는 정보가 존재하지 않는다는 의미.
		try{
			con = getConnection();
			StringBuffer query = new StringBuffer();
			query.append("select m_id, m_name, m_email from t_member ");
			query.append("where m_id = ? and m_passwd = ?");
			
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, dto.getMemberId());
			pstmt.setString(2, dto.getMemberPasswd());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				memberDTO = new MemberDTO(); // 일치하는 레코드가 존재한다면 인스턴스를 생성하여 데이터 설정.
				memberDTO.setMemberId(rs.getString("m_id"));
				memberDTO.setMemberName(rs.getString("m_name"));
				memberDTO.setMemberEmail(rs.getString("m_email"));
			}

		}catch(Exception e){ 
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
			close(con);
		}
		return memberDTO;
	}
}