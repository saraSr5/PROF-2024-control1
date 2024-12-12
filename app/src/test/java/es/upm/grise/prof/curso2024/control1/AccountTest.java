package es.upm.grise.prof.curso2024.control1;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testMockito() {
        // Creo un mock de la clase Account
        Account mockAccount = mock(Account.class);
        when(mockAccount.getCurrentBalance()).thenReturn(2000.0f);
        assertEquals(2000.0f, mockAccount.getCurrentBalance(), "El balance debe ser 2000");
    }

}
