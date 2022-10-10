package com.soj.math.Service;


import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface MathService {

    List<Long> getMinNumbers(List<Long> numbers, double quantifier);
    List<Long> getMaxNumbers(List<Long> numbers, double quantifier);
    OptionalDouble getAverage(List<Long> numbers);
    OptionalDouble getMedian(List<Long> numbers);
    Long getPercentile(List<Long> numbers, double quantifier);
}
