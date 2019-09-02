package Model.DAO;

import Hibernate_Model.HibernateUtil;
import Model.Beans.DatosDeInstitucionales_Bean;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class O_D_Institucionales {

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

    public void save(DatosDeInstitucionales_Bean object) throws HibernateException {
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

    public void update(DatosDeInstitucionales_Bean object) throws HibernateException {
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

    public void delete(DatosDeInstitucionales_Bean object) throws HibernateException {
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

    public DatosDeInstitucionales_Bean getObject(String id_object) throws HibernateException {
        DatosDeInstitucionales_Bean object = null;
        try {
            StartOperation();
            object = session.get(DatosDeInstitucionales_Bean.class, id_object);
        } finally {
            session.close();
        }
        return object;
    }

    public List<DatosDeInstitucionales_Bean> getlist() throws HibernateException {
        List<DatosDeInstitucionales_Bean> list = null;
        try {
            StartOperation();
            list = session.createQuery("FROM DatosDeInstitucionales_Bean ").list();
        } finally {
            session.close();
        }
        return list;
    }
}
