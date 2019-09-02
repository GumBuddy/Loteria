package Model.DAO;

import Hibernate_Model.HibernateUtil;
import Model.Beans.DatosParticipante_Bean;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class O_D_Participante {


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

    public void save(DatosParticipante_Bean object) throws HibernateException {
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

    public void update(DatosParticipante_Bean object) throws HibernateException {
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

    public void delete(DatosParticipante_Bean object) throws HibernateException {
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

    public DatosParticipante_Bean getObject(String id_object) throws HibernateException {
        DatosParticipante_Bean object = null;
        try {
            StartOperation();
            object = session.get(DatosParticipante_Bean.class, id_object);
        } finally {
            session.close();
        }
        return object;
    }

    public List<DatosParticipante_Bean> getlist() throws HibernateException {
        List<DatosParticipante_Bean> list = null;
        try {
            StartOperation();
            list = session.createQuery("FROM DatosParticipante_Bean ").list();
        } finally {
            session.close();
        }
        return list;
    }

}
