package com.irs.negociopersistenciaapp.persistencia.dao.exceptions;

import java.text.MessageFormat;

/**
 * Clase de Excepcion Padre que controla las excepciones que se producen en los
 * dao's de la capa de persistencia.
 *
 * @author IRS
 * @version 1.0.0
 */
@SuppressWarnings("serial")
public class DaoException extends Exception {

    private static final String MESSAGE_TEMPLATE = "Entidad ''{0}'': ";

    /**
     * Crea una nueva instancia de <code>DaoException</code> vacia.
     */
    public DaoException() {
        super();
    }

    /**
     * Construye una instancia de <code>DaoException</code> con el mensaje
     * especificado del detalle del error.
     *
     * @param message El mensaje del detalle del error.
     */
    public DaoException(String message) {
        super(message);
    }

    /**
     * Construye una instancia de <code>DaoException</code> con la causa del
     * error.
     *
     * @param cause La causa del error.
     */
    public DaoException(Throwable cause) {
        super(cause);
    }

    /**
     * Construye una instancia de <code>DaoException</code> con el mensaje
     * especificado del detalle del error y la causa del mismo.
     *
     * @param message El mensaje del detalle del error.
     * @param cause La causa del error.
     */
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(Class<?> entityClass) {
        this(MessageFormat.format(MESSAGE_TEMPLATE, entityClass.getSimpleName()));
    }

    public DaoException(Class<?> entityClass, String message) {
        this(MessageFormat.format(MESSAGE_TEMPLATE, entityClass.getSimpleName()) + message);
    }

    public DaoException(Class<?> entityClass, String message, Throwable cause) {
        this(MessageFormat.format(MESSAGE_TEMPLATE, entityClass.getSimpleName()) + message, cause);
    }

    @Override
    public String toString() {
        return super.toString() + (getCause() != null ? " (Causa: " + getCause().getMessage() + ")" : "");
    }
}
