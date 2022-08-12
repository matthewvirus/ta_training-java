package com.epam.training.Matthew_Zhigalo.WebDriver.hurt_me_plenty.page;

import com.epam.training.Matthew_Zhigalo.WebDriver.hurt_me_plenty.utils.DropdownUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {

    private final static String DROPDOWN_XPATH = "//div[contains(@class,'md-active')]//md-option/div[contains(text(),'%s')]";

    private final By wrapperFrameSelector = By.cssSelector("#cloud-site > devsite-iframe > iframe");
    private final By innerFrameSelector = By.cssSelector("#myFrame");
    private final By presetSelectionXpath = By.xpath("//div[contains(@title, 'Compute Engine')]");

    @FindBy (xpath = "//*[@id='input_87']")
    private WebElement numberOfInstancesTextField;
    @FindBy (css = "md-select[aria-label^='Operating System']")
    private WebElement operatingSystemSelectionDropdown;
    @FindBy (css = "md-select[aria-label^='VM Class']")
    private WebElement virtualMachineClassDropdown;
    @FindBy (css = "md-select[aria-label^='Series']")
    private WebElement machineSeriesDropdown;
    @FindBy (css = "md-select[aria-label^='Instance type']")
    private WebElement instanceTypeDropdown;
    @FindBy (css = "md-checkbox[aria-label^='Add GPUs']")
    private WebElement addGPUsCheckbox;
    @FindBy (css = "md-select[aria-label^='GPU type']")
    private WebElement typeOfGPUDropdown;
    @FindBy (css = "md-select[aria-label^='Number of GPUs']")
    private WebElement numberOfGPUsDropdown;
    @FindBy (css = "md-select[aria-label^='Local SSD']")
    private WebElement sizeOfSSDDropdown;
    @FindBy (css = "md-select[aria-label^='Datacenter location']")
    private WebElement datacenterLocationDropdown;
    @FindBy (css = "md-select[aria-label^='Committed usage']")
    private WebElement committedUsageDropdown;
    @FindBy (css = "button[aria-label^='Add to Estimate']")
    private WebElement addToEstimateButton;
    @FindBy (xpath = "//*[@id='compute']/md-list/md-list-item/div[contains(text(),'Region')]")
    private WebElement regionResultTextArea;
    @FindBy (xpath = "//*[@id='compute']/md-list/md-list-item/div[contains(text(),'Commitment term')]")
    private WebElement commitmentTermTextArea;
    @FindBy (xpath = "//*[@id='compute']/md-list/md-list-item/div[contains(text(),'Provisioning model')]")
    private WebElement classOfVMTextArea;
    @FindBy (xpath = "//*[@id='compute']/md-list/md-list-item/div[contains(text(),'Instance type')]")
    private WebElement instanceTypeTextArea;
    @FindBy (xpath = "//*[@id='compute']/md-list/md-list-item/div[contains(text(),'Local SSD')]")
    private WebElement localSSDTextArea;
    @FindBy (css = ".md-title > b")
    private WebElement totalEstimatedCost;

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingCalculatorPage addToEstimate() {
        switchTo(wrapperFrameSelector)
                .switchTo(innerFrameSelector)
                .selectPresetType()
                .inputNumberOfInstances("4")
                .chooseOperatingSystem("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)")
                .chooseVMClass("Regular")
                .chooseMachineSeries("N1")
                .chooseInstanceType("n1-standard-8 (vCPUs: 8, RAM: 30GB)")
                .selectAddGPUsCheckbox()
                .chooseGPUType("NVIDIA Tesla T4")
                .chooseNumberOfGPUs("1")
                .chooseLocalSSDSize("2x375 GB")
                .chooseDatacenterLocation("Frankfurt (europe-west3)")
                .chooseCommittedUsage("1 Year")
                .pressAddToEstimateButton();
        return this;
    }

    private GoogleCloudPricingCalculatorPage switchTo(By selector) {
        driver.switchTo()
                .frame(webDriverWait()
                        .until(ExpectedConditions
                                .presenceOfElementLocated(selector)));
        return this;
    }

    private GoogleCloudPricingCalculatorPage selectPresetType() {
        webDriverWait()
                .until(ExpectedConditions.presenceOfElementLocated(presetSelectionXpath))
                .click();
        return this;
    }

    private GoogleCloudPricingCalculatorPage inputNumberOfInstances(String numberOfInstances) {
        numberOfInstancesTextField.sendKeys(numberOfInstances);
        return this;
    }

    private GoogleCloudPricingCalculatorPage chooseOperatingSystem(String operatingSystem) {
        operatingSystemSelectionDropdown.click();
        DropdownUtils.clickOnDropdownListElement(String.format(DROPDOWN_XPATH, operatingSystem));
        return this;
    }

    private GoogleCloudPricingCalculatorPage chooseVMClass(String virtualMachineClass) {
        virtualMachineClassDropdown.click();
        DropdownUtils.clickOnDropdownListElement(String.format(DROPDOWN_XPATH, virtualMachineClass));
        return this;
    }

    private GoogleCloudPricingCalculatorPage chooseMachineSeries(String machineSeries) {
        machineSeriesDropdown.click();
        DropdownUtils.clickOnDropdownListElement(String.format(DROPDOWN_XPATH, machineSeries));
        return this;
    }

    private GoogleCloudPricingCalculatorPage chooseInstanceType(String instanceType) {
        instanceTypeDropdown.click();
        DropdownUtils.clickOnDropdownListElement(String.format(DROPDOWN_XPATH, instanceType));
        return this;
    }

    private GoogleCloudPricingCalculatorPage selectAddGPUsCheckbox() {
        addGPUsCheckbox.click();
        return this;
    }

    private GoogleCloudPricingCalculatorPage chooseGPUType(String typeOfGPU) {
        typeOfGPUDropdown.click();
        DropdownUtils.clickOnDropdownListElement(String.format(DROPDOWN_XPATH, typeOfGPU));
        return this;
    }

    private GoogleCloudPricingCalculatorPage chooseNumberOfGPUs(String numberOfGPUs) {
        numberOfGPUsDropdown.click();
        DropdownUtils.clickOnDropdownListElement(String.format(DROPDOWN_XPATH, numberOfGPUs));
        return this;
    }

    private GoogleCloudPricingCalculatorPage chooseLocalSSDSize(String sizeOfSSD) {
        sizeOfSSDDropdown.click();
        DropdownUtils.clickOnDropdownListElement(String.format(DROPDOWN_XPATH, sizeOfSSD));
        return this;
    }

    private GoogleCloudPricingCalculatorPage chooseDatacenterLocation(String datacenterLocation) {
        datacenterLocationDropdown.click();
        DropdownUtils.clickOnDropdownListElement(String.format(DROPDOWN_XPATH, datacenterLocation));
        return this;
    }

    private GoogleCloudPricingCalculatorPage chooseCommittedUsage(String committedUsage) {
        committedUsageDropdown.click();
        DropdownUtils.clickOnDropdownListElement(String.format(DROPDOWN_XPATH, committedUsage));
        return this;
    }

    private void pressAddToEstimateButton() {
        addToEstimateButton.click();
        webDriverWait()
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector("#resultBlock")));
    }

    public String getRegion() {
        return regionResultTextArea.getText();
    }

    public String getCommitmentTerm() {
        return commitmentTermTextArea.getText();
    }

    public String getClassOfVM() {
        return classOfVMTextArea.getText();
    }

    public String getInstanceType() {
        return instanceTypeTextArea.getText();
    }

    public String getLocalSSDSize() {
        return localSSDTextArea.getText();
    }

    public String getTotalEstimatedCost() {
        return totalEstimatedCost.getText();
    }

    @Override
    protected GoogleCloudPricingCalculatorPage openPage() {
        System.out.println("Opened Google Cloud Pricing Calculator page.");
        return this;
    }

}