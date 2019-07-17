package ru.liplib.eLibraries.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.liplib.eLibraries.model.AccountLitres;

import java.util.List;

@Repository
public class LitresDAOImpl implements LitresDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<AccountLitres> allAccsLR() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from AccountLitres").list();
    }

    @Override
    public void addAccLR(AccountLitres accountLitres) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(accountLitres);
    }

    @Override
    public void editAccLR(AccountLitres accountLitres) {
        Session session = sessionFactory.getCurrentSession();
        session.update(accountLitres);
    }

    @Override
    public AccountLitres getAccLRById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(AccountLitres.class, id);
    }
}
