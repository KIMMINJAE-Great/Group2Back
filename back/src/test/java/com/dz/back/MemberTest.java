package com.dz.back;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
	 "file:src/main/webapp/WEB-INF/spring/security-context.xml" })
public class MemberTest {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private DataSource datasource;
	
	@Test
	public void testInsertMember() {
		String sql = "INSERT INTO testsemp(userid, password, username ) VALUES(?,?,?)";
		
		
		for(int i =0; i<100; i++) {
			Connection con =null;
			PreparedStatement ps = null;
			try {
				con = datasource.getConnection();
				ps = con.prepareStatement(sql);
				ps.setString(2, passwordEncoder.encode("pw" + i));
				
				if(i < 80) {
					ps.setString(1, "user" + i);
					ps.setString(3, "일반사용자" + i);
				} else if(i < 90) {
					ps.setString(1, "manager" + i);
					ps.setString(3, "운영자" + i);
				}else {
					ps.setString(1, "admin" + i);
					ps.setString(3, "관리자" + i);
				}
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(ps!= null) try {
					ps.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				if(con!= null) try {
					con.close();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		}
		
		
	}
	@Test
	public void testInsertAuth() {
		String sql = "INSERT INTO testauth(userid, auth ) VALUES(?,?)";
		
		
		for(int i =0; i<100; i++) {
			Connection con =null;
			PreparedStatement ps = null;
			try {
				con = datasource.getConnection();
				ps = con.prepareStatement(sql);
				
				if(i < 80) {
					ps.setString(1, "user" + i);
					ps.setString(2, "ROLE_USER");
				} else if(i < 90) {
					ps.setString(1, "manager" + i);
					ps.setString(2, "ROLSE_MANAGER");
				}else {
					ps.setString(1, "admin" + i);
					ps.setString(2, "ROLE_ADMIN");
				}
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(ps!= null) try {
					ps.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				if(con!= null) try {
					con.close();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		}
		
		
	}
	@Test
	public void testInsertEmp() {
		String sql = "INSERT INTO semp(CO_CD,EMP_CD,EMP_NM,EMP_ID,BIZ_NM,DEPT_CD, password ) VALUES(?,?,?,?,?,?,?)";
		
//		CREATE TABLE semp (
//				CO_CD VARCHAR(4) NOT NULL,
//				EMP_CD VARCHAR(10) NOT NULL,
//				EMP_NM VARCHAR(20) NOT NULL,
//				EMP_ID VARCHAR(20) NOT NULL, PASSWORD VARCHAR(100) NOT NULL,
//				BIZ_NM VARCHAR(10) NOT NULL,
//				DEPT_CD VARCHAR(10) NOT NULL, PRIMARY KEY (CO_CD,EMP_CD) USING BTREE
//			) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;
		
		
		for(int i =0; i<100; i++) {
			Connection con =null;
			PreparedStatement ps = null;
			try {
				con = datasource.getConnection();
				ps = con.prepareStatement(sql);
				ps.setString(2, passwordEncoder.encode("pw" + i));
				int initialNumber = 1;
				
				String formattedId = String.format("%010d", initialNumber + i);
				
				
				if(i < 30) {
					ps.setString(1, "2000"); //2000 더존비즈온
					if(i%2 == 0) {
						ps.setString(2, "2000BB"+i);
					}else {
						ps.setString(2, "2000AA"+i);						
					}
					ps.setString(3, "김민재"+i);
					ps.setString(4, "user"+i);
					ps.setString(5, formattedId);
					
					if(i%2 == 0) {
						ps.setString(6, "2000BB");
					}else {
						ps.setString(6, "2000AA");						
					}
					ps.setString(7,passwordEncoder.encode("pw" + i) );
					
				}
				else if(i < 50) {
					ps.setString(1, "1000"); // 더존
					if(i%2 == 0) {
						ps.setString(2, "1000BB"+i);
					}else {
						ps.setString(2, "1000AA"+i);						
					}
					ps.setString(3, "장우석"+i);
					ps.setString(4, "user"+i);
					ps.setString(5, formattedId);
					
					if(i%2 == 0) {
						ps.setString(6, "1000BB");
					}else {
						ps.setString(6, "1000AA");						
					}
					ps.setString(7,passwordEncoder.encode("pw" + i) );
				}
				else if(i < 70) {
					ps.setString(1, "3000"); // 더존에듀캠
					if(i%2 == 0) {
						ps.setString(2, "3000CC"+i);
					}else {
						ps.setString(2, "3000AA"+i);						
					}
					ps.setString(3, "장우석"+i);
					ps.setString(4, "user"+i);
					ps.setString(5, formattedId);
					
					if(i%2 == 0) {
						ps.setString(6, "3000CC");
					}else {
						ps.setString(6, "3000AA");						
					}
					ps.setString(7,passwordEncoder.encode("pw" + i) );
				}
				else if(i < 80) {
					ps.setString(1, "4000"); // 더존키컴
					if(i%2 == 0) {
						ps.setString(2, "4000BB"+i);
					}else {
						ps.setString(2, "4000AA"+i);						
					}
					ps.setString(3, "이건우"+i);
					ps.setString(4, "user"+i);
					ps.setString(5, formattedId);
					
					if(i%2 == 0) {
						ps.setString(6, "4000BB");
					}else {
						ps.setString(6, "4000AA");						
					}
					ps.setString(7,passwordEncoder.encode("pw" + i) );
				} else if(i < 90) {
					ps.setString(1, "1000"); // 더존
					if(i%2 == 0) {
						ps.setString(2, "1000BB"+i);
					}else {
						ps.setString(2, "1000AA"+i);						
					}
					ps.setString(3, "이경호"+i);
					ps.setString(4, "manager"+i);
					ps.setString(5, formattedId);
					
					if(i%2 == 0) {
						ps.setString(6, "1000BB");
					}else {
						ps.setString(6, "1000AA");						
					}
					ps.setString(7,passwordEncoder.encode("pw" + i) );
				}else {
					ps.setString(1, "1000"); // 더존
					if(i%2 == 0) {
						ps.setString(2, "1000BB"+i);
					}else {
						ps.setString(2, "1000AA"+i);						
					}
					ps.setString(3, "김태성"+i);
					ps.setString(4, "admin"+i);
					ps.setString(5, formattedId);
					
					if(i%2 == 0) {
						ps.setString(6, "1000BB");
					}else {
						ps.setString(6, "1000AA");						
					}
					ps.setString(7,passwordEncoder.encode("pw" + i) );
				}
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(ps!= null) try {
					ps.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				if(con!= null) try {
					con.close();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		}
		
		
	}
	
	@Test
	public void testInsertempAuth() {
		String sql = "INSERT INTO empauth(EMP_ID, AUTH ) VALUES(?,?)";
		
//		CREATE TABLE empauth(
//				  EMP_ID VARCHAR(50),
//				  AUTH VARCHAR(50),
//				  PRIMARY KEY (EMP_ID) USING BTREE
//				) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;
		
		for(int i =0; i<100; i++) {
			Connection con =null;
			PreparedStatement ps = null;
			try {
				con = datasource.getConnection();
				ps = con.prepareStatement(sql);
				
				if(i < 80) {
					ps.setString(1, "user" + i);
					ps.setString(2, "ROLE_USER");
				} else if(i < 90) {
					ps.setString(1, "manager" + i);
					ps.setString(2, "ROLE_MANAGER");
				}else {
					ps.setString(1, "admin" + i);
					ps.setString(2, "ROLE_ADMIN");
				}
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(ps!= null) try {
					ps.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				if(con!= null) try {
					con.close();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		}
		
		
	}
}
