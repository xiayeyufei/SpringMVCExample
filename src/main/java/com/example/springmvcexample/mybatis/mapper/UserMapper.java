package com.example.springmvcexample.mybatis.mapper;

import com.example.springmvcexample.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface UserMapper {
	public int addUser(User user);
	public User getUserByAccount(String account);
	public int delAllUser();
	public List <User> getAllUser();
	 public List<User> findUsers(@Param("account") String account, @Param("name") String name, @Param("sex") String sex,
			   @Param("startBirthday") LocalDate startBirthday, @Param("endBirthday") LocalDate endBirthday,
			   @Param("minSalary") Double minSalary, @Param("maxSalary") Double maxSalary,
			   @Param("authorities") String[] authorities, @Param("orderBy") String[] orderBy,
			   @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);
	public long getUserCount(@Param("account") String account, @Param("name") String name, @Param("sex") String sex,
							 @Param("startBirthday") LocalDate startBirthday, @Param("endBirthday") LocalDate endBirthday,
							 @Param("minSalary") Double minSalary, @Param("maxSalary") Double maxSalary,
							 @Param("authorities") String[] authorities);

	User getUserById(long id);
	public int chgUser(User user);
	public int delUserById(long id);

}
