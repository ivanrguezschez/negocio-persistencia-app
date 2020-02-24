package com.irs.negociopersistenciaapp.negocio.servicios;

import java.util.Collection;

import com.irs.negociopersistenciaapp.negocio.servicios.exceptions.ServiceException;
import com.irs.negociopersistenciaapp.negocio.vo.PaisVO;

/**
 * Interface de la lógica de negocio empleada para los paises.
 *
 * @author IRS
 * @version 1.0.0
 */
public interface PaisService {

    /**
     * Busca todos los paises.
     *
     * @return La lista de todos los paises.
     * @throws ServiceException Si se produce un error en la busqueda.
     */
    public Collection<PaisVO> findAll() throws ServiceException;

    /**
     * Busca todos los paises.
     *
     * @return La lista de todos los paises ordenados por el nombre de campo
     * indicado.
     * @throws ServiceException Si se produce un error en la busqueda.
     */
    public Collection<PaisVO> findAllSortByField(String fieldName) throws ServiceException;

    /**
     * Busca un pais por identificador.
     *
     * @param idPais identificador del pais a buscar.
     * @return El pais con el identificador especificado.
     * @throws ServiceException Si se produce un error en la busqueda.
     */
    public PaisVO findById(final Integer idPais) throws ServiceException;

    /**
     * Guarda un nuevo pais.
     *
     * @param pais el nuevo pais a guardar.
     * @return El nuevo pais guardado.
     * @throws ServiceException Si se produce un error al guardar el pais.
     */
    public PaisVO save(PaisVO pais) throws ServiceException;

    /**
     * Actualiza un pais.
     *
     * @param pais El pais a actualizar.
     * @throws ServiceException Si se produce un error en la actualizacion del
     * pais.
     */
    public void update(PaisVO pais) throws ServiceException;

    /**
     * Borra un pais (Borrado físico).
     *
     * @param pais pais a borrar.
     * @throws ServiceException Si se produce un error en el borrado del pais.
     */
    public void remove(PaisVO pais) throws ServiceException;

}
