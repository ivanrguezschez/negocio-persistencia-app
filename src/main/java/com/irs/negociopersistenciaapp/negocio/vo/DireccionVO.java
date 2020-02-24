package com.irs.negociopersistenciaapp.negocio.vo;

/**
 * Clase de negocio Value Object (VO) empleado para almacenar las direcciones.
 *
 * @author IRS
 * @version 1.0.0
 */
public class DireccionVO extends BaseVO {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador del empleado a la que pertenece la dirección.
     */
    private Integer idEmpleado;

    /**
     * Nombre de la via de la dirección.
     */
    private String nombreVia;

    /**
     * Número de la via de la dirección.
     */
    private String numeroVia;

    /**
     * Código portal de la dirección
     */
    private String codigoPostal;

    /**
     * Constructor por defecto.
     */
    public DireccionVO() {
        super();
        this.idEmpleado = null;
        this.nombreVia = null;
        this.numeroVia = null;
        this.codigoPostal = null;
    }

    /**
     * Método que obtiene el identificador del empleado de la dirección.
     *
     * @return Devuelve el identificador del empleado de la dirección.
     */
    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * Método que establece el identificador del empleado de la dirección.
     *
     * @param idEmpleado El identificador del empleado de la dirección.
     */
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /**
     * Método que obtiene el nombre de via de la dirección.
     *
     * @return Devuelve el nombre de via de la dirección.
     */
    public String getNombreVia() {
        return nombreVia;
    }

    /**
     * Método que establece el nombre de via de la dirección.
     *
     * @param nombreVia El nombre de via de la dirección.
     */
    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }

    /**
     * Método que obtiene el numero de via de la dirección.
     *
     * @return Devuelve el numero de via de la dirección.
     */
    public String getNumeroVia() {
        return numeroVia;
    }

    /**
     * Método que establece el numero de via de la dirección.
     *
     * @param numeroVia El numero de via de la dirección.
     */
    public void setNumeroVia(String numeroVia) {
        this.numeroVia = numeroVia;
    }

    /**
     * Método que obtiene el codigo postal de la dirección.
     *
     * @return Devuelve el codigo postal de la dirección.
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Método que establece el codigo postal de la dirección.
     *
     * @param codigoPostal El codigo postal de la dirección.
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
