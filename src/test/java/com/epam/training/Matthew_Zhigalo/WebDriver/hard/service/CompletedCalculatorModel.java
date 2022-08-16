package com.epam.training.Matthew_Zhigalo.WebDriver.hard.service;

import com.epam.training.Matthew_Zhigalo.WebDriver.hard.model.CalculatorModel;
import com.epam.training.Matthew_Zhigalo.WebDriver.hard.utils.PropertiesUtils;

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
        calculatorModel.setNumberOfInstances(PropertiesUtils.getData(NUMBER_OF_INSTANCES));
        calculatorModel.setOperatingSystem(PropertiesUtils.getData(OPERATING_SYSTEM));
        calculatorModel.setVmClass(PropertiesUtils.getData(VM_CLASS));
        calculatorModel.setMachineSeries(PropertiesUtils.getData(MACHINE_SERIES));
        calculatorModel.setInstanceType(PropertiesUtils.getData(INSTANCE_TYPE));
        calculatorModel.setGpuType(PropertiesUtils.getData(GPU_TYPE));
        calculatorModel.setGpuNumber(PropertiesUtils.getData(GPU_NUMBER));
        calculatorModel.setSsdSize(PropertiesUtils.getData(SSD_SIZE));
        calculatorModel.setRegion(PropertiesUtils.getData(REGION));
        calculatorModel.setCommittedUsage(PropertiesUtils.getData(COMMITTED_USAGE));
        return calculatorModel;
    }

}
