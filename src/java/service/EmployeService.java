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
     
    public int login(String email) {
        int l = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        l = Integer.parseInt(session.createQuery("Select count(*) From Employe where email=:email").setParameter("email", email).uniqueResult().toString());
        session.getTransaction().commit();
        session.close();
        return l;
    }
    
    public String getFonction(String email) {
        String l = "";
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        l = session.createQuery("Select fonction From Employe where email=:email").setParameter("email", email).uniqueResult().toString();
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
    
    public Employe findByEmail(String email) {
        Employe l = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        l = (Employe) session.createQuery("From Employe where email=:email").setParameter("email", email).uniqueResult();
        session.getTransaction().commit();
        session.close();
        return l;
    }
}
