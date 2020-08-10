package web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//싱글톤 적용 객체 - DB연결
//	Connection객체를 하나만 만들어서 사용할 수 있게 만든다
public class JDBCTemplate {

	//OJDBC 드라이버
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	//DB연결 정보
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	
	//OJDBC 객체
	private static Connection conn = null; //DB연결객체
	
	//private 생성자 - 외부에서 객체 생성하는 걸 막는 용도
	private JDBCTemplate() { }
	
	//Connection 객체 반환 - 싱글톤 패턴 적용 메소드
	public static Connection getConnection() {
		
		if( conn == null ) { //한번 생성된 객체를 유지하게 만듦
			try {
				//----- 드라이버 로드 -----
				Class.forName(DRIVER);
	
				//----- DB 연결 -----
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return conn; //DB 연결 객체 반환
	}
	
	// commit 수행 메소드
	public static void commit(Connection conn) {
		
		try {
			if(conn!=null && !conn.isClosed()) { // NULL이 아닐때, DB가 끊겨져 있지 않을때
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// rollback 수행 메소드
	public static void rollback(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) { // NULL이 아닐때, DB가 끊겨져 있지 않을때
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// DB연결 해제
	public static void close(Connection conn) {
		try {
			if(conn!=null && conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// SQL 수행객체 해제
	public static void close(PreparedStatement ps) {
		try {
			if(ps!=null && ps.isClosed()) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	// 쿼리결과 객체 해제
	public static void close(ResultSet rs) {
		try {
			if(rs!=null && rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}