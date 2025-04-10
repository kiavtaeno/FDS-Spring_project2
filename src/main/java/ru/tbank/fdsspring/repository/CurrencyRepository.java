package ru.tbank.fdsspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tbank.fdsspring.model.Currency;


public interface CurrencyRepository extends JpaRepository<Currency, Long> {

}
