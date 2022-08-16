package com.epam.training.Matthew_Zhigalo.WebDriver.hard.service;

import com.epam.training.Matthew_Zhigalo.WebDriver.hard.model.TestModel;

public class CompletedTestModel {

    private static final String REGION = "test.region";
    private static final String COMMITTED_TERM = "test.commitment_term";
    private static final String VM_CLASS = "test.vm_class";
    private static final String INSTANCE_TYPE = "test.instance_type";
    private static final String SSD_SIZE = "test.ssd_size";
    private static final String ESTIMATED_COST = "test.estimated_cost";

    public static TestModel completeTestModel() {
        TestModel testModel = new TestModel();
        testModel.setRegion(TestDataReader.getTestData(REGION));
        testModel.setCommitmentTerm(TestDataReader.getTestData(COMMITTED_TERM));
        testModel.setVmClass(TestDataReader.getTestData(VM_CLASS));
        testModel.setInstanceType(TestDataReader.getTestData(INSTANCE_TYPE));
        testModel.setSsdSize(TestDataReader.getTestData(SSD_SIZE));
        testModel.setEstimatedCost(TestDataReader.getTestData(ESTIMATED_COST));
        return testModel;
    }

}
