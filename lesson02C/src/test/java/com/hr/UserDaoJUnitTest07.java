package com.hr;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

public class UserDaoJUnitTest07 {
    public static UserDaoJUnitTest07 testObject;

    @Test
    public void test01() {
        assertThat(1, is(not(sameInstance(testObject))));
        testObject = this;
    }

    @Test
    public void test02() {
        assertThat(this, is(not(sameInstance(testObject))));
        testObject = this;
    }
}
