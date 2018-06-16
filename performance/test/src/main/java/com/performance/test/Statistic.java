package com.performance.test;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class Statistic {
    private final HashMap<Class, HashMap<String,List<Long>>> performanceArray;
    public Statistic() {
        this.performanceArray = new HashMap<>();
    }

    public void register(Class clazz) {
        HashMap<String, List<Long>> data = new HashMap<>();
        data.put("insert", new ArrayList<>());
        data.put("select", new ArrayList<>());
        performanceArray.put(clazz, data);
    }

    public void addVal(Class clazz, String mehtod, Long time) {
        performanceArray.get(clazz).get(mehtod).add(time);
    }

    public void printResult() {
        performanceArray.keySet().forEach(
                key -> {
                    performanceArray.get(key).keySet().forEach(key1 -> {
                        System.out.println(key + "," + key1 + " "
                        + performanceArray.get(key).get(key1).stream().reduce((x,y) -> x+y));
                    });
                }
        );
    }

}
