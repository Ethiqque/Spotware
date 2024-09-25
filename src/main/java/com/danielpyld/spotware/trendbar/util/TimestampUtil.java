package com.danielpyld.spotware.trendbar.util;

import com.danielpyld.spotware.trendbar.model.TbPeriodType;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TimestampUtil {


    public Instant roundByPeriod(Instant initialTTimestamp, TbPeriodType periodType) {

        return initialTTimestamp.truncatedTo(periodType.getChronoUnit());
    }
}
