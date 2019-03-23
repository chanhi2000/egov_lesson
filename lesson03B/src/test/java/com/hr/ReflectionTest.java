package com.hr;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReflectionTest {
    private Logger LOG = Logger.getLogger(this.getClass());


    @Test
    public void invokeMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String name = "Spring";
        LOG.debug("==========================================");
        LOG.debug("name.length() = "+name.length());
        LOG.debug("==========================================");
        assertThat(name.length(), is(6));

        // invoke the class' method to access targeted variable
        Method lengthMethod = String.class.getMethod("length");
        LOG.debug("==========================================");
        LOG.debug("lengthMethod.invoke(name) = "+lengthMethod.invoke(name));
        LOG.debug("==========================================");
        assertThat(  (Integer)lengthMethod.invoke(name), is(6)  );

        //charAt
        LOG.debug("==========================================");
        LOG.debug("name.charAt(0) = "+name.charAt(0));
        LOG.debug("==========================================");
        assertThat(name.charAt(0), is('S'));

        Method charAtMethod = String.class.getMethod("charAt", int.class);
        LOG.debug("==========================================");
        LOG.debug("charAtMethod.invoke(name, 0) = "+charAtMethod.invoke(name, 0));
        LOG.debug("==========================================");
        assertThat(  (Character)charAtMethod.invoke(name, 0), is('S')  );
    }


}
