package ru.grsp.backend.model;

import lombok.Getter;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Buyout {

    @Getter
    private final UUID supplierId;
    @Getter
    private final Set<Order> orders;
    @Getter
    private CurrencyUnit rub;
    @Getter
    private MonetaryAmount amount;

    public Buyout(UUID supplierId, String currencyCode) {
        this.supplierId = supplierId;
        this.orders = new HashSet<>();
        this.rub = Monetary.getCurrency(currencyCode);
        this.amount = Monetary.getDefaultAmountFactory().setCurrency(rub).setNumber(0).create();
    }

}
