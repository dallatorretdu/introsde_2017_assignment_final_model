package introsde.APP3.users.persistence.dao;
import java.util.List;

import introsde.APP3.users.persistence.entities.Review;

public class ReviewPersistencyService {
	private static UsersDAO bookDao;

	public static Review saveReview(Review entity) {
		bookDao = new UsersDAO();
		bookDao.openCurrentSessionwithTransaction();
		Review p = bookDao.persist(entity);
		bookDao.closeCurrentSessionwithTransaction();
		return p;
	}

	public static Review updateReview(Review entity) {
		bookDao = new UsersDAO();
		bookDao.openCurrentSessionwithTransaction();
		Review newEntity = bookDao.merge(entity);
		bookDao.closeCurrentSessionwithTransaction();
		return newEntity;
	}
	
	public static void removeReview(Review p) {
		bookDao = new UsersDAO();
		bookDao.openCurrentSessionwithTransaction();
		bookDao.delete(p);
		bookDao.closeCurrentSessionwithTransaction();
	}
	
	public static Review getReviewById(int id) {
		bookDao = new UsersDAO();
		bookDao.openCurrentSession();
		Review book = (Review) bookDao.getCurrentSession().get(Review.class, id);
		bookDao.closeCurrentSession();
		return book;
	}
	
	public static List<Review> getAllReviews() {
		bookDao = new UsersDAO();
		bookDao.openCurrentSession();
		List<Review> books = (List<Review>) bookDao.getCurrentSession().createQuery("from Review").list();
		bookDao.closeCurrentSession();
		return books;
	}
	
	public static List<Review> getAllReviewsForPark(Integer id) {
		bookDao = new UsersDAO();
		bookDao.openCurrentSession();
		List<Review> books = (List<Review>) bookDao.getCurrentSession().createQuery("from Review where id_park='"+id+"'").list();
		bookDao.closeCurrentSession();
		return books;
	}
	
	public static List<Review> getAllReviewsForShed(Integer id) {
		bookDao = new UsersDAO();
		bookDao.openCurrentSession();
		List<Review> books = (List<Review>) bookDao.getCurrentSession().createQuery("from Review where id_shed='"+id+"'").list();
		bookDao.closeCurrentSession();
		return books;
	}
}