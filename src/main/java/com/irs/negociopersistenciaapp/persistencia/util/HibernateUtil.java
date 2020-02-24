package com.irs.negociopersistenciaapp.persistencia.util;

import java.io.Serializable;
import java.text.MessageFormat;

import com.irs.negociopersistenciaapp.dominio.Identifiable;

/**
 * Clase con método de utilidad relacionados con Hibernate.
 *
 * @author IRS
 * @version 1.0.0
 */
@SuppressWarnings("unchecked")
public final class HibernateUtil {

    private static final String SELECT_ALL_QUERY
            = "from {0} {1,choice,1#|2#order by {2}}";

    private static final String SELECT_ALL_SORT_QUERY
            = //"from {0} order by {1} {2,choice,1#asc|2#desc}";
            "from {0} {1,choice, 1#|2#order by {2} {3}}";

    public static String buildSelectAllQuery(Class<?> entityClass) {
        String primaryKeyName = null;
        try {
            primaryKeyName = ((Identifiable<Serializable>) entityClass.newInstance()).getPrimaryKeyName();
        } catch (Exception e) {
            primaryKeyName = null;
        }
        return MessageFormat.format(SELECT_ALL_QUERY, new Object[]{
            entityClass.getSimpleName(),
            (primaryKeyName == null || primaryKeyName.trim().length() == 0 ? 1 : 2),
            primaryKeyName
        });
    }

    public static String buildSelectAllSortQuery(Class<?> entityClass, String sortFieldName, boolean asc) {
        return MessageFormat.format(SELECT_ALL_SORT_QUERY, new Object[]{
            entityClass.getSimpleName(),
            (sortFieldName == null || sortFieldName.trim().length() == 0 ? 1 : 2),
            sortFieldName,
            (asc ? "asc" : "desc")
        });
    }
}
