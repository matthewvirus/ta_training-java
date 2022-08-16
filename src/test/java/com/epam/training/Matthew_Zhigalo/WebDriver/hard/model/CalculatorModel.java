package com.epam.training.Matthew_Zhigalo.WebDriver.hard.model;

import lombok.Data;

@Data
public class CalculatorModel {

    private String numberOfInstances;
    private String operatingSystem;
    private String vmClass;
    private String machineSeries;
    private String instanceType;
    private String gpuType;
    private String gpuNumber;
    private String ssdSize;
    private String region;
    private String committedUsage;

}