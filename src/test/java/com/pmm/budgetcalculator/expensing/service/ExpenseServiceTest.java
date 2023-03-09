package com.pmm.budgetcalculator.expensing.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.pmm.budgetcalculator.expensing.entity.Expense;
import com.pmm.budgetcalculator.expensing.entity.dto.ExpenseDto;
import com.pmm.budgetcalculator.expensing.entity.mapper.ExpenseMapper;
import com.pmm.budgetcalculator.expensing.repository.ExpenseRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

//Tego potrzebujemy żeby użyć junit5
@ExtendWith(SpringExtension.class)
//Tutaj importujemy nasz service który będziemy testować
@Import({ExpenseService.class})
//Nazwa klasy: klasa którą testujemy + Test
class ExpenseServiceTest {

    //Mokcujemy repository czyli sam bean będzie null i wszystkie metody które zawołamy będą zwracały null - lecz dzięki
    // temu możemy ustalić co dana klasa ma nam zwracać przy wywołaniu danej metody niezależnie od stanu faktycznego
    @MockBean
    private ExpenseRepository expenseRepository;

    //Mapper mockujemy chcemy testować tylko logikę w service a nie mapowanie
    @MockBean
    private ExpenseMapper expenseMapper;

    //Potrzebujemy też wstrzyknietego serwisu żeby zawołać z niego metody do testów
    @Autowired
    private ExpenseService expenseService;

    //Display name to nazwa testu który się wyśietla jak puszczamy - dobrze tu opisać co test testuje
    @DisplayName("Given 2 example entites in database when getAllExpenses call return list of size 2 with mapped entites to DTOs")
    // @Test potrzebujemy żeby to był to test :D
    @Test
    //testowe metody zawsze są w podstawowym dostępie i void co do nazwy jest wiele konwencji - tutaj nie obowiązują
    // zasady że nazwy metod powinny być pisane camelCase czy powinny być krótkie i czytelne - tutaj skupiamy się raczej
    // na jak najlepszym zasygnalizowaniu co test robi. Ja lubie knowencje nazuwania given_when_then - bo w taki sposób
    // piszemy testy jednostkowe: Given opisujemy setup, when opisujemy co testujemy, then - opsiujemy jaki ma być wynik
    // aby test przesszedł
    void givenTwoEntitesInDatabase_whenGetAllExpenses_thenReturnListWithSizeEqualToNumberOfEntitiesInDatabaseMappedToDto() {
        //given
        //tworzymy sobie listę expensów
        Expense expense1 = new Expense();
        Expense expense2 = new Expense();
        List<Expense> expenses = Arrays.asList(expense2, expense1);

        //tutaj ustalamy że jak zawołamy findAll na repozytorium (ta metoda jest wołana w serwisie) to zamiast wykonywać zapytanie
        // do bazy danych zwróci nam po prosty tą listę
        when(expenseRepository.findAll()).thenReturn(expenses);
        //tutaj ustalamy że jak zawołamy entityToDto to zwróci nam dto
        when(expenseMapper.entityToDto(any())).thenReturn(new ExpenseDto());

        //when
        //tutaj wołamy metodę którą chcemy testować
        final List<ExpenseDto> allExpenses = expenseService.getAllExpenses();

        //then
        //dobrze jest mieć jedną asercję do jednego testu, lecz tutaj sobie pozwolę do celów demonstracyjnych podać więcej
        // przykładów. Sprawdzamy czy lista którą otrzumujemy z metody ma tą samą długość co lista którą "zwraca nam baza danych"
        // sprawdzamy też czy oba rekordy się przemapowały na dto
        assertAll(
                () -> assertEquals(2, allExpenses.size()),
                () -> assertInstanceOf(ExpenseDto.class, allExpenses.get(0)),
                () -> assertInstanceOf(ExpenseDto.class, allExpenses.get(1))
        );
    }

    //Jak widzisz niewiele tu jest sensu z aktualną logiką - głównie testujemy mocki teraz - ale
    // cel zadania jest taki, żebyś umiała napisać takie najprostrze testy i miała już jakiś test suite
    // żeby odpalać go przy każdej zmianie kodu w serwisie - jak coś nei przechodzi do modyfikujemy test
    // tak aby jak najbardziej odziwerdciedlał to co ma dana metoda robić

    //Z ciekawszych rzeczy możesz możesz sobie wygooglować jak testować mapstructa (klasy wygenerowane przez niego)
    // tam już coś można fajnego popisać
}
