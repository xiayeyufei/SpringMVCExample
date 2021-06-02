package com.example.springmvcexample.mybatis.mapper;

import com.example.springmvcexample.mybatis.mapper.UserMapper;
import com.example.springmvcexample.mybatis.entity.User;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class UserMapperTests {
	@Autowired
	private UserMapper usermapper;
	// TRACE、DEBUG、INFO、WARN、ERROR
	private static final Logger logger = LoggerFactory.getLogger(UserMapperTests.class);

	 @Test
	 public void testAddUser() throws Exception {
	  List<String> authorities = Arrays.asList("读", "写", "删除");
	  int count =0;
	  while(count<500) {
	   String account = RandomStringUtils.randomAlphabetic(6).toLowerCase();
	   if(usermapper.getUserByAccount(account)==null) {
	   User user = new User();
	   user.setAccount(account);
	   user.setPassword("{noop}" + account);
	   user.setName(account);
	   user.setSex(RandomUtils.nextBoolean() ? "男" : "女");
	   user.setBirthday(LocalDate.now().minusYears(RandomUtils.nextInt(0, 20))
	     .minusMonths(RandomUtils.nextInt(0, 12)).minusDays(RandomUtils.nextInt(0, 32)));
	   user.setSalary(RandomUtils.nextInt(1000, 30000));
	   if (count == 0)
	    user.setAuthorities(new String[] { "读", "写", "删除" });
	   else
	    user.setAuthorities(ArrayUtils.subarray(authorities.toArray(new String[] {}), RandomUtils.nextInt(0, 3),
	      RandomUtils.nextInt(1, 4)));
	   System.out.println(usermapper.addUser(user));
	   count++;
	   }else {
		   
	   }
	  }
	 }
	 @Test
	 public void testFindUsers() throws Exception {
	  for(User u :usermapper.findUsers("s", null, null, LocalDate.of(2001, 1, 1), null, null, 25000.0,
	    new String[] { "读"}, new String[] { "salary DESC" }, 2, 10)) {
	   logger.debug("{}", u);
	  }
	 }
}
