package DbTests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.app.domain.mapper.MemoMapper;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
class MybatisTests {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private MemoMapper memoMapper;

//	@Test
//	@Disabled
//	void t1() {
//		assertNotNull(sqlSessionFactory);
//		SqlSession sqlSession =  sqlSessionFactory.openSession();
//		assertNotNull(sqlSession);	
//	}
	
//	@Test
//	@Disabled
//	void t2() {
//		memoMapper.insert(new MemoDto(1010,"a","a@naver.com",LocalDateTime.now(),null));
//		memoMapper.update(new MemoDto(1010,"qbqbqbqb","a@naver.com",LocalDateTime.now(),null));
//		memoMapper.delete(1);
//		System.out.println(memoMapper.selectAt(111));
		
//		List<MemoDto> list = memoMapper.selectAll();
//		list.forEach(System.out::println);
		
//		List<Map<String,Object>>list =  memoMapper.selectAllResultMap();	
//		list.forEach(System.out::println);
		
		//memoMapper.insertXml(new MemoDto(2022,"b","b@naver.com",LocalDateTime.now(),null));
		
//		List<Map<String,Object>>list =  memoMapper.selectAllResultMapXml();	
//		list.forEach(System.out::println);
		
//		MemoDto dto = new MemoDto(null,"a111","a111@naver.com",LocalDateTime.now());		
//		memoMapper.insert(dto);
//		System.out.println("RESULT : " + dto);
							
//	}
	
	@Test
	void t3() {
		
		Map<String,Object> param = new HashMap();
		param.put("type","writer");
		param.put("keyword","TEST");
		
//		List< Map<String,Object> > response = memoMapper.Select_if_xml(param);
//		response.forEach(System.out::println);
		
		List< Map<String,Object> > response = memoMapper.Select_when_xml(param);
		response.forEach(System.out::println);
	}
	

}


