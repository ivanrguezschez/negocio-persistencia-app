package com.irs.negociopersistenciaapp.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Clase del dominio empleada para almacenar los paises.
 *
 * @author IRS
 * @version 1.0.0
 */
@Entity
@Table(name = "PAISES")
public class Pais extends BaseEntity implements Identifiable<Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador del pais.
     */
    @Id
    @Column(name = "ID_PAIS")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPais;

    /**
     * Nombre del pais.
     */
    @Column(name = "NOMBRE")
    private String nombre;

    /**
     * Constructor por defecto.
     */
    public Pais() {
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

    /**
     * Método que obtiene la clave primaria del pais.
     *
     * @return Devuelve la clave primaria del pais.
     */
    @Transient
    public Integer getPrimaryKey() {
        return getIdPais();
    }

    /**
     * Método que obtiene el nombre de la clave primaria del pais.
     *
     * @return Devuelve el nombre la clave primaria del pais.
     */
    @Transient
    public String getPrimaryKeyName() {
        return "idPais";
    }

    /**
     * Método que indica si el pais es nuevo (true) o no (false).
     *
     * @return Devuelve true si el pais es nuevo, false en caso contrario.
     */
    @Transient
    public boolean isNew() {
        return getIdPais() == null;
    }
}
