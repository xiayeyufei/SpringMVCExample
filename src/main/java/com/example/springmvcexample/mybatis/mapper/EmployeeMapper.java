package com.example.springmvcexample.mybatis.mapper;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.example.springmvcexample.mybatis.entity.Employee;
import com.example.springmvcexample.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface EmployeeMapper {
	public Employee getEmployee(Integer id);

	public List<Employee> getEmployees(Integer departmentId);

	public List<Employee> getAllEmployees();

	public int addEmployee(Employee employee);

	public int chgEmployee(Employee employee);

	public int delEmployee(Integer id);

	public List<Employee> findEmployees(@Param("first_name") String firstname,@Param("last_name") String lastname,@Param("email") String email,
										@Param("phone_number") String phoneNumber,@Param("starthire_date") LocalDate starthire_date, @Param("endhire_date") LocalDate endhire_date,
										@Param("job") String job,@Param("minSalary") Double minSalary, @Param("maxSalary") Double maxSalary,@Param("commission_pct") Double commission_pct,
										@Param("manager_id") Integer manager_id,@Param("department_name") String department_name,
										@Param("orderBy")String[] orderBy, @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);
	public long getEmployeeCount(@Param("first_name") String firstname,@Param("last_name") String lastname,@Param("email") String email,
								 @Param("phone_number") String phoneNumber,@Param("starthire_date") LocalDate starthire_date, @Param("endhire_date") LocalDate endhire_date,
								 @Param("job") String job,@Param("minSalary") Double minSalary, @Param("maxSalary") Double maxSalary,@Param("commission_pct") Double commission_pct,
								 @Param("manager_id") Integer manager_id,@Param("department_name") String department_name);
}
//	public List<User> findUsers(@Param("account") String account, @Param("name") String name, @Param("sex") String sex,
//								@Param("startBirthday") LocalDate startBirthday, @Param("endBirthday") LocalDate endBirthday,
//								@Param("minSalary") Double minSalary, @Param("maxSalary") Double maxSalary,
//								@Param("authorities") String[] authorities, @Param("orderBy") String[] orderBy,
//								@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);
//	public long getUserCount(@Param("account") String account, @Param("name") String name, @Param("sex") String sex,
//							 @Param("startBirthday") LocalDate startBirthday, @Param("endBirthday") LocalDate endBirthday,
//							 @Param("minSalary") Double minSalary, @Param("maxSalary") Double maxSalary,
//							 @Param("authorities") String[] authorities);

