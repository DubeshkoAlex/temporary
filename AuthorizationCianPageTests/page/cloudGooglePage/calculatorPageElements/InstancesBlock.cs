using AuthorizationCianPageTests.model;
using AuthorizationCianPageTests.utils;
using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AuthorizationCianPageTests.page.cloudGooglePage.calculatorPageElements
{
    public class InstancesBlock : AbstractElement
    {
        private readonly Scroller scroller = new();
        private IWebElement NumberOfInstances => _driver.FindElement(By.XPath("//input[contains(@ng-model,'computeServer.quantity')]"));
        private IWebElement AddGPUs => _driver.FindElement(By.XPath("//md-checkbox[contains(@ng-model,'computeServer.addGPUs')]"));
        private IWebElement AddToEstimate => _driver.FindElement(By.XPath("//button[contains(@ng-click,'addComputeServer(ComputeEngineForm)')]"));

        private const string mdSelect = "//md-select[contains(@ng-model,'computeServer.";

        private readonly By operationSystemSoftwareMenuLocator = By.XPath(mdSelect + "os')]");
        private readonly By vmClassLocator = By.XPath(mdSelect + "class')]");
        private readonly By seriesLocator = By.XPath(mdSelect + "series')]");
        private readonly By instanceTypeLocator = By.XPath(mdSelect + "instance')]");
        private readonly By gpuTypeLocator = By.XPath(mdSelect + "gpuType')]");
        private readonly By gpuNumberLocator = By.XPath(mdSelect + "gpuCount')]");
        private readonly By localSsdLocator = By.XPath(mdSelect + "ssd')]");
        private readonly By dataCenterLocationLocator = By.XPath(mdSelect + "location')]");
        private readonly By committedUsageLocator = By.XPath(mdSelect + "cud')]");

        private static readonly string OS_OPTION_XPATH = "//div[contains(text(),'{0}')]/parent::md-option";
        private static readonly string VM_OPTION_XPATH = "//md-select-menu[@style]//div[contains(text(),'{0}')]";
        private static readonly string SERIES_OPTION_XPATH = "//md-option[contains(@ng-repeat,'computeServer.family')]/div[contains(text(),'{0}')]";
        private static readonly string INSTANCE_TYPE_XPATH = "//md-option[contains(@ng-repeat,'instance in typeInfo')]/div[contains(text(),'{0}')]";
        private static readonly string GPU_TYPE_OPTION_XPATH = "//md-option[contains(@ng-repeat,'gpuList')]/div[contains(text(),'{0}')]";
        private static readonly string GPU_NUMBER_OPTION_XPATH = "//md-option[contains(@ng-repeat,'supportedGpuNumbers')]/div[contains(text(),'{0}')]";
        private static readonly string LOCAL_SSD_OPTION_XPATH = "//md-option[contains(@ng-repeat,'dynamicSsd')]/div[contains(text(),'{0}')]";
        private static readonly string DATA_CENTER_LOCATION_XPATH = "//md-option[contains(@ng-repeat,'inputRegionText.computeServer')]/div[contains(text(),'{0}')]";
        private static readonly string COMMITTED_USAGE_OPTION_XPATH = "//div[contains(@class,'md-active')]//md-option[@value='{0}']";

        public InstancesBlock(IWebDriver driver) : base(driver) { }

        public EstimateBlock putDataIntoInstancesBlock(Instances instances)
        {
            PutInstancesNumber(instances.NumberOfInstances);
            ChooseOsOption(instances.OperatingSystem);
            ChooseVMOption(instances.VmClass);
            scroller.ScrollToElement(operationSystemSoftwareMenuLocator);
            ChooseSeriesOption(instances.Series);
            ChooseInstanceType(instances.InstanceType);
            ClickOnAddGPUs();
            ChooseGpuType(instances.GpuType);
            ChooseGpuNumber(Convert.ToString(instances.GpuNumbers));
            scroller.ScrollToElement(gpuNumberLocator);
            ChooseLocalSsd(instances.LocalSSD);
            ChooseDataCenterLocation(instances.DataCenterLocation);
            ChooseCommittedUsage(Convert.ToString(instances.CommitedUsage));
            ClickOnAddToEstimate();
            return new EstimateBlock(_driver);
        }
        private InstancesBlock PutInstancesNumber(int number)
        {
            NumberOfInstances.SendKeys(Convert.ToString(number));
            return this;
        }

        private InstancesBlock ChooseMenu(By menuLocator, By optionLocator)
        {
            new WebDriverWait(_driver, TimeSpan.FromSeconds(WAIT_TIMEOUT_SECONDS))
                    .Until(_driver => _driver.FindElement(menuLocator).Displayed);
            IWebElement menu = _driver.FindElement(menuLocator);
            menu.Click();
            new WebDriverWait(_driver, TimeSpan.FromSeconds(WAIT_TIMEOUT_SECONDS))
                    .Until(_driver => _driver.FindElement(optionLocator).Displayed);
            IWebElement option = _driver.FindElement(optionLocator);
            option.Click();
            return this;
        }

        private InstancesBlock ChooseOsOption(string osOptionName)
        {
            By osOptionsLocator = By.XPath(string.Format(OS_OPTION_XPATH,osOptionName));
            ChooseMenu(operationSystemSoftwareMenuLocator, osOptionsLocator);
            return this;
        }

        private InstancesBlock ChooseVMOption(string vmOptionName)
        {
            By vmOptionsLocator = By.XPath(string.Format(VM_OPTION_XPATH, vmOptionName));
            ChooseMenu(vmClassLocator,vmOptionsLocator);
            return this;
        }

        private InstancesBlock ChooseSeriesOption(string seriesOptionName)
        {
            By seriesOptionsLocator = By.XPath(string.Format(SERIES_OPTION_XPATH, seriesOptionName));
            ChooseMenu(seriesLocator, seriesOptionsLocator);
            return this;
        }

        private InstancesBlock ChooseInstanceType(string instanceTypeOptionName)
        {
            By instanceTypeOptionsLocator = By.XPath(string.Format(INSTANCE_TYPE_XPATH, instanceTypeOptionName));
            ChooseMenu(instanceTypeLocator, instanceTypeOptionsLocator);
            return this;
        }

        private InstancesBlock ClickOnAddGPUs()
        {
            AddGPUs.Click();
            return this;
        }

        private InstancesBlock ChooseGpuType(String gpuTypeOptionName)
        {
            By gpuTypeOptionsLocator = By.XPath(String.Format(GPU_TYPE_OPTION_XPATH, gpuTypeOptionName));
            ChooseMenu(gpuTypeLocator, gpuTypeOptionsLocator);
            return this;
        }

        private InstancesBlock ChooseGpuNumber(String gpuNumberOptionName)
        {
            By gpuNumberOptionsLocator = By.XPath(String.Format(GPU_NUMBER_OPTION_XPATH, gpuNumberOptionName));
            ChooseMenu(gpuNumberLocator, gpuNumberOptionsLocator);
            return this;
        }

        private InstancesBlock ChooseLocalSsd(String localSsdOptionName)
        {
            By localSsdOptionsLocator = By.XPath(String.Format(LOCAL_SSD_OPTION_XPATH, localSsdOptionName));
            ChooseMenu(localSsdLocator, localSsdOptionsLocator);
            return this;
        }

        private InstancesBlock ChooseDataCenterLocation(String dataCenterLocationOptionName)
        {
            By dataCenterLocationOptionsLocator = By.XPath(String.Format(DATA_CENTER_LOCATION_XPATH, dataCenterLocationOptionName));
            ChooseMenu(dataCenterLocationLocator, dataCenterLocationOptionsLocator);
            return this;
        }

        private InstancesBlock ChooseCommittedUsage(String committedUsageOptionName)
        {
            By committedUsageOptionsLocator = By.XPath(String.Format(COMMITTED_USAGE_OPTION_XPATH, committedUsageOptionName));
            ChooseMenu(committedUsageLocator, committedUsageOptionsLocator);
            return this;
        }

        private InstancesBlock ClickOnAddToEstimate()
        {
            AddToEstimate.Click();
            return this;
        }

    }
}
