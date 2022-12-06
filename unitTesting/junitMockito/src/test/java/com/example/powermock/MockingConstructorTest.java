package com.example.powermock;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SystemUnderTest.class)
@PowerMockIgnore("jdk.internal.reflect.*")
public class MockingConstructorTest {

    //PrepareForTest => SystemUnderTest.class
    //override the constructor

    @Mock
    ArrayList mockList;

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Test
    public void testMethodUsingAContructor() throws Exception {
        when(mockList.size()).thenReturn(5);
        PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);
        int result = systemUnderTest.methodUsingAnArrayListConstructor();
        assertEquals(5, result);
    }

}