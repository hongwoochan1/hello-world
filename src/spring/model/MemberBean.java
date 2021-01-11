package spring.model;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ch11.Logon.LogonDataBean;
import spring.model.service.LogonDBService;

@Controller
@RequestMapping("/member/")
public class MemberBean {

	@Autowired
	private LogonDBService LogonDAO = null;
	
	@RequestMapping("main.do")
	public String main() {
		
		
		return "member/main";
	}
	
	@RequestMapping("loginPro.do")
	public String loginPro(LogonDataBean dto, Model model, HttpSession session) throws Exception {
		System.out.println("MemberBean loginPro run.");
		int check = LogonDAO.userCheck(dto);
		if(check==1) {
			session.setAttribute("memId",dto.getId());
		}
		model.addAttribute("check", check);
		return "member/loginPro";
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session)throws Exception{
		session.invalidate();
		return "member/logout";
	}
	
	@RequestMapping("modify.do")
	public String modify()throws Exception{
		
		return "member/modify";
	}
	
	@RequestMapping("modifyForm.do")
	public String modifyForm(HttpSession session, Model model)throws Exception{
		String id = (String) session.getAttribute("memId");
		System.out.println("id="+id);
		if(id != null) {
			LogonDataBean dto = LogonDAO.getMember(id);
			System.out.println("dto="+dto);
			model.addAttribute("c", dto);
		}
		return "member/modifyForm";
	} 
	
	@RequestMapping("modifyPro.do")
	public String modifyPro(LogonDataBean dto)throws Exception{
		LogonDAO.updateMember(dto);
		return "member/modifyPro";
	}
	
	@RequestMapping("deleteForm.do")
	public String deleteForm()throws Exception{
		
		return "member/deleteForm";
	}
	
	@RequestMapping("deletePro.do")
	public String deletePro(LogonDataBean dto,HttpSession session, Model model)throws Exception{
		dto.setId((String)session.getAttribute("memId"));
		int check = (int)LogonDAO.userCheck(dto);
		
		System.out.println("check="+check);
		if(check==1) {
			LogonDAO.deleteMember(dto.getId());
			session.invalidate();
		}
		model.addAttribute("check", check);
		return "member/deletePro";
	}
	
	@RequestMapping("inputForm.do")
	public String inputForm()throws Exception{
		
		return "member/inputForm";
	}
	
	@RequestMapping("inputPro.do")
	public String inputPro(LogonDataBean dto)throws Exception{
		LogonDAO.insertMember(dto);
		
		return "member/inputPro";
	}
	
	@RequestMapping("confirmId.do")
	public String confirmId(LogonDataBean dto, Model model)throws Exception{
		int check = LogonDAO.userCheck(dto);
		model.addAttribute("check", check);
		model.addAttribute("id", dto.getId());
		return "member/confirmId";
	}
	
}
