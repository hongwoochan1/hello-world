package spring.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch11.Logon.LogonDataBean;

@Service("LogonDAO")
public class LogonDBServiceMybatis implements LogonDBService{

	@Autowired
	private SqlSessionTemplate dao = null;

	@Override
	public void insertMember(LogonDataBean member) throws Exception {
		dao.insert("member.insertMember",member);
		System.out.println("insert complete.");
	}

	@Override
	public int userCheck(LogonDataBean member) throws Exception {
		return dao.selectOne("member.userCheck", member);
	}

	@Override
	public int confirmId(String id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LogonDataBean getMember(String id) throws Exception {
		return dao.selectOne("member.member", id);
	}

	@Override
	public void updateMember(LogonDataBean member) throws Exception {
		dao.update("member.updateMember", member);
		
	}

	@Override
	public int deleteMember(String id) throws Exception {
		return dao.delete("member.deleteMember",id);
	}

}
