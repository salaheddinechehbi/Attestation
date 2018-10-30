/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Dao.IDao;
import classes.EmployeEtablissement;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author salah
 */
public class EmployeEtablissementService implements IDao<EmployeEtablissement>{

    @Override
    public void create(EmployeEtablissement o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(EmployeEtablissement o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(EmployeEtablissement o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<EmployeEtablissement> findAll() {
        List<EmployeEtablissement> employeetablissements = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        employeetablissements = session.createQuery("From EmployeEtablissement").list();
        session.getTransaction().commit();
        session.close();
        return employeetablissements;
    }

    @Override
    public EmployeEtablissement findById(int id) {
        EmployeEtablissement r = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        r = (EmployeEtablissement) session.get(EmployeEtablissement.class, id);
        session.getTransaction().commit();
        session.close();
        return r;
    }
    
      public EmployeEtablissement findbyEmployeId(int id){
        EmployeEtablissement r = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        r = (EmployeEtablissement) session.createQuery("SELECT e FROM EmployeEtablissement e WHERE e.employe.id = ?").setParameter(0, id).uniqueResult();
        session.getTransaction().commit();
        session.close();
        return r;
    }
    
}
