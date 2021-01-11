package spring.model.service;

import java.sql.Connection;
import java.util.List;

public interface BoardDaoService {

	/* ex)
	 * DB 연결 정보 정의
	 * tomcat서버 context.xml 커넥션 셋팅 정보 활용
	 * oracle / mysql 선택
	 * DB서버 url 프로젝트 메뉴얼 참조
	 * DB서버 매주 금요일 (23시_01시) 점검					*/
	public Connection getConnection() throws Exception;
	
	/* 데이터 저장
	 * num, writer, subject, content 필수 
	 * num / writer 유효성검사 코드 작성 
	 * writer = 현재 로그인된 ID와 같아야한다.								*/
	public void insertArticle(BoardDataBean article) throws Exception;
	
	// 게시판 내용정보 개수를 받아온다.
	public int getArticleCount() throws Exception;
	
	// 원하는 표시 개수에 맞게 게시판의 정보 리스트를 받아온다.
	public List getArticles(int start, int end) throws Exception;
	
	// 
	public BoardDataBean getArticle(int num) throws Exception;
	
	//
	public BoardDataBean updateGetArticle(int num) throws Exception;
	
	// 등록
	public int updateArticle(BoardDataBean article) throws Exception;
	
	// 삭제
	public int deleteArticle(int num, String passwd) throws Exception;
	
}
