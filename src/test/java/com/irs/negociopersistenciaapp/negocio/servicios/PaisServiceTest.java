package com.irs.negociopersistenciaapp.negocio.servicios;

import java.util.Collection;

import junit.framework.Assert;

import com.irs.negociopersistenciaapp.AbstractDaoTest;
import com.irs.negociopersistenciaapp.negocio.servicios.exceptions.ServiceException;
import com.irs.negociopersistenciaapp.negocio.vo.PaisVO;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@TransactionConfiguration(transactionManager = "txManager")
@Transactional
public class PaisServiceTest extends AbstractDaoTest {

    private static final Logger LOG = LoggerFactory.getLogger(PaisServiceTest.class);

    @Autowired
    private PaisService paisService;


    @Test
    public void testFindAll() throws Exception {
        LOG.info("----- TEST FIND ALL -----");
        Collection<PaisVO> paises = null;

        paises = paisService.findAll();
        Assert.assertNotNull(paises);
        Assert.assertFalse(paises.isEmpty());
    }
   
    @Test
    public void testFindAllSortByField() throws Exception {
        LOG.info("----- TEST FIND ALL SORT BY FIELD -----");
        Collection<PaisVO> paises = null;

        paises = paisService.findAllSortByField("nombre");
        Assert.assertNotNull(paises);
        Assert.assertFalse(paises.isEmpty());

        paises = paisService.findAllSortByField(null);
        Assert.assertNotNull(paises);
        Assert.assertFalse(paises.isEmpty());

        try {
            paises = paisService.findAllSortByField("nombree");
            fail("Buscando todos los pais y ordenando por un campo que no existe");
        } catch (ServiceException e) {
            LOG.warn(e.getMessage(), e);
            Assert.assertTrue(true);
        }
    }
   
    
    @Test
    public void testFindById() throws Exception {
        LOG.info("----- TEST FIND BY ID -----");
        PaisVO pais = null;

        try {
            // Nulo
            pais = paisService.findById(null);
            fail("Buscando pais nulo");
        } catch (ServiceException e) {
            LOG.warn(e.getMessage(), e);
            Assert.assertTrue(true);
        }

        // Pais que no existe
        pais = paisService.findById(10);
        Assert.assertNull(pais);

        pais = paisService.findById(1);
        Assert.assertNotNull(pais);
    }

    @Test
    public void testSave() throws Exception {
        LOG.info("----- TEST SAVE -----");
        PaisVO pais = null;

        try {
            pais = paisService.save(pais);
            fail("Insertando pais nulo");
        } catch (ServiceException e) {
            LOG.warn(e.getMessage(), e);
            Assert.assertTrue(true);
        }

        pais = paisService.findById(1);
        try {
            pais = paisService.save(pais);
            fail("Insertando pais que ya existe");
        } catch (ServiceException e) {
            LOG.warn(e.getMessage(), e);
            Assert.assertTrue(true);
        }

        pais = new PaisVO();
        pais.setNombre("Irlanda");

        pais = paisService.save(pais);
        Assert.assertNotNull(pais);
        Assert.assertNotNull(pais.getIdPais());
    }

    @Test
    public void testUpdate() throws Exception {
        LOG.info("----- TEST UPDATE -----");
        PaisVO pais = null;

        try {
            paisService.update(pais);
            fail("Actualizando pais nulo");
        } catch (ServiceException e) {
            LOG.warn(e.getMessage(), e);
            Assert.assertTrue(true);
        }
        try {
            PaisVO paisNoExiste = new PaisVO();
            paisNoExiste.setIdPais(10);
            paisNoExiste.setNombre("Rusia");
            paisService.update(paisNoExiste);
            fail("Actualizando pais que no existe");
        } catch (ServiceException e) {
            LOG.warn(e.getMessage(), e);
            Assert.assertTrue(true);
        }

        PaisVO paisUpdate = new PaisVO();
        paisUpdate.setIdPais(1);
        paisUpdate.setNombre("ESPAÑA");
        paisService.update(paisUpdate);

        pais = paisService.findById(paisUpdate.getIdPais());
        Assert.assertTrue(paisUpdate.getNombre().equals(pais.getNombre()));
    }

    @Test
    public void testRemove() throws Exception {
        LOG.info("----- TEST REMOVE -----");
        PaisVO pais = null;

        try {
            paisService.remove(pais);
            fail("Eliminando pais nulo");
        } catch (ServiceException e) {
            LOG.warn(e.getMessage(), e);
            Assert.assertTrue(true);
        }

        pais = paisService.findById(1);
        paisService.remove(pais);
        pais = paisService.findById(1);
        Assert.assertNull(pais);
    }
}
