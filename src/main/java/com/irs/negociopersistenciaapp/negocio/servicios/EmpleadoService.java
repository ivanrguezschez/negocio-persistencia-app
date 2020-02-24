package com.irs.negociopersistenciaapp.negocio.servicios;

import java.util.Collection;

import com.irs.negociopersistenciaapp.negocio.servicios.exceptions.ServiceException;
import com.irs.negociopersistenciaapp.negocio.vo.EmpleadoVO;

/**
 * Interface de la lógica de negocio empleada para los empleados.
 *
 * @author IRS
 * @version 1.0.0
 */
public interface EmpleadoService {

    /**
     * Busca todos los empleados.
     *
     * @return La lista de todos los empleados.
     * @throws ServiceException Si se produce un error en la busqueda.
     */
    public Collection<EmpleadoVO> findAll() throws ServiceException;

    /**
     * Busca todos los empleados.
     *
     * @return La lista de todos los empleados ordenados por el nombre de campo
     * indicado.
     * @throws ServiceException Si se produce un error en la busqueda.
     */
    public Collection<EmpleadoVO> findAllSortByField(String fieldName) throws ServiceException;

    /**
     * Busca un empleado por identificador.
     *
     * @param idEmpleado identificador del empleado a buscar.
     * @return El empleado con el identificador especificado.
     * @throws ServiceException Si se produce un error en la busqueda.
     */
    public EmpleadoVO findById(final Integer idEmpleado) throws ServiceException;

    /**
     * Guarda un nuevo empleado.
     *
     * @param empleado el nuevo empleado a guardar.
     * @return El nuevo empleado guardado.
     * @throws ServiceException Si se produce un error al guardar el empleado.
     */
    public EmpleadoVO save(EmpleadoVO empleado) throws ServiceException;

    /**
     * Actualiza un empleado.
     *
     * @param empleado El empleado a actualizar.
     * @throws ServiceException Si se produce un error en la actualizacion del
     * empleado.
     */
    public void update(EmpleadoVO empleado) throws ServiceException;

    /**
     * Borra un empleado (Borrado físico).
     *
     * @param empleado empleado a borrar.
     * @throws ServiceException Si se produce un error en el borrado del empleado.
     */
    public void remove(EmpleadoVO empleado) throws ServiceException;

}
