package br.edu.ifpr.irati.ads.dao;


import java.io.Serializable;
import java.util.List;

import br.edu.ifpr.irati.ads.dao.exception.PersistenceException;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenericDAO<T> implements InterfaceDAO<T>, Serializable {

    private final Class classePersistente;
    private Session session;

    public GenericDAO(Class classePersistente, Session session) {
        this.classePersistente = classePersistente;
        this.session = session;
    }

    @Override
    public T findById(Serializable id) throws PersistenceException {
        T t = null;
        try {
            t = (T) session.find(classePersistente, id);
            return t;
        } catch (HibernateException | NullPointerException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void save(T t) throws PersistenceException {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(t);
            transaction.commit();
        } catch (HibernateException | NullPointerException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void edit(T t) throws PersistenceException {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(t);
            transaction.commit();
        } catch (HibernateException | NullPointerException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void destroy(T t) throws PersistenceException {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.remove(t);
            transaction.commit();
        } catch (HibernateException | NullPointerException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<T> findAll() throws PersistenceException {
        try {
            String hql = "from " + this.classePersistente.getCanonicalName();
            Query query = session.createQuery(hql,this.classePersistente);
            List results = query.getResultList();
            return results;
        } catch (HibernateException | NullPointerException e) {
            throw new PersistenceException(e.getMessage());
        }
    }
}