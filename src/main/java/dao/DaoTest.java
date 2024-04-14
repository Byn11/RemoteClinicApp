package dao;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import entity.HealthInfo;
import service.ProfileUserLogic;

public class DaoTest {

	public static void main(String[] args) throws SQLException {
		//DBUtil test
//		DBUtil db = new DBUtil();
//		Connection con = null;
//		try {
//			con = db.getConnection();
//		}catch(SQLException e) {
//			
//		}
//		finally {
//			db.closeConnection(con);
//		}
		
		//question test
//		QuestionDAO questionDAO = new QuestionDAO();
//		Question question = questionDAO.select(2023);
//		System.out.println(question.getQuestionMessage());
//		Question question2 = new Question(202306,06,"good morning");
//		questionDAO.insert(question2);
		
//		//healthInfo test
//		HealthInfoDAO hDao = new HealthInfoDAO();
//		HealthInfo hel = hDao.select(12345);		
//		System.out.println(hel.getHeight());
//		HealthInfo h2 = new HealthInfo(2468,new Date(),170.1,65.3);
//		System.out.print(hDao.insert(h2));
		
//		//ANSWER test
//		AnswerDAO answerDao = new AnswerDAO();
//		Answer answer = new Answer(5, 456, "no problem");
//		answerDao.insert(answer);
//		System.out.println(answerDao.select(3).getAnswerMessage());
//		
//		//CARDITCARD TEST
//		CreditCardDAO cardDAO = new CreditCardDAO();
//		CreditCard card = new CreditCard(2024, "jack", 2567,new Date());
//		cardDAO.insert(card);
//		System.out.println(cardDAO.select(2022).getExpiration());
		
		//ClinicDAO　test
//		Clinic_IFODao clinicDao = new Clinic_IFODao();
//		List<Clinic> list = clinicDao.sellectAll();
//		for(Clinic cl : list) {
//			System.out.println(cl);
//		}
//		UserDao userDao = new UserDao();
//		User user = new User(5, "email@gg","phone22",1,"emai", new java.sql.Date(new java.util.Date("2023-01-01").getTime()));
//		userDao.update(user);
//		System.out.println(user.getAddress());
		
		
//		HealthInfo info = new HealthInfo(2,new Date(),12,23.4,5,6666);
//		CreditCard card = new CreditCard(2,"ben",1233443, new Date(), 456);
//		CreditCardRegisterLogic creditCardRegisterLogic = new CreditCardRegisterLogic();
//		CreditCardDAO dao2 = new CreditCardDAO();
//		dao2.insert(card);
//		creditCardRegisterLogic.execute(card);
		
//		dao.insert(info);
//		System.out.print(false);
//		dao.update(info);
//		System.out.println(info.getHeight());
//		CreditCardDAO dao = new CreditCardDAO();
//		System.out.println(dao.selectById(1).getCreditCardNumber());
//		System.out.println(dao.selectById(1).getName());
		
//		String dateString = "2023-04-01";
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = null;
//		try {
//			date = formatter.parse(dateString);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//		UserDao userDao = new UserDao();
//		User user = userDao.userFindById(1);
//		user.setAddress("add123");
//		user.setName("name");
//		
//		userDao.update(user);
//		System.out.print(user.getAddress());
		ProfileUserLogic logic = new ProfileUserLogic();
		List<HealthInfo> list = logic.getHealthInfo(1);
		Collections.sort(list);
//		for(HealthInfo inf:list) {
//			System.out.println(inf.getWeight());
//		}
		System.out.println(list);
		

	}
	

}
