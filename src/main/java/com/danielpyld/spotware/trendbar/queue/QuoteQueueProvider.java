package com.danielpyld.spotware.trendbar.queue;

import com.danielpyld.spotware.trendbar.model.Quote;

import java.util.Optional;

public interface QuoteQueueProvider {

    void enqueue(Quote quote);
    Optional<Quote> dequeue();
    long size();
    boolean isEmpty();

}
