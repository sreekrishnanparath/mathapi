package com.soj.math.Service;

import com.soj.math.dao.MathDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;

@Service
public class MathServiceImpl implements MathService {

    @Autowired
    MathDao mathDao;

    @Override
    public List<Long> getMinNumbers(List<Long> numbers, double quantifier) {
        return mathDao.getMinNumbers(numbers, quantifier);
    }

    @Override
    public List<Long> getMaxNumbers(List<Long> numbers, double quantifier) {
        return mathDao.getMaxNumbers(numbers, quantifier);
    }

    @Override
    public OptionalDouble getAverage(List<Long> numbers) {
        return mathDao.getAverage(numbers);
    }

    @Override
    public OptionalDouble getMedian(List<Long> numbers) {
        return mathDao.getMedian(numbers);
    }

    @Override
    public Long getPercentile(List<Long> numbers, double quantifier) {
        return mathDao.getPercentile(numbers, quantifier);
    }
}
