package com.irs.negociopersistenciaapp.persistencia.dao;

import java.io.Serializable;
import java.util.Collection;

import com.irs.negociopersistenciaapp.persistencia.dao.exceptions.DaoException;

public interface BaseDao<ENTITY, VO> {

    /**
     * Selecciona todos los registros de le entidad ordenados por defecto por la
     * clave primaria de forma ascendente.
     *
     * @return Una colecci�n de entidades.
     *
     * @throws DaoException Si se produce alg�n error en la selecci�n.
     */
    public Collection<VO> selectAll() throws DaoException;

    /**
     * Selecciona todos los registros de le entidad ordenados por el campo
     * indicado (sortFieldName) y en la forma indicada (si asc true se ordenara
     * ascendentemente, si es false se ordenara descendentemente).
     *
     * @param sortFieldName Nombre del campo por el que se va a ordenar.
     * @param asc Modo de ordenacion asc (true), desc (false).
     *
     * @return Una colecci�n de entidades ordenadas por el campo indicado y en
     * la forma indicada.
     *
     * @throws DaoException Si se produce alg�n error en la selecci�n.
     */
    public Collection<VO> selectAll(String sortFieldName, boolean asc) throws DaoException;

    /**
     * Selecciona una entidad por identificador.
     *
     * @param id Identificador de la entidad a seleccionar.
     *
     * @return La entidad con el identificador indicado.
     *
     * @throws DaoException Si se produce alg�n error en la selecci�n.
     */
    public VO selectById(Serializable id) throws DaoException;

    /**
     * Inserta una entidad.
     *
     * @param vo La entidad a insertar.
     *
     * @return La entidad insertada.
     *
     * @throws DaoException Si se produce alg�n error en la inserci�n.
     */
    public VO insert(VO vo) throws DaoException;

    public Collection<VO> insertCollection(Collection<VO> vos) throws DaoException;

    /**
     * Actualiza una entidad.
     *
     * @param vo La entidad a actualizar.
     *
     * @throws DaoException Si se produce alg�n error en la actualizaci�n.
     */
    public void update(VO vo) throws DaoException;

    /**
     * Elimina una entidad.
     *
     * @param vo La entidad a eliminar.
     *
     * @throws DaoException Si se produce alg�n error en la eliminaci�n.
     */
    public void delete(VO vo) throws DaoException;

    /**
     * Elimina una entidad.
     *
     * @param id Identificador de la entidad a eliminar.
     *
     * @throws DaoException Si se produce alg�n error en la eliminaci�n.
     */
    public void deleteById(Serializable id) throws DaoException;

    /**
     * Elimina una colecci�n de entidades.
     *
     * @param vos La colecci�n de entidades a eliminar.
     *
     * @return El n�mero de entidades eliminadas.
     *
     * @throws DaoException Si se produce alg�n error en la eliminaci�n.
     */
    public int deleteCollection(Collection<VO> vos) throws DaoException;
}
