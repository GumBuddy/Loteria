package Model.DAO;

import Hibernate_Model.HibernateUtil;
import Model.Beans.DatosPersonales_Bean;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class O_D_Personales {
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

    public void save(DatosPersonales_Bean object) throws HibernateException {
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

    public void update(DatosPersonales_Bean object) throws HibernateException {
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

    public void delete(DatosPersonales_Bean object) throws HibernateException {
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

    public DatosPersonales_Bean getObject(String id_object) throws HibernateException {
        DatosPersonales_Bean object = null;
        try {
            StartOperation();
            object = session.get(DatosPersonales_Bean.class, id_object);
        } finally {
            session.close();
        }
        return object;
    }

    public List<DatosPersonales_Bean> getlist() throws HibernateException {
        List<DatosPersonales_Bean> list = null;
        try {
            StartOperation();
            list = session.createQuery("FROM DatosPersonales_Bean ").list();
        } finally {
            session.close();
        }
        return list;
    }

}
