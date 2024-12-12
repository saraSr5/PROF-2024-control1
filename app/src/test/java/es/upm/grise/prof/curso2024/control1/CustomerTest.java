package es.upm.grise.prof.curso2024.control1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerTest {

    // Defino las constantes porque asi evito los Magic Numbers
    private static final float ACCOUNT_1_BALANCE = 1000.0f;
    private static final float ACCOUNT_2_BALANCE = 2000.0f;
    private static final float ACCOUNT_3_BALANCE = 3000.0f;

    private static final String ACCOUNT_1_NAME = "ACC1";
    private static final String ACCOUNT_2_NAME = "ACC2";
    private static final String ACCOUNT_3_NAME = "ACC3";

    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer();

        // Creo y agrego las cuentas al Customer
        Account account1 = new Account();
        account1.setAccountNumber(ACCOUNT_1_NAME);
        account1.setInitialAmount(ACCOUNT_1_BALANCE);
        customer.addTransaction(account1);

        Account account2 = new Account();
        account2.setAccountNumber(ACCOUNT_2_NAME);
        account2.setInitialAmount(ACCOUNT_2_BALANCE);
        customer.addTransaction(account2);

        Account account3 = new Account();
        account3.setAccountNumber(ACCOUNT_3_NAME);
        account3.setInitialAmount(ACCOUNT_3_BALANCE);
        customer.addTransaction(account3);
    }

    @Test
    public void customerWithoutAcc() {
        // Creo un customer
        customer = new Customer();

        // Verifico que se lanza la excepcion
        assertThrows(NoAccountsException.class, () -> {
            customer.getAccountWithHighestBalance();
        });
    }

    @Test
    public void correctAccountNumber() throws NoAccountsException {
        // Verificamos que el método devuelve el número de cuenta correcto
        String accHighBalance = customer.getAccountWithHighestBalance();

        // El saldo más alto es de ACCOUNT_2
        assertEquals(ACCOUNT_3_NAME, accHighBalance, "La cuenta con el mayor saldo es ACC3");
    }

    @Test
    public void correctAccountNumberMockito() throws NoAccountsException {
        // Creo un mock del Customer
        Customer customer = new Customer();

        // Creo mocks para las cuentas (Account)
        Account account1 = mock(Account.class);
        Account account2 = mock(Account.class);
        Account account3 = mock(Account.class);

        // Configuro los comportamientos de lo mocks
        when(account1.getAccountNumber()).thenReturn(ACCOUNT_1_NAME);
        when(account1.getCurrentBalance()).thenReturn(ACCOUNT_1_BALANCE);

        when(account2.getAccountNumber()).thenReturn(ACCOUNT_2_NAME);
        when(account2.getCurrentBalance()).thenReturn(ACCOUNT_2_BALANCE);

        when(account3.getAccountNumber()).thenReturn(ACCOUNT_3_NAME);
        when(account3.getCurrentBalance()).thenReturn(ACCOUNT_3_BALANCE);

        // Agrego las cuentas al cliente
        customer.addTransaction(account1);
        customer.addTransaction(account2);
        customer.addTransaction(account3);

        String accountWithHighestBalance = customer.getAccountWithHighestBalance();

        assertEquals(ACCOUNT_3_NAME, accountWithHighestBalance, "La cuenta con el mayor saldo debe ser ACC3");
    }

}