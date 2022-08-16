package com.epam.training.Matthew_Zhigalo.WebDriver.hard.service;

import com.epam.training.Matthew_Zhigalo.WebDriver.hard.model.TestModel;
import com.epam.training.Matthew_Zhigalo.WebDriver.hard.utils.PropertiesUtils;

public class CompletedTestModel {

    private static final String REGION = "test.region";
    private static final String COMMITTED_TERM = "test.commitment_term";
    private static final String VM_CLASS = "test.vm_class";
    private static final String INSTANCE_TYPE = "test.instance_type";
    private static final String SSD_SIZE = "test.ssd_size";
    private static final String ESTIMATED_COST = "test.estimated_cost";

    public static TestModel completeTestModel() {
        TestModel testModel = new TestModel();
        testModel.setRegion(PropertiesUtils.getData(REGION));
        testModel.setCommitmentTerm(PropertiesUtils.getData(COMMITTED_TERM));
        testModel.setVmClass(PropertiesUtils.getData(VM_CLASS));
        testModel.setInstanceType(PropertiesUtils.getData(INSTANCE_TYPE));
        testModel.setSsdSize(PropertiesUtils.getData(SSD_SIZE));
        testModel.setEstimatedCost(PropertiesUtils.getData(ESTIMATED_COST));
        return testModel;
    }

}
