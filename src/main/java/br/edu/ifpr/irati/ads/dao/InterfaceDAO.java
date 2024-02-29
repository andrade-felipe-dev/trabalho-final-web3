package br.edu.ifpr.irati.ads.dao;

import br.edu.ifpr.irati.ads.dao.exception.PersistenceException;

import java.io.Serializable;
import java.util.List;

public interface InterfaceDAO<T> {
    public T findById(Serializable id) throws PersistenceException;

    public void save(T t) throws PersistenceException;

    public void edit(T t) throws PersistenceException;

    public void destroy(T t) throws PersistenceException;

    public List<T> findAll() throws PersistenceException;
}
