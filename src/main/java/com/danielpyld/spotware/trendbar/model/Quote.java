package com.danielpyld.spotware.trendbar.model;

import java.math.BigDecimal;
import java.time.Instant;

public record Quote(
        BigDecimal newPrice,
        String symbol,
        Instant timestamp
) {
    public Quote {
        symbol = symbol.toUpperCase();
    }
}
