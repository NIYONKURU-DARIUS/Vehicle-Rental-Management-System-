package DAO;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class UserDAO {
    public User getUserByEmail(String email) {
        Session session = HibernateUtil.getSession();
        User user = null;
        try {
            user = (User) session.createQuery("FROM User WHERE email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();
        } finally {
            session.close();
        }
        return user;
    }

    public boolean saveUser(User user){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSession()){
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
            return true;
        }catch(Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            return false;
        }
    }
}
