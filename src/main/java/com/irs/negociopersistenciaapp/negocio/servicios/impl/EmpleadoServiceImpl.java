package com.irs.negociopersistenciaapp.negocio.servicios.impl;

import com.irs.negociopersistenciaapp.negocio.servicios.EmpleadoService;
import java.util.Collection;

import com.irs.negociopersistenciaapp.negocio.servicios.exceptions.ServiceException;
import com.irs.negociopersistenciaapp.negocio.vo.EmpleadoVO;
import com.irs.negociopersistenciaapp.persistencia.dao.EmpleadoDao;
import com.irs.negociopersistenciaapp.persistencia.dao.exceptions.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementanción de la interface de la logica de negocio empleada para los
 * empleados.
 *
 * @author IRS
 * @version 1.0.0
 */
@Service("com.irs.negociopersistenciaapp.negocio.servicios.EmpleadoService")
public class EmpleadoServiceImpl implements EmpleadoService {

    private static final Logger LOG = LoggerFactory.getLogger(EmpleadoServiceImpl.class);

    @Autowired
    private EmpleadoDao empleadoDao;

    /**
     * Constructor por defecto.
     */
    public EmpleadoServiceImpl() {
        super();
    }

    /**
     * Busca todos los empleados.
     *
     * @return La lista de todos los empleados.
     * @throws ServiceException Si se produce un error en la busqueda.
     */
    public Collection<EmpleadoVO> findAll() throws ServiceException {
        try {
            LOG.info("Buscando todos los empleados");
            return empleadoDao.selectAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Busca todos los empleados.
     *
     * @return La lista de todos los empleados ordenados por el nombre de campo
     * indicado.
     * @throws ServiceException Si se produce un error en la busqueda.
     */
    public Collection<EmpleadoVO> findAllSortByField(String fieldName) throws ServiceException {
        try {
            LOG.info("Buscando todos los empleados ordendados por '{}'", fieldName);
            return empleadoDao.selectAll(fieldName, true);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Busca un empleado por identificador.
     *
     * @param idEmpleado identificador del empleado a buscar.
     * @return El empleado con el identificador especificado.
     * @throws ServiceException Si se produce un error en la busqueda.
     */
    public EmpleadoVO findById(Integer idEmpleado) throws ServiceException {
        try {
            LOG.info("Buscado el empleado con id '{}'", idEmpleado);
            return empleadoDao.selectById(idEmpleado);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Guarda un nuevo empleado.
     *
     * @param empleado el nuevo empleado a guardar.
     * @return El nuevo empleado guardado.
     * @throws ServiceException Si se produce un error al guardar el empleado.
     */
    public EmpleadoVO save(EmpleadoVO empleado) throws ServiceException {
        try {
            LOG.info("Insertando empleado '{}'", empleado);
            return empleadoDao.insert(empleado);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Actualiza un empleado.
     *
     * @param empleado El empleado a actualizar.
     * @throws ServiceException Si se produce un error en la actualizacion del
     * empleado.
     */
    public void update(EmpleadoVO empleado) throws ServiceException {
        try {
            LOG.info("Actualizando empleado '{}'", empleado);
            empleadoDao.update(empleado);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Borra un empleado (Borrado físico).
     *
     * @param empleado empleado a borrar.
     * @throws ServiceException Si se produce un error en el borrado del
     * empleado.
     */
    public void remove(EmpleadoVO empleado) throws ServiceException {
        try {
            LOG.info("Eliminando empleado '{}'", empleado);
            empleadoDao.delete(empleado);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
