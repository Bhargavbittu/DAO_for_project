package DAO;

import Entities.Address;
import Entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

/**
 * Created by vankayab on 8/3/2017.
 */
public class CustomerDAOImpl implements CustomerDAO {

SessionFactory sessionFactory;
    @Override
    public boolean addCustomer(String regNo, String name, Date bookingDate, long mobileNo, String email, Address address) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        Customer operator = null;
        try {
            tx = session.beginTransaction();
            operator = new Customer(regNo,name,bookingDate,mobileNo,email,address);
            session.save(operator);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }


    @Override
    public boolean SearchCustomer(String VehicleNo) {
return false;
    }
}
