package com.irs.negociopersistenciaapp.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Clase del dominio empleada para almacenar las direcciones.
 *
 * @author IRS
 * @version 1.0.0
 */
@Entity
@Table(name = "DIRECCIONES")
public class Direccion extends BaseEntity implements Identifiable<Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador del empleado a la que pertenece la dirección.
     */
    @Id
    @Column(name = "ID_EMPLEADO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idEmpleado;

    /**
     * Nombre de la via de la dirección.
     */
    @Column(name = "NOMBRE_VIA")
    private String nombreVia;

    /**
     * Número de la via de la dirección.
     */
    @Column(name = "NUMERO_VIA")
    private String numeroVia;

    /**
     * Código portal de la dirección
     */
    @Column(name = "CODIGO_POSTAL")
    private String codigoPostal;

    /**
     * Constructor por defecto.
     */
    public Direccion() {
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

    /**
     * Método que obtiene la clave primaria de la direccion.
     *
     * @return Devuelve la clave primaria de la direccion.
     */
    @Transient
    public Integer getPrimaryKey() {
        return getIdEmpleado();
    }

    /**
     * Método que obtiene el nombre de la clave primaria de la direccion.
     *
     * @return Devuelve el nombre la clave primaria de la direccion.
     */
    @Transient
    public String getPrimaryKeyName() {
        return "idEmpleado";
    }

    /**
     * Método que indica si la direccion es nueva (true) o no (false).
     *
     * @return Devuelve true si la dirección es nueva, false en caso contrario.
     */
    @Transient
    public boolean isNew() {
        return getIdEmpleado() == null;
    }
}
