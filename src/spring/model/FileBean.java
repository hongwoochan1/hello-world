package spring.model;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import spring.model.service.FileService;

@Controller
@RequestMapping("/file/") //FileServiceMybatis
public class FileBean {

	@Autowired
	private FileService fileServiceImpl = null;
	
	@Autowired
	private FileService fileDAO = null;
	
	@RequestMapping("form.do")
	public String form() {
		
		return "1207/form";
	}
	
	@RequestMapping("upload.do")
	public String upload(MultipartHttpServletRequest request, FileDTO dto) throws Exception{
		
		MultipartFile mf = request.getFile("save"); // 원본파일 객체
		String fileName = mf.getOriginalFilename(); // 파일명	
		dto.setOrgname(fileName);
		int num = fileServiceImpl.fileInsert(dto);
		// insert 진행

		// 파일명에서 확장자 찾기 - 마지막에 발견된 위치(숫자로 n번째)// 파일명에서 마지막 위치찾기 
		String ext = fileName.substring(fileName.lastIndexOf(".")); 
		System.out.println("확장자 : "+ext);
		String saveName = "file_"+num+ext;
		
		//DB saveName update / 글번호와 저장이름을 DTO 대입
		dto.setNum(num);
		dto.setSavename(saveName);
		
		fileServiceImpl.fileUpdate(dto); // sql Update 진행.
		
		//String savePath = "C:\\Users\\hong\\Desktop\\"; // 업로드파일 저장경로
		String savePath = request.getRealPath("save");
		File saveFile = new File(savePath+"\\"+saveName); // 저장위치 객체
		try {
			mf.transferTo(saveFile); // 파일저장 완료.
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/file/list.do";
	}
	
	@RequestMapping("list.do")
	public String list(Model model)throws Exception{
		
		model.addAttribute("list",fileServiceImpl.selectAll());
		
		return "1207/list";		
	}
	
	@RequestMapping("down.do")
	public ModelAndView down(HttpServletRequest request, String file) {
		String path = request.getRealPath("save")+"//"+file;
		File f = new File(path);
		ModelAndView mv = new ModelAndView("download","downloadFile",f);
		
		return mv;
	}	
	
	@RequestMapping("fileNum.do")
	public String fileNum(int num, Model model, FileDTO dto) throws Exception {
		String id = fileDAO.selectId(num);
		model.addAttribute("id",id);
		
		List list = fileDAO.selectId("qwe");
		model.addAttribute("list",list);
		
		String orgname = fileDAO.selectFile(dto);
		model.addAttribute("orgname",orgname);
		
		model.addAttribute("n",fileDAO.selectCount());
		
		return "1209_mybatis/fileNum";
	}
	
	@RequestMapping("main.do")
	public String main() throws Exception{
		
		
		return "1210_DynamicSQL/main";
	}
	
	
	
	
	
}//FileBean

// 파일이름과 확장자 구분
// ex) test.java.png 
// 




