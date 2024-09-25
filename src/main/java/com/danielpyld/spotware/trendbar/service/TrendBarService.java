package com.danielpyld.spotware.trendbar.service;

import com.danielpyld.spotware.trendbar.model.Quote;
import com.danielpyld.spotware.trendbar.model.TbHistory;
import com.danielpyld.spotware.trendbar.model.TbPeriodType;

import java.time.Instant;

public interface TrendBarService {

    void updateTrendBar(Quote quote);
    TbHistory getTrendBarHistoryByPeriod(String symbol, TbPeriodType type, Instant from, Instant to);

}
