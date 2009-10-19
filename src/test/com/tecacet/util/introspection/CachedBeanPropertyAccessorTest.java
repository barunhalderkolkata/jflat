package com.tecacet.util.introspection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.beans.IntrospectionException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class CachedBeanPropertyAccessorTest {

    private CachedBeanPropertyAccessor<Order> accessor;

    @Before
    public void setUp() throws IntrospectionException {
        accessor = new CachedBeanPropertyAccessor<Order>(Order.class);
    }

    @Test
    public void testSetProperty() throws BeanIntrospectorException {
        Order bean = new Order();

        accessor.setProperty(bean, "number", "1234");
        assertEquals("1234", bean.getNumber());
        assertEquals("1234", accessor.getProperty(bean, "number"));
        accessor.setProperty(bean, "quantity", 10);
        assertEquals(10, bean.getQuantity());
        assertEquals(10, accessor.getProperty(bean, "quantity"));
        accessor.setProperty(bean, "price", 15.99);
        assertEquals(15.99, bean.getPrice(), 0.001);
        assertEquals(15.99, accessor.getProperty(bean, "price"));
        accessor.setProperty(bean, "active", true);
        assertTrue(bean.isActive());
        assertEquals(true, accessor.getProperty(bean, "active"));
        GregorianCalendar c = new GregorianCalendar(2007, Calendar.JULY, 4);
        accessor.setProperty(bean, "date", c.getTime());
        assertEquals(c.getTime(), bean.getDate());
        assertEquals(c.getTime(), accessor.getProperty(bean, "date"));
        

    }
    
    

    @Test
    public void testSetNullProperty() throws BeanIntrospectorException {
        Order bean = new Order();

        accessor.setProperty(bean, "number", null);
        assertNull(bean.getNumber());
        assertNull(accessor.getProperty(bean, "number"));
        // accessor.setProperty(bean, "quantity", null);
        // assertEquals(0, bean.getQuantity());
        // assertEquals("0", accessor.getProperty(bean, "quantity"));
        // accessor.setProperty(bean, "price", null);
        // assertEquals(0.0, bean.getPrice());
        // assertEquals("0.0", accessor.getProperty(bean, "price"));
        // accessor.setProperty(bean, "active", null);
        // assertFalse(bean.isActive());
        // assertEquals("false", accessor.getProperty(bean, "active"));

        accessor.setProperty(bean, "date", null);
        assertNull(bean.getDate());

    }
}