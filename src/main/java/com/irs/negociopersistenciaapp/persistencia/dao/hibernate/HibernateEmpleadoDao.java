package com.irs.negociopersistenciaapp.persistencia.dao.hibernate;

import com.irs.negociopersistenciaapp.dominio.Empleado;
import org.hibernate.SessionFactory;
import com.irs.negociopersistenciaapp.negocio.vo.EmpleadoVO;
import com.irs.negociopersistenciaapp.persistencia.dao.EmpleadoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementacion basada en Hibernate de la interface de la capa de persistencia
 * empleada para los empleados.
 *
 * @author IRS
 * @version 1.0.0
 */
@Repository
public class HibernateEmpleadoDao extends HibernateBaseDao<Empleado, EmpleadoVO> implements EmpleadoDao {

    @Autowired
    public HibernateEmpleadoDao(SessionFactory sessionFactory) {
        super(sessionFactory, Empleado.class, EmpleadoVO.class);
    }
}
