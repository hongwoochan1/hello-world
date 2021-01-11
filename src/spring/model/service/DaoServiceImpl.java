package spring.model.service;

import java.sql.Connection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Service;

@Service //Bean에 등록하는역할
public class DaoServiceImpl implements DaoService{ // 서비스를 구현하고 있는 클래스는 이름 뒤에 Impl을 붙인다

	private Connection getConnection() throws Exception {
	      Context initCtx = new InitialContext();
	      Context envCtx = (Context) initCtx.lookup("java:comp/env");
	      DataSource ds = (DataSource)envCtx.lookup(DaoService.dbConnect);
	      return ds.getConnection();
	}
	
	@Override
	public List selectAll() throws Exception {
		
		return null;
	}

	@Override
	public Object selectOne(String id) throws Exception {
		
		return null;
	}

}
