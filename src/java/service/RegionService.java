/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Dao.IDao;
import classes.Region;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author salah
 */
public class RegionService implements IDao<Region>{

    @Override
    public void create(Region o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Region o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Region o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Region> findAll() {
        List<Region> regions = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        regions = session.createQuery("From Region").list();
        session.getTransaction().commit();
        session.close();
        return regions;
    }

    @Override
    public Region findById(int id) {
        Region r = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        r = (Region) session.get(Region.class, id);
        session.getTransaction().commit();
        session.close();
        return r;
    }
    
}
