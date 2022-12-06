package com.example.business;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    public void test() {
        List arrayListSpy = spy(ArrayList.class);
        assertEquals(0, arrayListSpy.size());
        arrayListSpy.add("Dummy");
        assertEquals(1, arrayListSpy.size());
        arrayListSpy.remove("Dummy");
        assertEquals(0, arrayListSpy.size());
    }

    @Test
    public void test_spy_stub() {
        List arrayListSpy = spy(ArrayList.class);
        stub(arrayListSpy.size()).toReturn(5);
        assertEquals(5, arrayListSpy.size());
        arrayListSpy.add("Dummy");
        assertEquals(5, arrayListSpy.size());
    }

    @Test
    public void test_spy_verify_invocation() {
        List arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Dummy");
        verify(arrayListSpy).add("Dummy");
        verify(arrayListSpy, never()).add("example");
    }
}