package spring.model.service;

import ch11.Logon.LogonDataBean;

public interface LogonDBService {

	public void insertMember(LogonDataBean member) 
		    throws Exception;
	
	public int userCheck(LogonDataBean member) 
			throws Exception;
	
	public int confirmId(String id) 
			throws Exception;
	
	public LogonDataBean getMember(String id)
		    throws Exception;
	
	public void updateMember(LogonDataBean member)
		    throws Exception;
	
	public int deleteMember(String id)
		    throws Exception;
	
}
