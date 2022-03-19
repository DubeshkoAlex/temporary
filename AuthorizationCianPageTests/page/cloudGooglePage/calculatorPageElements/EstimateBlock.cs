using AuthorizationCianPageTests.model;
using AuthorizationCianPageTests.utils;
using OpenQA.Selenium;
using System;
using System.Threading;

namespace AuthorizationCianPageTests.page.cloudGooglePage.calculatorPageElements
{
    public class EstimateBlock : AbstractElement
    {
        private const string divContains = "//div[contains(@class,'md-list-item-text') and contains(text(),";
        private IWebElement numberOfInstances => _driver.FindElement(By.XPath("//span[@class='ng-binding ng-scope']"));
        private IWebElement region => _driver.FindElement(By.XPath(divContains + "'Region')]"));
        private IWebElement commitmentTerm => _driver.FindElement(By.XPath(divContains + "'Commitment term')]"));
        private IWebElement vmClass => _driver.FindElement(By.XPath(divContains + "'VM class')]"));
        private IWebElement instanceType => _driver.FindElement(By.XPath(divContains + "'Instance type')]"));
        private IWebElement localSSD => _driver.FindElement(By.XPath(divContains + "'Local SSD')]"));
        private IWebElement cost => _driver.FindElement(By.XPath("//div[contains(@class,'md-list-item-text')]/b[contains(text(),'Cost')]"));
        private IWebElement emailEstimateButton => _driver.FindElement(By.XPath("//button[@aria-label='Email Estimate']"));

        public EstimateBlock(IWebDriver driver) : base(driver) { }

        public Instances getEstimatedInstancesWithRequiredFields()
        {
            Instances instances = new Instances();
            instances.NumberOfInstances = int.Parse(GetNumberOfInstances());
            instances.DataCenterLocation = GetRegion();
            instances.CommitedUsage = int.Parse(GetCommitmentTerm());
            instances.VmClass = GetVmClass();  
            instances.InstanceType = GetInstanceType();
            instances.LocalSSD = GetLocalSsd();
            return instances;
        }

        public string GetEstimatedCost() => GetCost();

        public EmailBlock ClickOnSendEstimationByEmail()
        {
            emailEstimateButton.Click();
            return new EmailBlock(_driver);
        }

        private string GetNumberOfInstances() => StringUtils.GetValue(numberOfInstances, @"(\d)");

        private string GetRegion() => StringUtils.GetValue(region, @"((?<=Region:\s)[A-z]*)");

        private string GetCommitmentTerm() => StringUtils.GetValue(commitmentTerm, @"((?<=Commitment term:\s)\d*)");

        private string GetVmClass() => StringUtils.GetValue(vmClass, @"((?<=VM class:\s)[A-z]*)");

        private string GetInstanceType() => StringUtils.GetValue(instanceType, @"((?<=Instance type:\s)[A-z\d\-]*)");

        private string GetLocalSsd() => StringUtils.GetValue(localSSD, @"((?<=Local SSD:\s)[A-z\d]*)");

        private string GetCost() => StringUtils.GetValue(cost, @"((?<=Estimated Component Cost: USD\s)[\d,.]*)");

    }
}
