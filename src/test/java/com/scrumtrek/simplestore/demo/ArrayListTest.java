package com.scrumtrek.simplestore.demo;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

public class ArrayListTest {
    @Test(timeout = 1_000)
    public void shouldSizeIncrementedWhenElementAdd() { //BDD = DDD + tests
        //region Fixture | Arrange | Given
        ArrayList sut = new ArrayList();
        Object dummy = new Object();

        assumeTrue(sut.isEmpty());
        //endregion

        //region Act | When
        sut.add(dummy);
        //endregion

        //region Assert | Then
        assertEquals(1, sut.size());
        //endregion
    }

    @Ignore
    @Test(expected = Exception.class)
    public void shouldGetErrorWhenElementIsNull() {
        ArrayList<Object> sut = new ArrayList<>();
        sut.add(null);
    }
}
