package com.irs.negociopersistenciaapp.persistencia.dao.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.hibernate.SessionFactory;
import com.irs.negociopersistenciaapp.persistencia.dao.BaseDao;
import com.irs.negociopersistenciaapp.persistencia.dao.exceptions.DaoException;
import com.irs.negociopersistenciaapp.persistencia.util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

@SuppressWarnings("unchecked")
public abstract class HibernateBaseDao<ENTITY, VO> extends HibernateDaoSupport
        implements BaseDao<ENTITY, VO> {

    private static final Logger LOG = LoggerFactory.getLogger(HibernateBaseDao.class);

    private Class<ENTITY> entityClass;

    private Class<VO> voClass;

    @Autowired
    protected DozerBeanMapper mapperPersistencia;

    @Autowired
    public HibernateBaseDao(SessionFactory sessionFactory,
            Class<ENTITY> entityClass, Class<VO> voClass) {
        super.setSessionFactory(sessionFactory);
        this.entityClass = entityClass;
        this.voClass = voClass;
    }

    /**
     * Selecciona todos los registros de le entidad ordenados por defecto por la
     * clave primaria de forma ascendente.
     *
     * @return Una colecci�n de entidades.
     *
     * @throws DaoException Si se produce alg�n error en la selecci�n.
     */
    public Collection<VO> selectAll() throws DaoException {
        try {
            LOG.debug("Seleccionando todos");
            return toVo(getHibernateTemplate().find(
                    HibernateUtil.buildSelectAllQuery(entityClass)));
        } catch (Exception e) {
            throw new DaoException(entityClass, "error buscando todas las entidades", e);
        }
    }

    /**
     * Selecciona todos los registros de le entidad ordenados por el campo
     * indicado (sortFieldName) y en la forma indicada (si asc true se ordenara
     * ascendentemente, si es false se ordenara descendentemente).
     *
     * @param sortFieldName Nombre del campo por el que se va a ordenar.
     * @param asc Modo de ordenacion asc (true), desc (false).
     *
     * @return Una colección de entidades ordenadas por el campo indicado y en
     * la forma indicada.
     *
     * @throws DaoException Si se produce algún error en la selección.
     */
    public Collection<VO> selectAll(String sortFieldName, boolean asc) throws DaoException {
        try {
            LOG.debug("Seleccionando todos ordenados por el campo '{}'", sortFieldName);
            return toVo(getHibernateTemplate().find(
                    HibernateUtil.buildSelectAllSortQuery(entityClass, sortFieldName, asc)));
        } catch (Exception e) {
            throw new DaoException(entityClass, "error buscando todas las entidades ordenadas", e);
        }
    }

    /**
     * Selecciona una entidad por identificador.
     *
     * @param id Identificador de la entidad a seleccionar.
     *
     * @return La entidad con el identificador indicado.
     *
     * @throws DaoException Si se produce algún error en la selección.
     */
    public VO selectById(Serializable id) throws DaoException {
        if (id == null) {
            throw new DaoException(entityClass, "identificador nulo");
        }

        try {
            LOG.debug("Seleccionando por id '{}'", id);
            ENTITY entity = getHibernateTemplate().get(entityClass, id);
            getHibernateTemplate().clear();

            return toVo(entity);
        } catch (Exception e) {
            throw new DaoException(entityClass, "error buscando por identificador (" + id + ")", e);
        }
    }

    /**
     * Inserta una entidad.
     *
     * @param vo La entidad a insertar.
     *
     * @return La entidad insertada.
     *
     * @throws DaoException Si se produce algún error en la inserción.
     */
    public VO insert(VO vo) throws DaoException {
        if (vo == null) {
            throw new DaoException(entityClass, "nula");
        }

        try {
            LOG.debug("Insertando '{}'", vo);
            ENTITY entity = toEntity(vo);
            getHibernateTemplate().save(entity);

            return toVo(entity);
        } catch (Exception e) {
            throw new DaoException(entityClass, "error insertando", e);
        }
    }

    public Collection<VO> insertCollection(Collection<VO> vos) throws DaoException {
        if (vos == null) {
            throw new DaoException(entityClass, "coleccion nula");
        }

        Collection<VO> result = new ArrayList<VO>();
        for (VO vo : vos) {
            result.add(insert(vo));
        }

        return result;
    }

    /**
     * Actualiza una entidad.
     *
     * @param vo La entidad a actualizar.
     *
     * @throws DaoException Si se produce algún error en la actualización.
     */
    public void update(VO vo) throws DaoException {
        if (vo == null) {
            throw new DaoException(entityClass, "nula");
        }

        try {
            LOG.debug("Actualizando '{}'", vo);
            ENTITY entity = toEntity(vo);
            getHibernateTemplate().update(entity);
            getHibernateTemplate().flush();
        } catch (Exception e) {
            throw new DaoException(entityClass, "error actualizando", e);
        }
    }

    /**
     * Elimina una entidad.
     *
     * @param vo La entidad a eliminar.
     *
     * @throws DaoException Si se produce algún error en la eliminación.
     */
    public void delete(VO vo) throws DaoException {
        if (vo == null) {
            throw new DaoException(entityClass, "nula");
        }

        try {
            LOG.debug("Eliminando '{}'", vo);
            ENTITY entity = toEntity(vo);
            getHibernateTemplate().delete(entity);
            getHibernateTemplate().flush();
        } catch (Exception e) {
            throw new DaoException(entityClass, "error eliminando", e);
        }
    }

    /**
     * Elimina una entidad.
     *
     * @param id Identificador de la entidad a eliminar.
     *
     * @throws DaoException Si se produce alg�n error en la eliminaci�n.
     */
    public void deleteById(Serializable id) throws DaoException {
        if (id == null) {
            throw new DaoException(entityClass, "identificador nulo");
        }
        delete(selectById(id));
    }

    public int deleteCollection(Collection<VO> vos) throws DaoException {
        if (vos == null) {
            throw new DaoException(entityClass, "coleccion nula");
        }
        for (VO vo : vos) {
            delete(vo);
        }

        return vos.size();
    }

    protected VO toVo(ENTITY entity) {
        if (entity != null) {
            return (VO) mapperPersistencia.map(entity, voClass);
        }

        return null;
    }

    protected List<VO> toVo(List<ENTITY> entities) {
        List<VO> vos = null;

        if (entities != null) {
            vos = new ArrayList<VO>();
            for (ENTITY entity : entities) {
                vos.add(toVo(entity));
            }
        }

        return vos;
    }

    protected ENTITY toEntity(VO vo) {
        if (vo != null) {
            return (ENTITY) mapperPersistencia.map(vo, entityClass);
        }

        return null;
    }

    protected List<ENTITY> toEntity(List<VO> vos) {
        List<ENTITY> entities = null;

        if (vos != null) {
            entities = new ArrayList<ENTITY>();
            for (VO vo : vos) {
                entities.add(toEntity(vo));
            }
        }

        return entities;
    }
}
