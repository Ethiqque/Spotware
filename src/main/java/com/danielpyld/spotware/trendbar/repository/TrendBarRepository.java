package com.danielpyld.spotware.trendbar.repository;

import com.danielpyld.spotware.trendbar.model.TbHistory;
import com.danielpyld.spotware.trendbar.model.TbPeriodType;
import com.danielpyld.spotware.trendbar.model.TrendBar;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface TrendBarRepository {

    void saveTrendBar(TrendBar trendBar);
    void saveTrendBarList(List<TrendBar> trendBarList);
    Optional<TbHistory> getTbHistoryByPeriod(String symbol, TbPeriodType type, Instant from, Instant to);

}
