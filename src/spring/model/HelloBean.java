package spring.model;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller  // spring-servlet.xml 컨트롤의 요청을 받는다.
public class HelloBean {

	//@Autowired // 컨드롤과 연결 
	//private Dto dto=null;
	
	//@Autowired // 컨드롤과 연결 
	//private Dto dto2=null;
	
	//@Autowired // 컨드롤과 연결 
	//private Dto dto3=null;
	
	//@Autowired // 컨드롤과 연결 
	//private Dto d=null;
	
	//@Autowired // 컨드롤과 연결 
	//private Dto dto4=null;
	
	//@Autowired // 컨드롤과 연결 
	//private Date day = null;
	
	//@Autowired // 컨드롤과 연결 
	//private Dto dto5=null;

	@RequestMapping("/hello.do")
	public String hello(     ) {
		return "1130/hello";
	}
	
	
	
	@RequestMapping("/pro.do")
	public String test(Dto dto , String name , int num , 
			HttpServletRequest request , 
			HttpSession session , 
			HttpServletResponse response,
			Model model) {
		// .DAO 호출등의 처리를 한다.
		// 처리된 결과를 view로 보낸다. 
		// Model interface-- model 의 처리 결과를 view 전달하기위한 객체 
		// java.util.Map으로 만들어졌다. 
		// view 에서 ${표현언어}로 사용한다. 
		model.addAttribute("name", name);
		model.addAttribute("num", num);
		model.addAttribute("dto", dto);		
		return "1130/pro";
	}
	
	@RequestMapping("/pro2.do")
	public ModelAndView pro2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("1130/pro");  //view 경로
		mv.addObject("name", "java");  // 전달 값!! 
		mv.addObject("num", 300);
		return mv;
		//   http://localhost:8080/spring/pro2.do
	}
	
}













