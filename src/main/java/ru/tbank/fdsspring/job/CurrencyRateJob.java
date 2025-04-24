package ru.tbank.fdsspring.job;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.tbank.fdsspring.model.Currency;
import ru.tbank.fdsspring.model.CurrencyRateDto;
import ru.tbank.fdsspring.service.CbrClient;
import ru.tbank.fdsspring.service.CurrencyService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CurrencyRateJob {

    private final CbrClient cbrClient;
    private final CurrencyService currencyService;

    //@Scheduled(cron = "0 0 * * *")
    @Scheduled(cron = "*/15 * * * * *")
    public void fetchAndPrintRates() {
        List<CurrencyRateDto> rates = cbrClient.fetchRates();
        rates.forEach(System.out::println);
        List<Currency> myCurrencies = currencyService.findAll();
        for(Currency currency: myCurrencies) {
            CurrencyRateDto x = rates.stream().filter(e -> e.getCode().equalsIgnoreCase(currency.getCode())).findFirst().orElse(null);
            if(x != null) {
                if(Math.abs((x.getValue() - x.getPrevious()) / x.getPrevious()) * 100 >= currency.getPriceChangeRange()) {
                    System.out.println(currency.getDescription());
                }
            }
        }
    }
}