package ru.grsp.backend.model;

import org.javamoney.moneta.CurrencyUnitBuilder;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Buyout {

    private final UUID supplierId;
    private final Set<Order> orders;
    private CurrencyUnit rub;
    private MonetaryAmount amount;

    public Buyout(UUID supplierId, String currencyCode, MonetaryAmount amount) {
        this.supplierId = supplierId;
        this.orders = new HashSet<>();
        this.rub = Monetary.getCurrency(currencyCode);
        this.amount = Monetary.getDefaultAmountFactory().setCurrency(rub).setNumber(0).create();
    }
}
