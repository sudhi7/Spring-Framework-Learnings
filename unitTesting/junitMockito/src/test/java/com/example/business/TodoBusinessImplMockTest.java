package com.example.business;

import com.example.data.api.TodoService;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockTest {

    @Test
    public void testRetrieveTodosRelatedToSpring() {
        TodoService mockTodoService = mock(TodoService.class);
        when(mockTodoService.retrieveTodos("Dummy")).thenReturn(Arrays.asList("Learn Spring MVC","Learn Spring", "Learn to Dance"));
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);
        List<String> filteredTodos= todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, filteredTodos.size());
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_usingBDD() {
        //Given
        TodoService mockTodoService = mock(TodoService.class);
        given(mockTodoService.retrieveTodos("Dummy")).willReturn(Arrays.asList("Learn Spring MVC","Learn Spring", "Learn to Dance"));
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);

        //When
        List<String> filteredTodos= todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        //Then
        assertThat(filteredTodos.size(), is(2));
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD() {
        //Given
        TodoService mockTodoService = mock(TodoService.class);
        given(mockTodoService.retrieveTodos("Dummy")).willReturn(Arrays.asList("Learn Spring MVC","Learn Spring", "Learn to Dance"));
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);

        //When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        //Then
        verify(mockTodoService).deleteTodo("Learn to Dance");
        then(mockTodoService).should().deleteTodo("Learn to Dance");

        verify(mockTodoService, never()).deleteTodo("Learn Spring");
        then(mockTodoService).should(never()).deleteTodo("Learn Spring");
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture() {

        //Declare Argument Captor
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

        //Given
        TodoService mockTodoService = mock(TodoService.class);
        given(mockTodoService.retrieveTodos("Dummy")).willReturn(Arrays.asList("Learn Spring MVC","Learn Spring", "Learn to Dance"));
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);

        //When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        //Then
        //Define Argument captor on specific method call
        // Capture the argument
        then(mockTodoService).should().deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCaptureMultipleTimes() {

        //Declare Argument Captor
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

        //Given
        TodoService mockTodoService = mock(TodoService.class);
        given(mockTodoService.retrieveTodos("Dummy")).willReturn(Arrays.asList("Learn Spring MVC","Learn Singing", "Learn to Dance"));
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);

        //When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        //Then
        //Define Argument captor on specific method call
        // Capture the argument
        then(mockTodoService).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
    }

}