package DbTests;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.app.domain.dto.MemoDto;
import com.example.app.domain.mapper.MemoMapper;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
class DataSourceTests {

	@Autowired
	private DataSource dataSource1;
	
	@Autowired
	private DataSource dataSource2;
	
	@Autowired
	private DataSource dataSource3;
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Autowired
	private MemoMapper memoMapper;
	
	@Test
	@Disabled
	void test1() throws Exception {
		System.out.println(dataSource2);
		Connection conn = dataSource2.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("insert into book_tbl values('ffff','ffff','ffff','ffff')");
		pstmt.executeUpdate();
	}
	@Test
	@Disabled
	void test2() throws Exception {
		System.out.println(dataSource3);
		Connection conn = dataSource3.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("insert into book_tbl values('abdav','ffff','ffff','ffff')");
		pstmt.executeUpdate();
	}
	@Test
	@Disabled
	void test3() throws Exception {
		assertNotNull(sessionFactory);
		SqlSession sqlSession = sessionFactory.openSession();
		assertNotNull(sqlSession);
		
	}
	@Test
	@Disabled
	void test4() throws Exception {
		//memoMapper.insertXml(new MemoDto(2020, "b", "1@naver.com", LocalDateTime.now(), null));
		MemoDto memoDto = new MemoDto(null, "a", "a@naver.com", LocalDateTime.now(), null);
		memoMapper.insertXml(memoDto);
		System.out.println(memoDto);
//		List<Map<String, Object>> list = memoMapper.selectAllResultMapXml();
//		list.forEach(System.out::println);
		
	}

}
