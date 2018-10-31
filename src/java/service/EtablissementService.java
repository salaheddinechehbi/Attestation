/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Dao.IDao;
import classes.Etablissement;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author salah
 */
public class EtablissementService implements IDao<Etablissement>{

    @Override
    public void create(Etablissement o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Etablissement o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Etablissement o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Etablissement> findAll() {
        List<Etablissement> etablissements = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        etablissements = session.createQuery("From Etablissement").list();
        session.getTransaction().commit();
        session.close();
        return etablissements;
    }

    @Override
    public Etablissement findById(int id) {
        Etablissement e = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        e = (Etablissement) session.get(Etablissement.class, id);
        session.getTransaction().commit();
        session.close();
        return e;
    }
    
     public List<Object[]> findEtabReg() {
        List<Object[]> etablissements = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        etablissements = session.createQuery("Select e,r From Etablissement e,Region r where e.region.id=r.id").list();
        session.getTransaction().commit();
        session.close();
        return etablissements;
    }
     
     public int countEtablissement() {
        int l = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        l = Integer.parseInt(session.createQuery("Select count(*) From Etablissement").uniqueResult().toString());
        session.getTransaction().commit();
        session.close();
        return l;
    }
    
}
