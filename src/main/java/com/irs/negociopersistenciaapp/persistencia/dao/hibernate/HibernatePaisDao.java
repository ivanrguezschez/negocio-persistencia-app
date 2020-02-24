package com.irs.negociopersistenciaapp.persistencia.dao.hibernate;

import org.hibernate.SessionFactory;
import com.irs.negociopersistenciaapp.dominio.Pais;
import com.irs.negociopersistenciaapp.negocio.vo.PaisVO;
import com.irs.negociopersistenciaapp.persistencia.dao.PaisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementacion basada en Hibernate de la interface de la capa de persistencia
 * empleada para los paises.
 *
 * @author IRS
 * @version 1.0.0
 */
@Repository
public class HibernatePaisDao extends HibernateBaseDao<Pais, PaisVO> implements PaisDao {

    @Autowired
    public HibernatePaisDao(SessionFactory sessionFactory) {
        super(sessionFactory, Pais.class, PaisVO.class);
    }
}
