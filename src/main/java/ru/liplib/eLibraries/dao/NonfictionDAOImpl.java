package ru.liplib.eLibraries.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.liplib.eLibraries.model.AccountNonFiction;

import java.util.List;

@Repository
public class NonfictionDAOImpl implements NonfictionDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<AccountNonFiction> allAccsNF() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from AccountNonFiction").list();
    }

    @Override
    public void addAccNF(AccountNonFiction accountNonFiction) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(accountNonFiction);
    }

    @Override
    public void editAccNF(AccountNonFiction accountNonFiction) {
        Session session = sessionFactory.getCurrentSession();
        session.update(accountNonFiction);
    }

    @Override
    public AccountNonFiction getAccNFById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(AccountNonFiction.class, id);
    }
}
