package com.soj.math.controller;

import com.soj.math.Service.MathService;
import com.soj.math.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.OptionalDouble;

@RestController
@RequestMapping("/soj/math")
public class MathController {

    @Autowired
    MathService mathService;


    @GetMapping("min/{quantifier}/{numbers}")
    public ResponseEntity<List<Long>> getMinNumbers(@PathVariable("numbers") List<Long> numbers, @PathVariable("quantifier") double quantifier){
        List<Long> minNumbers = mathService.getMinNumbers(numbers, quantifier);
        if(minNumbers.size() <= 0){
            throw new ResourceNotFoundException();
        }
        return new ResponseEntity<List<Long>>(minNumbers,HttpStatus.OK);
    }

    @GetMapping("max/{quantifier}/{numbers}")
    public ResponseEntity<List<Long>> getMaxNumbers(@PathVariable("numbers") List<Long> numbers, @PathVariable("quantifier") double quantifier){
        List<Long> maxNumbers = mathService.getMaxNumbers(numbers, quantifier);
        if(maxNumbers.size() <= 0){
            throw new ResourceNotFoundException();
        }
        return new ResponseEntity<List<Long>>(maxNumbers,HttpStatus.OK);
    }

    @GetMapping("avg/{numbers}")
    public ResponseEntity<OptionalDouble> getAverage(@PathVariable("numbers") List<Long> numbers){
        OptionalDouble average = mathService.getAverage(numbers);
        return new ResponseEntity<OptionalDouble>(average,HttpStatus.OK);
    }

    @GetMapping("median/{numbers}")
    public ResponseEntity<OptionalDouble> getMedian(@PathVariable("numbers") List<Long> numbers){
        OptionalDouble median = mathService.getMedian(numbers);
        return new ResponseEntity<OptionalDouble>(median,HttpStatus.OK);
    }

    @GetMapping("percentile/{quantifier}/{numbers}")
    public ResponseEntity<Long> getPercentile(@PathVariable("numbers") List<Long> numbers, @PathVariable("quantifier") double quantifier){
        Long percentile = mathService.getPercentile(numbers, quantifier);
        return new ResponseEntity<Long>(percentile,HttpStatus.OK);
    }

}
