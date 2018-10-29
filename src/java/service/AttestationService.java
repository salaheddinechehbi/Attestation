/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Dao.IDao;
import classes.Attestation;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author salah
 */
public class AttestationService implements IDao<Attestation>{

    @Override
    public void create(Attestation o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Attestation o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Attestation o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Attestation> findAll() {
        List<Attestation> attestations = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        attestations = session.createQuery("From Attestation").list();
        session.getTransaction().commit();
        session.close();
        return attestations;
    }

    @Override
    public Attestation findById(int id) {
        Attestation r = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        r = (Attestation) session.get(Attestation.class, id);
        session.getTransaction().commit();
        session.close();
        return r;
    }
    
}
