package com.soj.math.dao;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Component
public class MathDao {




    public List<Long> getMinNumbers(List<Long> numbers, double quantifier)
    {
        Predicate<Long> minPredicate = (number) -> number < quantifier;
        return numbers.stream()
                .filter(minPredicate)
                .collect(Collectors.toList());

    }

    public List<Long> getMaxNumbers(List<Long> numbers, double quantifier)
    {
        Predicate<Long> maxPredicate = (number) -> number > quantifier;
        return numbers.stream()
                .filter(maxPredicate)
                .collect(Collectors.toList());

    }

    public OptionalDouble getAverage(List<Long> numbers)
    {
        return numbers.stream()
                .mapToInt(Math::toIntExact)
                .average();

    }

    public OptionalDouble getMedian(List<Long> numbers)
    {
        DoubleStream sortedNumbers = numbers.stream()  // DoubleStream sorted
                .mapToDouble(v -> v)
                .sorted();

        return  (
            numbers.size() % 2 == 0 ?
                    sortedNumbers.skip((numbers.size() / 2) - 1)
                            .limit(2)
                            .average() :
                    sortedNumbers.skip(numbers.size() / 2)
                            .findFirst()
                );

    }

    public Long getPercentile(List<Long> numbers, double quantifier)
    {
        int index = (int) Math.ceil(quantifier / 100.0 * numbers.size());
        return numbers.get(index-1);
    }



}
