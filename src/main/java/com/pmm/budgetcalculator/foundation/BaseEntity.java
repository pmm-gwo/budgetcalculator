package com.pmm.budgetcalculator.foundation;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass // sygnal dla Spring i JPA aby atrybuty klasy zmapowac jako atrybuty encji
@Data
@EqualsAndHashCode(of = "id")
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    protected Long id;

    @Version
    protected int version;
}



//Fabryka - tworzy w pamiei programu nowy agregat
//Agregat = encja+wartos
//Repozytorium - zapis agregatu w  bazie danych/ msc do przechowyania danych i do odczytywania danych z tamtego miejsca
//Modul - yizolowany fragment dziedizny zwiazany z agregatem, agtegat+wszystkie elementy z nim zwiazane
//Controller - jednoczesnie jest punktem wejscia do aplikacji poniewaz udostepnia w naszej aplikacji uslugi sieciowe


