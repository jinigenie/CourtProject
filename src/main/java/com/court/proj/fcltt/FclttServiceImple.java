package com.court.proj.fcltt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fclttService")
public class FclttServiceImple implements FclttService {
	
	@Autowired
	private FclttMapper fclttMapper;
	
	@Override
	public int fclttRegist(FclttVO vo) {
		return fclttMapper.fclttRegist(vo);
	}

}
