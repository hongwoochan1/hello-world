package spring.model;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import spring.model.service.BoardDaoService;
import spring.model.service.BoardDataBean;

@Controller
@RequestMapping("/board/")
public class BoardBean {

   @Autowired
   private BoardDaoService boardDAO = null;
   
   @RequestMapping("list.do")
   public String list(@RequestParam(defaultValue="1") int pageNum , Model model)throws Exception {

        int pageSize = 10;//�� �������� ���� ����
        int currentPage = pageNum;
        int startRow = (currentPage - 1) * pageSize + 1;//�� �������� ���۱� ��ȣ
        int endRow = currentPage * pageSize;//�� �������� ������ �۹�ȣ
        int count = 0;
        int number=0;

        List articleList = null;
        count = boardDAO.getArticleCount();//��ü ���� �� 
        
        if (count > 0) {
            articleList = boardDAO.getArticles(startRow, endRow);//���� �������� �ش��ϴ� �� ���
        } else {
            articleList = Collections.EMPTY_LIST;
        }

      number=count-(currentPage-1)*pageSize;//�۸�Ͽ� ǥ���� �۹�ȣ
        //�ش� �信�� ����� �Ӽ�
        model.addAttribute("currentPage", new Integer(currentPage));
        model.addAttribute("startRow", new Integer(startRow));
        model.addAttribute("endRow", new Integer(endRow));
        model.addAttribute("count", new Integer(count));
        model.addAttribute("pageSize", new Integer(pageSize));
        model.addAttribute("number", new Integer(number));
        model.addAttribute("articleList", articleList);
        
        System.out.println("list run");
      return "board/list";
   }
   
   @RequestMapping("writeForm.do")
   public String writeForm(BoardDataBean dto, Model model) throws Exception{
	   
	   model.addAttribute("dto",dto);
	   System.out.println("writeForm run");
	   return "board/writeForm";
   }
   
   @RequestMapping("writePro.do")
   public String writePro(BoardDataBean dto, HttpServletRequest request) throws Exception{
	   
	   dto.setIp(request.getRemoteAddr());
	   
	   boardDAO.insertArticle(dto);
	   System.out.println("writePro run");
	   return "board/writePro";
   }
   
   @RequestMapping("content.do")
   public String content(int num, int pageNum, Model model) throws Exception{
	  
	   BoardDataBean article =  boardDAO.getArticle(num);

	   model.addAttribute("num", new Integer(num));
	   model.addAttribute("pageNum", new Integer(pageNum));
	   model.addAttribute("article", article);
	   System.out.println("content run");
	   return "board/content";
   }
   
   @RequestMapping("deleteForm.do")
   public String deleteForm(int num, int pageNum, Model model) throws Exception{
	   
       BoardDataBean article =  boardDAO.updateGetArticle(num);

		//�ش� �信�� ����� �Ӽ�
       model.addAttribute("num", new Integer(num));
       model.addAttribute("pageNum", new Integer(pageNum));
       System.out.println("deleteForm run");
	   return "board/deleteForm";
   }
   
   @RequestMapping("deletePro.do")
   public String deletePro(int num, int pageNum, String passwd, Model model) throws Exception{
	    
       int check = boardDAO.deleteArticle(num, passwd);

       //�ش� �信�� ����� �Ӽ�
       model.addAttribute("pageNum", new Integer(pageNum));
       model.addAttribute("check", check); // new Integer : ��ü ���·� ������ ���Ѱ�/�ڵ�� ������ �������� �Է��Ѵ�.
       System.out.println("deletePro run");
	   return "board/deletePro";
   }
   
   @RequestMapping("updateForm.do")
   public String updateForm(int num, int pageNum, Model model) throws Exception{
	   
       BoardDataBean article =  boardDAO.updateGetArticle(num);

		//�ش� �信�� ����� �Ӽ�
       model.addAttribute("pageNum", new Integer(pageNum));
       model.addAttribute("article", article);
       System.out.println("updateForm run");
	   return "board/updateForm";
   }
   
   @RequestMapping("updatePro.do")
   public String updatePro(int pageNum, BoardDataBean dto, Model model) throws Exception{

	    BoardDataBean article = new BoardDataBean();
	    model.addAttribute("dto",dto);
	    
		int check = boardDAO.updateArticle(dto);

		model.addAttribute("pageNum", new Integer(pageNum));
		model.addAttribute("check", new Integer(check));
		System.out.println("updatePro run");
	   return "board/updatePro";
   }
   
}







