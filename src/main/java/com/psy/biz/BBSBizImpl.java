package com.psy.biz;

import java.util.List;

import com.psy.dao.BulletinBoardSystemDao;
import com.psy.dao.BulletinBoardSystemDaoImpl;
import com.psy.vo.BulletinBoardSystemVO;

public class BBSBizImpl implements BBSBiz {

	private BulletinBoardSystemDao dao;
	
	public BBSBizImpl() {
		dao = new BulletinBoardSystemDaoImpl();
	}
	
	@Override
	public List<BulletinBoardSystemVO> getAllPosting() {
		return dao.getPostingOf();
	}

	@Override
	public void addPosting(BulletinBoardSystemVO boardSystemVO) {
		dao.addPosting(boardSystemVO);
	}

	@Override
	public boolean updateRecommed(int Id) {
		dao.updateRecommendCount(Id);
		return true;
	}

	@Override
	public BulletinBoardSystemVO getPosting(int Id) {
		dao.updateHitCount(Id);
		return dao.getPostingAt(Id);
	}

	@Override
	public boolean deletPosting(int Id) {
		dao.deletePosting(Id);
		return true;
	}
	@Override
	public List<BulletinBoardSystemVO> searchPosting(String search) {
		
		return dao.searchPosting(search);
	}
}
