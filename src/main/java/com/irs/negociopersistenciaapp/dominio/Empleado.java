package com.irs.negociopersistenciaapp.dominio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Clase del dominio empleada para almacenar los empleados.
 *
 * @author IRS
 * @version 1.0.0
 */
@Entity
@Table(name = "EMPLEADOS")
public class Empleado extends BaseEntity implements Identifiable<Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador del empleado.
     */
    @Id
    @Column(name = "ID_EMPLEADO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idEmpleado;

    /**
     * Nombre del empleado.
     */
    @Column(name = "NOMBRE")
    private String nombre;

    /**
     * Primer apellido del empleado.
     */
    @Column(name = "APELLIDO1")
    private String apellido1;

    /**
     * Segundo apellido del empleado.
     */
    @Column(name = "APELLIDO2")
    private String apellido2;

    /**
     * Direccion del empleado.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Direccion direccion;

    /**
     * Constructor por defecto.
     */
    public Empleado() {
        super();
        this.idEmpleado = null;
        this.nombre = null;
        this.apellido1 = null;
        this.apellido2 = null;
        this.direccion = null;
    }

    /**
     * Método que obtiene el identificador del empleado.
     *
     * @return Devuelve el identificador del empleado.
     */
    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * Método que establece el identificador del empleado.
     *
     * @param idEmpleado El identificador del empleado.
     */
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /**
     * Método que obtiene el nombre del empleado.
     *
     * @return Devuelve el nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que establece el nombre del empleado.
     *
     * @param nombre El nombre del empleado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que obtiene el primer apellido del empleado.
     *
     * @return Devuelve el primer apellido del empleado.
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * Método que establece el primer apellido del empleado.
     *
     * @param apellido1 El primer apellido del empleado.
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * Método que obtiene el segundo apellido del empleado.
     *
     * @return Devuelve el segundo apellido del empleado.
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * Método que establece el segundo apellido del empleado.
     *
     * @param apellido2 El segundo apellido del empleado.
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * Método que obtiene la direccion del empleado.
     *
     * @return Devuelve la direccion del empleado.
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Método que establece la direccion del empleado.
     *
     * @param direccion La direccion del empleado.
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Método que obtiene la clave primaria del empleado.
     *
     * @return Devuelve la clave primaria del empleado.
     */
    @Transient
    public Integer getPrimaryKey() {
        return getIdEmpleado();
    }

    /**
     * Método que obtiene el nombre de la clave primaria del empleado.
     *
     * @return Devuelve el nombre la clave primaria del empleado.
     */
    @Transient
    public String getPrimaryKeyName() {
        return "idEmpleado";
    }

    /**
     * Método que indica si el empleado es nuevo (true) o no (false).
     *
     * @return Devuelve true si el empleado es nuevo, false en caso contrario.
     */
    @Transient
    public boolean isNew() {
        return getIdEmpleado() == null;
    }
}
