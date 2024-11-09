package com.auca.library.dao;

import com.auca.library.models.Membership;
import com.auca.library.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MembershipDAO {

    public void addMembership(Membership membership) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(membership);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Membership> getAllMemberships() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Membership", Membership.class).list();
        }
    }
}
