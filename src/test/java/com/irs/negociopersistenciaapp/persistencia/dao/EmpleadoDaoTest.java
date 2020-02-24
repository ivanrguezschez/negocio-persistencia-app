package com.irs.negociopersistenciaapp.persistencia.dao;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.Assert;

import com.irs.negociopersistenciaapp.AbstractDaoTest;
import com.irs.negociopersistenciaapp.negocio.vo.DireccionVO;
import com.irs.negociopersistenciaapp.negocio.vo.EmpleadoVO;
import com.irs.negociopersistenciaapp.negocio.vo.PaisVO;
import com.irs.negociopersistenciaapp.persistencia.dao.exceptions.DaoException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@TransactionConfiguration(transactionManager = "txManager")
@Transactional
public class EmpleadoDaoTest extends AbstractDaoTest {

    private static final Logger LOG = LoggerFactory.getLogger(EmpleadoDaoTest.class);

    @Autowired
    private EmpleadoDao empleadoDao;
    
    /*
    @Test
    public void testSelectAll() throws Exception {
        LOG.info("----- TEST SELECT ALL -----");
        Collection<PaisVO> paises = null;

        paises = paisDao.selectAll();
        Assert.assertNotNull(paises);
        Assert.assertFalse(paises.isEmpty());

        paises = paisDao.selectAll("nombre", true);
        Assert.assertNotNull(paises);
        Assert.assertFalse(paises.isEmpty());

        paises = paisDao.selectAll(null, true);
        Assert.assertNotNull(paises);
        Assert.assertFalse(paises.isEmpty());

        try {
            paises = paisDao.selectAll("nombree", true);
            fail("Buscando todos los pais y ordenando por un campo que no existe");
        } catch (DaoException e) {
            LOG.warn(e.getMessage(), e);
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testSelectById() throws Exception {
        LOG.info("----- TEST SELECT BY ID -----");
        PaisVO pais = null;

        try {
            // Nulo
            pais = paisDao.selectById(null);
            fail("Buscando pais nulo");
        } catch (DaoException e) {
            LOG.warn(e.getMessage(), e);
            Assert.assertTrue(true);
        }

        // Pais que no existe
        pais = paisDao.selectById(10);
        Assert.assertNull(pais);

        pais = paisDao.selectById(1);
        Assert.assertNotNull(pais);
    }
    */
    
    @Test
    public void testInsert() throws Exception {
        LOG.info("----- TEST INSERT -----");
        EmpleadoVO empleado = null;
        DireccionVO direccion = null;

        direccion = new DireccionVO();
        direccion.setNombreVia("Paseo de la Castellana");
        direccion.setNumeroVia("100");
        direccion.setCodigoPostal("28000");
        
        empleado = new EmpleadoVO();
        empleado.setNombre("Nombre-01");
        empleado.setApellido1("Apellido1-01");
        empleado.setApellido2("Apellido2-01");
        empleado.setDireccion(direccion);
        
        empleado = empleadoDao.insert(empleado);
        
        LOG.info("Empleado: {}", empleado);
        
        Assert.assertNotNull(empleado);
        Assert.assertNotNull(empleado.getIdEmpleado());
        
        LOG.info("Buscando el empleado 1");
        
        EmpleadoVO empleadoBuscado = empleadoDao.selectById(1);
        LOG.info("Empleado Buscando: {}", empleadoBuscado);
    }

    /*
    @Test
    public void testInsertCollection() throws Exception {
        LOG.info("----- TEST INSERT COLLECTION -----");
        Collection<PaisVO> paises = null;
        Collection<PaisVO> collection = null;

        try {
            paises = paisDao.insertCollection(null);
            fail("Insertando colecciones de paises nula");
        } catch (DaoException e) {
            LOG.warn(e.getMessage(), e);
            Assert.assertTrue(true);
        }

        paises = paisDao.insertCollection(new ArrayList<PaisVO>());
        Assert.assertTrue(paises.isEmpty());

        try {
            collection = new ArrayList<PaisVO>();
            collection.add(null);
            collection.add(null);
            paises = paisDao.insertCollection(collection);
            fail("Insertando colecciones de paises con elementos nulos");
        } catch (DaoException e) {
            LOG.warn(e.getMessage(), e);
            Assert.assertTrue(true);
        }

        PaisVO pais1 = new PaisVO();
        pais1.setNombre("Irlanda");

        PaisVO pais2 = new PaisVO();
        pais2.setNombre("Belgica");

        collection = new ArrayList<PaisVO>();
        collection.add(pais1);
        collection.add(pais2);

        paises = paisDao.insertCollection(collection);
        Assert.assertNotNull(paises);
    }

    @Test
    public void testUpdate() throws Exception {
        LOG.info("----- TEST UPDATE -----");
        PaisVO pais = null;

        try {
            paisDao.update(pais);
            fail("Actualizando pais nulo");
        } catch (DaoException e) {
            LOG.warn(e.getMessage(), e);
            Assert.assertTrue(true);
        }
        try {
            PaisVO paisNoExiste = new PaisVO();
            paisNoExiste.setIdPais(10);
            paisNoExiste.setNombre("Rusia");
            paisDao.update(paisNoExiste);
            fail("Actualizando pais que no existe");
        } catch (DaoException e) {
            LOG.warn(e.getMessage(), e);
            Assert.assertTrue(true);
        }

        PaisVO paisUpdate = new PaisVO();
        paisUpdate.setIdPais(1);
        paisUpdate.setNombre("ESPAÑA");
        paisDao.update(paisUpdate);

        pais = paisDao.selectById(paisUpdate.getIdPais());
        Assert.assertTrue(paisUpdate.getNombre().equals(pais.getNombre()));
    }

    @Test
    public void testDelete() throws Exception {
        LOG.info("----- TEST DELETE -----");
        PaisVO pais = null;

        try {
            paisDao.delete(pais);
            fail("Eliminando pais nulo");
        } catch (DaoException e) {
            LOG.warn(e.getMessage(), e);
            Assert.assertTrue(true);
        }

        pais = paisDao.selectById(1);
        paisDao.delete(pais);
        pais = paisDao.selectById(1);
        Assert.assertNull(pais);
    }

    @Test
    public void testDeleteById() throws Exception {
        LOG.info("----- TEST DELETE BY ID -----");
        PaisVO pais = null;

        try {
            paisDao.deleteById(null);
            fail("Eliminando pais nulo");
        } catch (DaoException e) {
            LOG.warn(e.getMessage(), e);
            Assert.assertTrue(true);
        }

        paisDao.deleteById(1);
        pais = paisDao.selectById(1);
        Assert.assertNull(pais);
    }

    @Test
    public void testDeleteCollection() throws Exception {
        LOG.info("----- TEST DELETE COLLECTION -----");
        Collection<PaisVO> paises = null;

        try {
            paisDao.deleteCollection(paises);
            fail("Eliminando colecciones de paises con elementos nulos");
        } catch (DaoException e) {
            LOG.warn(e.getMessage(), e);
            Assert.assertTrue(true);
        }

        paisDao.deleteCollection(new ArrayList<PaisVO>());
        Assert.assertTrue(true);

        try {
            paises = new ArrayList<PaisVO>();
            paises.add(null);
            paises.add(null);
            paisDao.deleteCollection(paises);
            fail("Eliminando colecciones de paises con elementos nulos");
        } catch (DaoException e) {
            LOG.warn(e.getMessage(), e);
            Assert.assertTrue(true);
        }

        PaisVO pais1 = new PaisVO();
        pais1.setIdPais(1);
        pais1.setNombre("España");

        PaisVO pais2 = new PaisVO();
        pais2.setIdPais(2);
        pais2.setNombre("Portugal");

        paises = new ArrayList<PaisVO>();
        paises.add(pais1);
        paises.add(pais2);

        paisDao.deleteCollection(paises);

        Assert.assertNull(paisDao.selectById(1));
        Assert.assertNull(paisDao.selectById(2));
    }
    */
}
