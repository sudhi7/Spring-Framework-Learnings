package com.example.business;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void mockListSizeMethod() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    public void mockListGetMethod() {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("Hello");
        assertEquals("Hello", listMock.get(0));
        assertEquals(null, listMock.get(1));
    }

    @Test
    public void mockListGetMethod_AnyInt() {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenReturn("Hello");
        assertEquals("Hello", listMock.get(0));
        assertEquals("Hello", listMock.get(1));
    }

    @Test
    public void mockListGetMethod_AnyInt_BDD() {
        //Given
        List listMock = mock(List.class);
        given(listMock.get(anyInt())).willReturn("Hello");

        //When-Then
        assertThat(listMock.get(0), is("Hello"));
    }

    @Test(expected=RuntimeException.class)
    public void mockListGetMethod_ThrowsException() {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something is fishy"));
        listMock.get(0);
    }

}