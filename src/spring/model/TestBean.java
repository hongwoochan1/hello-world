package spring.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.model.service.TestService;

@Controller
@RequestMapping("/test/")
public class TestBean {
	
	@Autowired
	private TestService testDAO = null;
	
	@RequestMapping("main.do")
	public String main(FileDTO dto, Model model) throws Exception{
		
		model.addAttribute("testDAO", testDAO.select(dto));
		
		return "1210_DynamicSQL/main";
	}
	
	@RequestMapping("update.do")
	public String update(FileDTO dto)throws Exception{
		testDAO.update(dto);
		System.out.println("update complete");
		return "1210_DynamicSQL/main";
	}
	
	@RequestMapping("select.do")
	public String selectFor(Model model)throws Exception{
		List list = new ArrayList();
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(13);
		
		list = testDAO.select(list);
		model.addAttribute("list", list);
		
		return "1210_DynamicSQL/select";
	}
	
	
}




