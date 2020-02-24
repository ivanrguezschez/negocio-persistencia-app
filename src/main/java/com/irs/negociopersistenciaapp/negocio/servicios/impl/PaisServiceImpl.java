package com.irs.negociopersistenciaapp.negocio.servicios.impl;

import java.util.Collection;

import com.irs.negociopersistenciaapp.negocio.servicios.PaisService;
import com.irs.negociopersistenciaapp.negocio.servicios.exceptions.ServiceException;
import com.irs.negociopersistenciaapp.negocio.vo.PaisVO;
import com.irs.negociopersistenciaapp.persistencia.dao.PaisDao;
import com.irs.negociopersistenciaapp.persistencia.dao.exceptions.DaoException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementanción de la interface de la logica de negocio empleada para los
 * paises.
 *
 * @author IRS
 * @version 1.0.0
 */
@Service("com.irs.negociopersistenciaapp.negocio.servicios.PaisService")
public class PaisServiceImpl implements PaisService {

    private static final Logger LOG = LoggerFactory.getLogger(PaisServiceImpl.class);

    @Autowired
    private PaisDao paisDao;

    /**
     * Constructor por defecto.
     */
    public PaisServiceImpl() {
        super();
    }

    /**
     * Busca todos los paises.
     *
     * @return La lista de todos los paises.
     * @throws ServiceException Si se produce un error en la busqueda.
     */
    public Collection<PaisVO> findAll() throws ServiceException {
        try {
            LOG.info("Buscando todos los paises");
            return paisDao.selectAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Busca todos los paises.
     *
     * @return La lista de todos los paises ordenados por el nombre de campo
     * indicado.
     * @throws ServiceException Si se produce un error en la busqueda.
     */
    public Collection<PaisVO> findAllSortByField(String fieldName) throws ServiceException {
        try {
            LOG.info("Buscando todos los paises ordendados por '{}'", fieldName);
            return paisDao.selectAll(fieldName, true);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Busca un pais por identificador.
     *
     * @param idPais identificador del pais a buscar.
     * @return El pais con el identificador especificado.
     * @throws ServiceException Si se produce un error en la busqueda.
     */
    public PaisVO findById(Integer idPais) throws ServiceException {
        try {
            LOG.info("Buscado el pais con id '{}'", idPais);
            return paisDao.selectById(idPais);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Guarda un nuevo pais.
     *
     * @param pais el nuevo pais a guardar.
     * @return El nuevo pais guardado.
     * @throws ServiceException Si se produce un error al guardar el pais.
     */
    public PaisVO save(PaisVO pais) throws ServiceException {
        try {
            LOG.info("Insertando pais '{}'", pais);
            return paisDao.insert(pais);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Actualiza un pais.
     *
     * @param pais El pais a actualizar.
     * @throws ServiceException Si se produce un error en la actualizacion del
     * pais.
     */
    public void update(PaisVO pais) throws ServiceException {
        try {
            LOG.info("Actualizando pais '{}'", pais);
            paisDao.update(pais);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Borra un pais (Borrado físico).
     *
     * @param pais pais a borrar.
     * @throws ServiceException Si se produce un error en el borrado del pais.
     */
    public void remove(PaisVO pais) throws ServiceException {
        try {
            LOG.info("Eliminando pais '{}'", pais);
            paisDao.delete(pais);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
