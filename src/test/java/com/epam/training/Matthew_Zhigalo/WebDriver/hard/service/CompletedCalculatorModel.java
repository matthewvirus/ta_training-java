package com.epam.training.Matthew_Zhigalo.WebDriver.hard.service;

import com.epam.training.Matthew_Zhigalo.WebDriver.hard.model.CalculatorModel;

public class CompletedCalculatorModel {

    private static final String NUMBER_OF_INSTANCES = "model.number_of_instances";
    private static final String OPERATING_SYSTEM = "model.operating_system";
    private static final String VM_CLASS = "model.vm_class";
    private static final String MACHINE_SERIES = "model.machine_series";
    private static final String INSTANCE_TYPE = "model.instance_type";
    private static final String GPU_TYPE = "model.gpu_type";
    private static final String GPU_NUMBER = "model.gpu_number";
    private static final String SSD_SIZE = "model.ssd_size";
    private static final String REGION = "model.region";
    private static final String COMMITTED_USAGE = "model.committed_usage";

    public static CalculatorModel completeCalculatorModel() {
        CalculatorModel calculatorModel = new CalculatorModel();
        calculatorModel.setNumberOfInstances(TestDataReader.getTestData(NUMBER_OF_INSTANCES));
        calculatorModel.setOperatingSystem(TestDataReader.getTestData(OPERATING_SYSTEM));
        calculatorModel.setVmClass(TestDataReader.getTestData(VM_CLASS));
        calculatorModel.setMachineSeries(TestDataReader.getTestData(MACHINE_SERIES));
        calculatorModel.setInstanceType(TestDataReader.getTestData(INSTANCE_TYPE));
        calculatorModel.setGpuType(TestDataReader.getTestData(GPU_TYPE));
        calculatorModel.setGpuNumber(TestDataReader.getTestData(GPU_NUMBER));
        calculatorModel.setSsdSize(TestDataReader.getTestData(SSD_SIZE));
        calculatorModel.setRegion(TestDataReader.getTestData(REGION));
        calculatorModel.setCommittedUsage(TestDataReader.getTestData(COMMITTED_USAGE));
        return calculatorModel;
    }

}
