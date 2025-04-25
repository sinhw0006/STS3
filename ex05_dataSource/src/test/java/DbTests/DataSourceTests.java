package DbTests;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
class DataSourceTests {

	@Autowired
	private DataSource dataSource1;
	
	@Autowired
	private DataSource dataSource2;
	
	@Autowired
	private DataSource dataSource3;
	
	@Test
	void test1() throws Exception {
		System.out.println(dataSource2);
		Connection conn = dataSource2.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("insert into book_tbl values('ffff','ffff','ffff','ffff')");
		pstmt.executeUpdate();
	}
	@Test
	void test2() throws Exception {
		System.out.println(dataSource3);
		Connection conn = dataSource3.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("insert into book_tbl values('abdav','ffff','ffff','ffff')");
		pstmt.executeUpdate();
	}

}
