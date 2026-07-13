package com.cognizant.testing;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MyServiceTest {
    @Test void stubsExternalApi() {
        ExternalApi api = mock(ExternalApi.class);
        when(api.getData()).thenReturn("Mock Data");
        assertEquals("Mock Data", new MyService(api).fetchData());
    }

    @Test void verifiesInteraction() {
        ExternalApi api = mock(ExternalApi.class);
        MyService service = new MyService(api);
        service.fetchData();
        verify(api).getData();
    }

    @Test void verifiesArgumentsAndOrder() {
        ExternalApi api = mock(ExternalApi.class);
        MyService service = new MyService(api);
        service.publish("hello");
        service.fetchData();
        verify(api).saveData(eq("hello"));
        InOrder order = inOrder(api);
        order.verify(api).saveData("hello");
        order.verify(api).getData();
    }
}
