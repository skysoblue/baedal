package store;

import java.util.List;

public class StoreServiceImpl implements StoreService{
	private static StoreService instance = new StoreServiceImpl();
	private StoreServiceImpl() {}
	public static StoreService getInstance(){return instance;}
	StoreDAO dao = StoreDAO.getInstance();
	@Override
	public List<StoreVO> getStoresBy(int foodCateSeq) {
		return dao.selectStoresBy(foodCateSeq);
	}

}
