package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.BillingDao;
import hu.uni.eku.tzs.model.Bill;
import hu.uni.eku.tzs.service.exceptions.BillAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class BillingServiceImplTest {
    private final BillingDao dao = mock(BillingDao.class);
    private BillingService service;

    @BeforeEach
    void setUp(){
        Mockito.reset(dao);
        service = new BillingServiceImpl(dao);
    }
    @Test
    void record() throws BillAlreadyExistsException{
        Bill bill = new Bill(LocalDate.of(2020, Month.NOVEMBER, 16),
                LocalDate.of(2020, Month.NOVEMBER, 20),
                "Peter", "Gulyas", (short)4, 30000);
        service.record(bill);
        verify(dao).create(any());

    }
    @Test
    void recordExistingBill(){
        Bill bill = new Bill(LocalDate.of(2020, Month.NOVEMBER, 16),
                LocalDate.of(2020, Month.NOVEMBER, 20),
                "Peter", "Gulyas", (short)4, 30000);;
        when(dao.readAll()).thenReturn(List.of(bill));
        assertThrows(BillAlreadyExistsException.class, () -> service.record(bill));
        verify(dao, never()).create(any());
    }
    @Test
    void readAll(){
        Collection<Bill> daoResponse = List.of(new Bill(LocalDate.of(2020, Month.NOVEMBER, 16),
                LocalDate.of(2020, Month.NOVEMBER, 20),
                "Peter", "Gulyas", (short)4, 30000),
        new Bill(LocalDate.of(2020, Month.NOVEMBER, 11),
                LocalDate.of(2020, Month.NOVEMBER, 14),
                "Lajos", "ASd", (short)3, 25000),
        new Bill(LocalDate.of(2020, Month.NOVEMBER, 6),
                LocalDate.of(2020, Month.NOVEMBER, 15),
                "Jans", "Hans", (short)9, 50000)
        );
        when(dao.readAll()).thenReturn(daoResponse);
        Collection<Bill> actual = service.readAll();
        assertEquals(daoResponse, actual);
    }
}
