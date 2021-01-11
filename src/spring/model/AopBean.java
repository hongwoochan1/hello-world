package spring.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aop/")
public class AopBean {

	@RequestMapping("main.do")
	public String main() {
		System.out.println("aop main.do run.");
		return "1214_aop/main";
	}
	
	@RequestMapping("home.do")
	public String home() {
		System.out.println("aop home.do run.");
		return "1214_aop/home";
	}
	
}
