package com.danielpyld.spotware.trendbar.util;

import com.danielpyld.spotware.trendbar.model.Quote;
import com.danielpyld.spotware.trendbar.model.TbPeriodType;
import com.danielpyld.spotware.trendbar.model.TrendBar;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TrendBarUtil {

    private final TimestampUtil timestampUtil;

    public TrendBarUtil(TimestampUtil timestampUtil) {
        this.timestampUtil = timestampUtil;
    }

    public TrendBar getNewTrendBarFromQuote(Quote quote, TbPeriodType periodType) {
        BigDecimal qtPrice = quote.newPrice();

        return new TrendBar.Builder()
                .symbol(quote.symbol())
                .openPrice(qtPrice).closePrice(qtPrice).highPrice(qtPrice).lowPrice(qtPrice)
                .periodType(periodType)
                .startTimestamp(timestampUtil.roundByPeriod(quote.timestamp(), periodType))
                .build();
    }

    public TrendBar copyWithUpdateLogic(TrendBar curTrendBar, Quote quote) {

        return new TrendBar.Builder()
                .periodType(curTrendBar.periodType())
                .symbol(curTrendBar.symbol())
                .openPrice(curTrendBar.openPrice())
                .closePrice(quote.newPrice())
                .lowPrice(curTrendBar.lowPrice().min(quote.newPrice()))
                .highPrice(curTrendBar.highPrice().max(quote.newPrice()))
                .startTimestamp(curTrendBar.startTimestamp())
                .build();
    }

}
