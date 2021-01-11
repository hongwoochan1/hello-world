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

@Controller  // spring-servlet.xml ��Ʈ���� ��û�� �޴´�.
public class HelloBean {

	//@Autowired // ����Ѱ� ���� 
	//private Dto dto=null;
	
	//@Autowired // ����Ѱ� ���� 
	//private Dto dto2=null;
	
	//@Autowired // ����Ѱ� ���� 
	//private Dto dto3=null;
	
	//@Autowired // ����Ѱ� ���� 
	//private Dto d=null;
	
	//@Autowired // ����Ѱ� ���� 
	//private Dto dto4=null;
	
	//@Autowired // ����Ѱ� ���� 
	//private Date day = null;
	
	//@Autowired // ����Ѱ� ���� 
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
		// .DAO ȣ����� ó���� �Ѵ�.
		// ó���� ����� view�� ������. 
		// Model interface-- model �� ó�� ����� view �����ϱ����� ��ü 
		// java.util.Map���� ���������. 
		// view ���� ${ǥ�����}�� ����Ѵ�. 
		model.addAttribute("name", name);
		model.addAttribute("num", num);
		model.addAttribute("dto", dto);		
		return "1130/pro";
	}
	
	@RequestMapping("/pro2.do")
	public ModelAndView pro2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("1130/pro");  //view ���
		mv.addObject("name", "java");  // ���� ��!! 
		mv.addObject("num", 300);
		return mv;
		//   http://localhost:8080/spring/pro2.do
	}
	
}













