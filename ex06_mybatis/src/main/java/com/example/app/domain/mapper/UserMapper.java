package com.example.app.domain.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.app.domain.dto.UserDto;

@Mapper
public interface UserMapper {
	@Insert(value = "insert into tbl_user values(#{userid},#{password},#{username},#{addr1})")
	public int insert(UserDto userDto);
	
	@Update(value = "update tbl_user set password = #{password}, username = #{username}, addr1= #{addr1} where userid = #{userid}")
	public int update(UserDto userDto);
	
	@Delete(value = "delete from tbl_user where userid = #{userid}")
	public int delete(String userid);
	
	@Select(value = "select * from tbl_user where userid = #{userid}")
	public UserDto selectAt(String userid);
	
	@Select(value = "select * from tbl_user")
	public List<UserDto> selectAll();
	
	public List<Map<String, Object>> selectAllResultMapXml();
}
