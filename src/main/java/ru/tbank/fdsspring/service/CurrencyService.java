package ru.tbank.fdsspring.service;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.tbank.fdsspring.model.Currency;
import ru.tbank.fdsspring.repository.ClientRepository;
import ru.tbank.fdsspring.repository.CurrencyRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

@Service
public class CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;

    public List<Currency> findAll(){
        return currencyRepository.findAll();
    }

    public Optional<Currency> findByID(Long id) {
        return currencyRepository.findById(id);
    }

    public Currency save(Currency currency) {
        return currencyRepository.save(currency);
    }

    public void deleteByID (Long id) {
        currencyRepository.deleteById(id);
    }

    public Currency update(Long id, Currency currency1) {
        Currency currency = currencyRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Not found"));
        currency.setName(currency1.getName());
        currency.setCode(currency1.getCode());
        return currencyRepository.save(currency);
    }
}
