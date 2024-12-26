package com.subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.common.JDBCTemplate.*;

public class SubjectDAO {
	public ArrayList<SubjectVO> getSubjectTotal(){
	    SubjectVO svo  = null;
	    ArrayList<SubjectVO> list = new ArrayList<SubjectVO>();
	    
	    StringBuffer sql = new StringBuffer();
	    sql.append("select no, s_num, s_name from subject");
	    sql.append(" order by no");
	    
	    try(Connection conn = getConnection();
	    	PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
	    	ResultSet rs = pstmt.executeQuery();){
	
	        //ResultSet의 결과에서 모든 행을 각각의 SubjectVO 객체에 저장
	        while(rs.next()) {
	            //한 행의 학과 정보를 저장할 VO 객체 생성
	            svo = new SubjectVO();
	            //한 행의 학과 정보를 VO 객체에  저장
	            svo.setNo(rs.getInt("no"));
	            svo.setSubjectNumber(rs.getString("s_num"));  
	            svo.setSubjectName(rs.getString("s_name"));
	
	            // ArrayList 객체에 원소로 추가
	            list.add(svo);
	        }
	    }catch(SQLException se) {
	        System.out.println("조회에 문제가 있어 잠시 후에 다시 진행해 주세요.");
	        se.printStackTrace();
	    }catch (Exception e){
	        System.err.println("error = [ "+e.getMessage()+" ]");
	    }
	    return list;
	}
	public ArrayList<SubjectVO> getSubjectTotal(SubjectVO vo){
	    SubjectVO svo  = null;
	    ArrayList<SubjectVO> list = new ArrayList<SubjectVO>();
	    
	    StringBuffer sql = new StringBuffer();
	    sql.append("select no, s_num, s_name from subject");
	    if(vo != null) {
	    	sql.append(" where s_name like ?");
	    }
	    sql.append(" order by no");
	    
	    try(Connection conn = getConnection();
	    	PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
	    		){
	    	
	    	if(vo != null) {
	    		pstmt.setString(1,  "%" + vo.getSubjectName() + "%");
	    	}
	    	ResultSet rs = pstmt.executeQuery();
	        //ResultSet의 결과에서 모든 행을 각각의 SubjectVO 객체에 저장
	        while(rs.next()) {
	            //한 행의 학과 정보를 저장할 VO 객체 생성
	            svo = new SubjectVO();
	            //한 행의 학과 정보를 VO 객체에  저장
	            svo.setNo(rs.getInt("no"));
	            svo.setSubjectNumber(rs.getString("s_num"));  
	            svo.setSubjectName(rs.getString("s_name"));
	
	            // ArrayList 객체에 원소로 추가
	            list.add(svo);
	        }
	    }catch(SQLException se) {
	        System.out.println("조회에 문제가 있어 잠시 후에 다시 진행해 주세요.");
	        se.printStackTrace();
	    }catch (Exception e){
	        System.err.println("error = [ "+e.getMessage()+" ]");
	    }
	    return list;
	}
	
    public String getSubjectNumber() {        
        String subjectNumber = "";
        
        StringBuffer  sql    = new StringBuffer();
        //sql.append("select nvl(lpad(max(to_number(LTRIM(s_num,'0')))+1,2,'0'),'01') ");
        //sql.append("as subjectNum from subject");

        sql.append("SELECT nvl(to_char(max(s_num)+1,'FM00'), '01') ");
        sql.append("as subjectNum from subject");

        try (Connection conn = getConnection();
        	 PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        	 ResultSet rs = pstmt.executeQuery(); 	
        	) { 

            if (rs.next()) {
                subjectNumber = rs.getString("subjectNum");
            }
            
        } catch (SQLException se) {
            System.err.println("쿼리 getSubjectNum error = [ "+se.getMessage()+" ]");
            se.printStackTrace();
        } catch (Exception e) {
            System.out.println("error = [ "+e+" ]");
        } 
        return subjectNumber;
    }
    public boolean subjectInsert(SubjectVO svo) {
        boolean success = false;
        
        StringBuffer sql = new StringBuffer();
        sql.append("insert into subject(no, s_num, s_name) ");
        sql.append("values(subject_seq.nextval, ?, ?)");

        try ( Connection conn = getConnection();
        	  PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        	) {
      
            pstmt.setString(1, svo.getSubjectNumber()); // 첫번째 ?(바인딩변수) 설정값 - 학과번호
            pstmt.setString(2, svo.getSubjectName());   // 두번째 ?(바인딩변수) 설정값 - 학과명

            int i = pstmt.executeUpdate(); // 쿼리문 실행 - 결과값은 입력된 행의 수 반환.
            if(i == 1) {
                success = true;
              //commit(conn);
            }
        }catch(SQLException se) {
            System.out.println("입력에 문제가 있어 잠시 후에 다시 진행해 주세요.");
            //rollback(conn);
			//se.printStackTrace();/* 오류 발생 시 확인 */
        }catch (Exception e){
            System.err.println("error = [ "+e.getMessage()+" ]");
            //rollback(conn);
        }  
        
        return success;
    }
    public boolean subjectUpdate(SubjectVO svo) {
        boolean success = false;

        StringBuffer sql = new StringBuffer();
        sql.append("update subject set s_name = ? ");
        sql.append("where s_num = ?");

        try (Connection conn = getConnection();
        	 PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        	){
 
            pstmt.setString(1, svo.getSubjectName());
            pstmt.setString(2, svo.getSubjectNumber());

            int i = pstmt.executeUpdate();
            if(i == 1) {
                success = true;
            }
        }catch(SQLException se) {
            System.out.println("수정에 문제가 있어 잠시 후에 다시 진행해 주세요.");
          //se.printStackTrace(); 오류 발생 시 확인
        }catch (Exception e){
            System.out.println("error = [ "+e+" ]");
        } 
        return success;
    }
    
    public boolean subjectDelete(SubjectVO svo) {
        boolean success = false;

        StringBuffer sql = new StringBuffer();
        sql.append("delete from subject where s_num = ?");
        
        try(Connection conn = getConnection();
        	PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        	) {

            pstmt.setString(1, svo.getSubjectNumber());

            int i = pstmt.executeUpdate();
            if(i == 1) {
                success = true;
            }
        }catch(SQLException se) {
            System.out.println("삭제에 문제가 있어 잠시 후에 다시 진행해 주세요.");
            se.printStackTrace();
        }catch (Exception e){
            System.out.println("error = [ "+e+" ]");
        } 
        return success;
    }
    public int studentDataCheck(SubjectVO svo) {
        StringBuffer  sql    = new StringBuffer();
        sql.append("select count(sd_num) from student ");
        sql.append("where s_num = ?");

        ResultSet rs = null;
        int data = 0;
        try (Connection con = getConnection();
        	 PreparedStatement pstmt = con.prepareStatement(sql.toString());
        	){

            pstmt.setString(1, svo.getSubjectNumber());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                data = rs.getInt(1);
            }
        } catch (SQLException se) {
        	System.out.println("학과에 소속된 학생 조회 시 문제가 있어 잠시 후에 다시 진행해 주세요.");
        	//se.printStackTrace(); 오류 발생 시 확인
        } catch (Exception e) {
            System.out.println("error = [ "+e+" ]");
        } finally {
           close(rs);
        }
        return data;
    }
}