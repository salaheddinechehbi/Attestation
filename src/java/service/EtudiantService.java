/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Dao.IDao;
import classes.Etudiant;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author salah
 */
public class EtudiantService implements IDao<Etudiant>{

    @Override
    public void create(Etudiant o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Etudiant o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Etudiant o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Etudiant> findAll() {
        List<Etudiant> etudiants = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        etudiants = session.createQuery("From Etudiant").list();
        session.getTransaction().commit();
        session.close();
        return etudiants;
    }

    @Override
    public Etudiant findById(int id) {
        Etudiant r = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        r = (Etudiant) session.get(Etudiant.class, id);
        session.getTransaction().commit();
        session.close();
        return r;
    }
    
    public int countEtudiant() {
        int l = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        l = Integer.parseInt(session.createQuery("Select count(*) From Etudiant").uniqueResult().toString());
        session.getTransaction().commit();
        session.close();
        return l;
    }
    
}
