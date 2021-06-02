package com.example.springmvcexample.contrller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.Locale;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.example.springmvcexample.mybatis.entity.Employee;
import com.example.springmvcexample.mybatis.entity.User;
import com.example.springmvcexample.mybatis.mapper.EmployeeMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/example")
public class ExampleController_01 {
	private static final Logger logger = LoggerFactory.getLogger(ExampleController_01.class);

	@Autowired
	private MessageSource messageSource;
	@Autowired
	ServletContext servletContext;
	@Autowired
	private EmployeeMapper employeeMapper;

	@RequestMapping(path = "/test03RequestResponse", method = { RequestMethod.GET, RequestMethod.POST })
	public void test03RequestResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StringBuffer sb = new StringBuffer();
		response.addCookie(new Cookie("name","tom"));
		response.addCookie(new Cookie("age","90"));
		sb.append("\r\nHTTP 请求头:\r\n");
		for (String header : Collections.list(request.getHeaderNames())) {
			sb.append(header + " = " + String.join(",", Collections.list(request.getHeaders(header))) + "\r\n");
		}
		sb.append("\r\nHTTP 请求参数:\r\n");
		for (Entry<String, String[]> param : request.getParameterMap().entrySet()) {
			sb.append(param.getKey() + " = " + String.join(",", param.getValue()) + "\r\n");
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		PrintWriter pw = response.getWriter();
		pw.append(sb.toString());
	}

	@RequestMapping(path = "/test06RequestParam", method = { RequestMethod.GET, RequestMethod.POST })
	public void test06RequestParam(@RequestParam(name = "name", defaultValue = "Tom") String name,
			@RequestParam(defaultValue = "28") int age, @RequestParam(defaultValue = "男") String sex,
			@RequestParam("hobbies") String[] hobbies, HttpServletResponse response) throws IOException {
		StringBuffer sb = new StringBuffer();
		sb.append("\r\nHTTP 请求参数:\r\n");
		sb.append("name = " + name + "\r\n");
		sb.append("sex = " + sex + "\r\n");
		sb.append("age = " + age + "\r\n");
		sb.append("hobbies = " + String.join(",", hobbies) + "\r\n");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		PrintWriter pw = response.getWriter();
		pw.append(sb.toString());
	}

	@GetMapping(path = "/test07PathAndMatrixVariable/{id}")
	public void test07PathAndMatrixVariable(@PathVariable String id, @MatrixVariable String name,
			@MatrixVariable String sex, @MatrixVariable int age, @MatrixVariable(required = false) String[] hobbies,
			HttpServletResponse response) throws IOException {
		StringBuffer sb = new StringBuffer();
		sb.append("\r\n路径片段变量与矩阵变量:\r\n");
		sb.append("id = " + id + "\r\n");
		sb.append("name = " + name + "\r\n");
		sb.append("sex = " + sex + "\r\n");
		sb.append("age = " + age + "\r\n");
		if (hobbies != null) {
			sb.append("hobbies = " + String.join(",", hobbies) + "\r\n");
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		PrintWriter pw = response.getWriter();
		pw.append(sb.toString());
	}

	@GetMapping("/test08RequestHeader")
	public void test08RequestHeader(@RequestHeader("User-Agent") String userAgent,
			@RequestHeader("Accept") String accept, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		PrintWriter pw = response.getWriter();
		pw.append("Accept" + " : " + accept + "\r\n");
		pw.append("User-Agent" + " : " + userAgent + "\r\n");
	}

	@GetMapping("/test09CookieValue")
	public void test09CookieValue(@CookieValue(name = "JSESSIONID", required = false) String jsessionid,
			HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		PrintWriter pw = response.getWriter();
		if (jsessionid != null) {
			pw.append(jsessionid);
		}
	}

	@GetMapping("/test10RequestAttribute01")
	public String test10RequestAttribute01(HttpServletRequest request) {
		request.setAttribute("name", "Tom");
		request.setAttribute("age", 28);
		return "forward:test10RequestAttribute02";
	}

	@GetMapping("/test10RequestAttribute02")
	public void test10RequestAttribute02(@RequestAttribute String name, @RequestAttribute int age,
			HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		PrintWriter pw = response.getWriter();
		pw.append("name" + " : " + name + "\r\n");
		pw.append("age" + " : " + age + "\r\n");
	}

	@GetMapping("/test11RedirectAttributes01")
	public String testRequestAttribute(RedirectAttributes redirectAttributes) throws IOException {
		redirectAttributes.addAttribute("name", "Tom");
		redirectAttributes.addAttribute("age", new Integer(28));
		redirectAttributes.addFlashAttribute("employee", employeeMapper.getEmployee(165));
		return "redirect:test11RedirectAttributes02";
	}

	@GetMapping("/test11RedirectAttributes02")
	public void testCookieValue(@RequestParam("name") String name, @RequestParam("age") int age,
			@ModelAttribute("employee") Employee employee, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		PrintWriter pw = response.getWriter();
		pw.append("name" + " : " + name + "\r\n");
		pw.append("age" + " : " + age + "\r\n");
		pw.append("employee" + " : " + employee + "\r\n");
	}

	@GetMapping("/test12HttpSession")
	public void test12HttpSession(HttpSession httpSession, HttpServletResponse response) throws IOException {
		httpSession.setAttribute("name", "Tom");
		httpSession.setAttribute("age", 28);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		PrintWriter pw = response.getWriter();
		pw.append("成功");
	}

	@GetMapping("/test12SessionAttribute")
	public void test12SessionAttribute(@SessionAttribute String name, @SessionAttribute int age,
			HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		PrintWriter pw = response.getWriter();
		pw.append("name" + " : " + name + "\r\n");
		pw.append("age" + " : " + age + "\r\n");

	}

	@GetMapping(value = "/test14RequestBodyResponseBody", consumes = "application/json; charset=utf-8", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Employee test14RequestBodyResponseBody(@RequestBody Employee employee) {
		employee.setFirstName("唐纳德");
		employee.setLastName("特朗普");
		return employee;
	}

	@GetMapping(value = "/test15HttpEntity", consumes = "application/json; charset=utf-8", produces = "application/json; charset=utf-8")
	public ResponseEntity<Employee> test15HttpEntity(RequestEntity<Employee> request) {
		HttpHeaders requestHttpHeaders = request.getHeaders();
		System.out.println(requestHttpHeaders.get("Request-Custom-Header01"));
		Employee employee = request.getBody();
		employee.setFirstName("唐纳德");
		employee.setLastName("特朗普");
		HttpHeaders responseHttpHeaders = new HttpHeaders();
		responseHttpHeaders.add("Response-Custom-Header01", "---999---");
		ResponseEntity<Employee> responseEntity = new ResponseEntity<Employee>(employee, responseHttpHeaders,
				HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping(value = "/test16Multipart", produces = "text/plain; charset=utf-8")
	public ResponseEntity<String> test16Multipart(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) throws IOException {
		String fileName = new File(file.getOriginalFilename()).getName();
		String distFileName = new File(servletContext.getRealPath("/"), fileName).getCanonicalPath();
		Files.copy(file.getInputStream(), Paths.get(distFileName), StandardCopyOption.REPLACE_EXISTING);
		StringBuffer sb = new StringBuffer();
		sb.append("文件:" + distFileName + "\r\n");
		sb.append("大小:" + file.getSize() + "\r\n");
		HttpHeaders responseHttpHeaders = new HttpHeaders();
		responseHttpHeaders.setContentType(new MediaType(MediaType.TEXT_PLAIN, Charset.forName("utf-8")));
		return new ResponseEntity<String>(sb.toString(), responseHttpHeaders, HttpStatus.OK);
	}

	@GetMapping(value = "/test17Download", produces = "application/octet-stream")
	public ResponseEntity<byte[]> test17Download() throws IOException {
		File file = new File("./hrdata/hr-exam.xls");
		HttpHeaders responseHttpHeaders = new HttpHeaders();
		responseHttpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		responseHttpHeaders.setContentDispositionFormData("attachment", file.getName());
		return new ResponseEntity<byte[]>(Files.readAllBytes(file.toPath()), responseHttpHeaders, HttpStatus.OK);
	}

	@RequestMapping(path = "/test18Validation")
	public ResponseEntity<String> test18Validation(@Valid User user, BindingResult bindingResult, Locale locale)
			throws IOException {
		if (!StringUtils.equals(user.getPassword(), user.getConfirmPassword())) {
			bindingResult.rejectValue("confirmPassword", "NotCoincident", "确认密码与密码不一致");
		}
		if (bindingResult.hasFieldErrors()) {
			for (FieldError fe : bindingResult.getFieldErrors()) {
				logger.debug("{} = {}", fe.getField(), messageSource.getMessage(fe, locale));
			}
		}
		if (bindingResult.hasGlobalErrors()) {
			for (ObjectError oe : bindingResult.getGlobalErrors()) {
				logger.debug("{}", messageSource.getMessage(oe, locale));
			}
		}
		HttpHeaders responseHttpHeaders = new HttpHeaders();
		responseHttpHeaders.setContentType(new MediaType(MediaType.APPLICATION_JSON, Charset.forName("utf-8")));
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return new ResponseEntity<String>(gson.toJson(bindingResult), responseHttpHeaders, HttpStatus.OK);
	}
}
