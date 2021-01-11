package spring.model.service;

import java.sql.Connection;
import java.util.List;

public interface BoardDaoService {

	/* ex)
	 * DB ���� ���� ����
	 * tomcat���� context.xml Ŀ�ؼ� ���� ���� Ȱ��
	 * oracle / mysql ����
	 * DB���� url ������Ʈ �޴��� ����
	 * DB���� ���� �ݿ��� (23��_01��) ����					*/
	public Connection getConnection() throws Exception;
	
	/* ������ ����
	 * num, writer, subject, content �ʼ� 
	 * num / writer ��ȿ���˻� �ڵ� �ۼ� 
	 * writer = ���� �α��ε� ID�� ���ƾ��Ѵ�.								*/
	public void insertArticle(BoardDataBean article) throws Exception;
	
	// �Խ��� �������� ������ �޾ƿ´�.
	public int getArticleCount() throws Exception;
	
	// ���ϴ� ǥ�� ������ �°� �Խ����� ���� ����Ʈ�� �޾ƿ´�.
	public List getArticles(int start, int end) throws Exception;
	
	// 
	public BoardDataBean getArticle(int num) throws Exception;
	
	//
	public BoardDataBean updateGetArticle(int num) throws Exception;
	
	// ���
	public int updateArticle(BoardDataBean article) throws Exception;
	
	// ����
	public int deleteArticle(int num, String passwd) throws Exception;
	
}
