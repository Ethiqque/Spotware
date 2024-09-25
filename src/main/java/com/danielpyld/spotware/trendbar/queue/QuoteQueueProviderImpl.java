package com.danielpyld.spotware.trendbar.queue;

import com.danielpyld.spotware.trendbar.model.Quote;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Component
@Primary
public class QuoteQueueProviderImpl implements QuoteQueueProvider {

    private final Queue<Quote> queue;

    public QuoteQueueProviderImpl() {
        queue = new ConcurrentLinkedQueue<>();
    }

    @Override
    public void enqueue(Quote quote) {
        queue.offer(quote);
    }

    @Override
    public Optional<Quote> dequeue() {

        return Optional.ofNullable(queue.poll());
    }

    @Override
    public long size() {

        return queue.size();
    }

    @Override
    public boolean isEmpty() {

        return queue.isEmpty();
    }

}
