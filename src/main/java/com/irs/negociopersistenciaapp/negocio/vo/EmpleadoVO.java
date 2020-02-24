package com.irs.negociopersistenciaapp.negocio.vo;

/**
 * Clase de negocio Value Object (VO) empleado para almacenar los empleados.
 *
 * @author IRS
 * @version 1.0.0
 */
public class EmpleadoVO extends BaseVO {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador del empleado.
     */
    private Integer idEmpleado;

    /**
     * Nombre del empleado.
     */
    private String nombre;

    /**
     * Primer apellido del empleado.
     */
    private String apellido1;

    /**
     * Segundo apellido del empleado.
     */
    private String apellido2;

    /**
     * Direccion del empleado.
     */
    private DireccionVO direccion;

    /**
     * Constructor por defecto.
     */
    public EmpleadoVO() {
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
    public DireccionVO getDireccion() {
        return direccion;
    }

    /**
     * Método que establece la direccion del empleado.
     *
     * @param direccion La direccion del empleado.
     */
    public void setDireccion(DireccionVO direccion) {
        this.direccion = direccion;
    }
}
