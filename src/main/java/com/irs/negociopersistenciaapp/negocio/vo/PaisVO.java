package com.irs.negociopersistenciaapp.negocio.vo;

/**
 * Clase de negocio Value Object (VO) empleado para almacenar los paises.
 *
 * @author IRS
 * @version 1.0.0
 */
public class PaisVO extends BaseVO {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador del pais.
     */
    private Integer idPais;

    /**
     * Nombre del pais.
     */
    private String nombre;

    /**
     * Constructor por defecto.
     */
    public PaisVO() {
        super();
        this.idPais = null;
        this.nombre = null;
    }

    /**
     * Método que obtiene el identificador del pais.
     *
     * @return Devuelve el identificador del pais.
     */
    public Integer getIdPais() {
        return idPais;
    }

    /**
     * Método que establece el identificador del pais.
     *
     * @param idPais El identificador del pais.
     */
    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    /**
     * Método que obtiene el nombre del pais.
     *
     * @return Devuelve el nombre del pais.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que establece el nombre del pais.
     *
     * @param nombre El nombre del paiso.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
