/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Dao.IDao;
import classes.EtudiantEtablissement;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author salah
 */
public class EtudiantEtablissementService implements IDao<EtudiantEtablissement>{

    @Override
    public void create(EtudiantEtablissement o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(EtudiantEtablissement o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(EtudiantEtablissement o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<EtudiantEtablissement> findAll() {
        List<EtudiantEtablissement> etudiantetablissements = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        etudiantetablissements = session.createQuery("From EtudiantEtablissement").list();
        session.getTransaction().commit();
        session.close();
        return etudiantetablissements;
    }

    @Override
    public EtudiantEtablissement findById(int id) {
        EtudiantEtablissement r = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        r = (EtudiantEtablissement) session.get(EtudiantEtablissement.class, id);
        session.getTransaction().commit();
        session.close();
        return r;
    }
    
}
