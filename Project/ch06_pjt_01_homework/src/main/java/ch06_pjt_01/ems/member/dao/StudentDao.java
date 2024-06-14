package ch06_pjt_01.ems.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ch06_pjt_01.ems.member.Student;


public class StudentDao {
	// Mariadb 연결
	@Autowired
	JdbcTemplate jdbcTemplate;

	//기본 생성자
	public StudentDao() {
		System.out.println("StudentDao 기본 생성자 호출됨");
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:db.xml");
		jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
		
	}
	
	//학생 정보 삽입
    public void insert(Student student) {
//        String sql = "INSERT INTO students (sNum, sId, sPw, sName, sAge, sGender, sMajor) VALUES (?, ?, ?, ?, ?, ?, ?)";
//        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, student.getsNum());
//            pstmt.setString(2, student.getsId());
//            pstmt.setString(3, student.getsPw());
//            pstmt.setString(4, student.getsName());
//            pstmt.setInt(5, student.getsAge());
//            pstmt.setString(6, String.valueOf(student.getsGender())); // char 타입을 String으로 변환
//            pstmt.setString(7, student.getsMajor());
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    //학생 정보 검색
    public Student select(String sNum) {
//        String sql = "SELECT * FROM students WHERE sNum = ?";
//        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, sNum);
//            try (ResultSet rs = pstmt.executeQuery()) {
//                if (rs.next()) {
//                    Student student = new Student();
//                    student.setsNum(rs.getString("sNum"));
//                    student.setsId(rs.getString("sId"));
//                    student.setsPw(rs.getString("sPw"));
//                    student.setsName(rs.getString("sName"));
//                    student.setsAge(rs.getInt("sAge"));
//                    student.setsGender(rs.getString("sGender").charAt(0)); // String을 char로 변환
//                    student.setsMajor(rs.getString("sMajor"));
//                    return student;
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return null;
    }
    
    public List<Student> selectAll() {   
        List<Student> result = jdbcTemplate.query("SELECT * FROM student", new RowMapper<Student>() {
           @Override
           public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
              Student student = new Student(
                 rs.getString("sNum"),
                 rs.getString("sId"),
                 rs.getString("sPw"),
                 rs.getString("sName"),
                 rs.getInt("sAge"),
                 rs.getString("sGender"),
                 rs.getString("sMajor")
              );
              
              return student;
           }
        });
        
        return result;
     }
}
