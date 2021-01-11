package spring.model.service;

import java.util.List;
import org.springframework.stereotype.Service;

@Service("board") // = <bean id="board">
public class BoardDaoImpl implements DaoService{

	@Override
	public List selectAll() throws Exception {
		
		return null;
	}

	@Override
	public Object selectOne(String id) throws Exception {
		
		return null;
	}

}
