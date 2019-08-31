package DAO;

import Hibernate_Model.HibernateUtil;
import Model.Beans.DatosDeGrupo_Bean;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class O_D_Grupo {

    private Session session;
    private Transaction transaction;

    private void StartOperation() throws HibernateException {
        session = HibernateUtil.getSf().openSession();
        transaction = session.beginTransaction();
    }

    private void MasterOfEX(HibernateException HE) throws HibernateException {
        transaction.rollback();
        throw new HibernateException("Error en al acceder a datos en " + HE);
    }

    public void save(DatosDeGrupo_Bean object) throws HibernateException {
        try {
            StartOperation();
            session.save(object);
            transaction.commit();
        } catch (HibernateException HE) {
            MasterOfEX(HE);
        } finally {
            session.close();
        }
    }

    public void update(DatosDeGrupo_Bean object) throws HibernateException {
        try {
            StartOperation();
            session.update(object);
            transaction.commit();
        } catch (HibernateException HE) {
            MasterOfEX(HE);
            throw HE;
        } finally {
            session.close();
        }
    }

    public void delete(DatosDeGrupo_Bean object) throws HibernateException {
        try {
            StartOperation();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException HE) {
            MasterOfEX(HE);
            throw HE;
        } finally {
            session.close();
        }
    }

    public DatosDeGrupo_Bean getObject(String id_object) throws HibernateException {
        DatosDeGrupo_Bean object = null;
        try {
            StartOperation();
            object = session.get(DatosDeGrupo_Bean.class, id_object);
        } finally {
            session.close();
        }
        return object;
    }

    public List<DatosDeGrupo_Bean> getlist() throws HibernateException {
        List<DatosDeGrupo_Bean> list = null;
        try {
            StartOperation();
            list = session.createQuery("FROM DatosDeGrupo_Bean ").list();
        } finally {
            session.close();
        }
        return list;
    }
}
