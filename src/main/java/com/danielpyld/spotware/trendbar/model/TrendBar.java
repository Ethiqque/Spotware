package com.danielpyld.spotware.trendbar.model;

import java.math.BigDecimal;
import java.time.Instant;

public record TrendBar(
        String symbol,
        BigDecimal openPrice,
        BigDecimal closePrice,
        BigDecimal highPrice,
        BigDecimal lowPrice,
        TbPeriodType periodType,
        Instant startTimestamp,
        Instant endTimestamp
) {

    public TrendBar {
        endTimestamp = startTimestamp.plus(1, periodType.getChronoUnit());
    }

    public static class Builder {
        private String symbol;
        private BigDecimal openPrice;
        private BigDecimal closePrice;
        private BigDecimal highPrice;
        private BigDecimal lowPrice;
        private TbPeriodType periodType;
        private Instant startTimestamp;

        public Builder symbol(String symbol) {
            this.symbol = symbol.toUpperCase();
            return this;
        }

        public Builder openPrice(BigDecimal openPrice) {
            this.openPrice = openPrice;
            return this;
        }

        public Builder closePrice(BigDecimal closePrice) {
            this.closePrice = closePrice;
            return this;
        }

        public Builder highPrice(BigDecimal highPrice) {
            this.highPrice = highPrice;
            return this;
        }

        public Builder lowPrice(BigDecimal lowPrice) {
            this.lowPrice = lowPrice;
            return this;
        }

        public Builder periodType(TbPeriodType periodType) {
            this.periodType = periodType;
            return this;
        }

        public Builder startTimestamp(Instant startTimestamp) {
            this.startTimestamp = startTimestamp;
            return this;
        }

        public TrendBar build() {

            return new TrendBar(symbol, openPrice, closePrice, highPrice, lowPrice, periodType, startTimestamp, null);
        }

    }

}
