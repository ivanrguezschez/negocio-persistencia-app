package com.irs.negociopersistenciaapp;

import junit.framework.TestCase;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:negociopersistenciaapp-test.xml"})
public abstract class AbstractServiceTest extends TestCase {

}
