/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Dao.IDao;
import classes.Employe;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author salah
 */
public class EmployeService implements IDao<Employe>{

    @Override
    public void create(Employe o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }
    
    public int createWithIdFeedBack(Employe o){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        
        return o.getId();
    }

    @Override
    public void delete(Employe o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Employe o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Employe> findAll() {
        List<Employe> employes = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        employes = session.createQuery("From Employe").list();
        session.getTransaction().commit();
        session.close();
        return employes;
    }

    @Override
    public Employe findById(int id) {
        Employe r = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        r = (Employe) session.get(Employe.class, id);
        session.getTransaction().commit();
        session.close();
        return r;
    }
    
     public List<Object[]> findAllJoinned() {
        List<Object[]> employes = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        employes = session.createQuery("SELECT e,et From Employe e,EmployeEtablissement et WHERE e.id = et.employe.id ").list();
        session.getTransaction().commit();
        session.close();
        return employes;
    }
     
     public int login(String pass,String fonction) {
        int l = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        l = Integer.parseInt(session.createQuery("Select count(*) From Employe where password=:pass and fonction=:fonction").setParameter("pass", pass).setParameter("fonction", fonction).uniqueResult().toString());
        session.getTransaction().commit();
        session.close();
        return l;
    }
     
     public int countEmploye() {
        int l = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        l = Integer.parseInt(session.createQuery("Select count(*) From Employe ").uniqueResult().toString());
        session.getTransaction().commit();
        session.close();
        return l;
    }
}
