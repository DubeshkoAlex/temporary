using AuthorizationCianPageTests.driver;
using AuthorizationCianPageTests.model;
using AuthorizationCianPageTests.page.cloudGooglePage;
using AuthorizationCianPageTests.service;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Edge;
using System;
using System.Threading;
using WebDriverManager;
using WebDriverManager.DriverConfigs.Impl;

namespace AuthorizationCianPageTests.tests
{
    
    public class HurtMePlentyTest : CommonConditions
    {

        [Test]
        public void CheckFieldsData()
        {
            Instances testDataInstances = InstancesCreator.GetParametersFromJson();
            Instances actualInstances = new MainPage(_driver)
                                            .OpenPage()
                                            .InvokeNewSearchRequest("Google Cloud Platform Pricing Calculator")
                                            .OpenPricingCalculatorLink()
                                            .ChooseComputeEngineElement()
                                            .putDataIntoInstancesBlock(testDataInstances)
                                            .getEstimatedInstancesWithRequiredFields();
             Assert.True(testDataInstances.EqualsBySmokeTestParam(actualInstances));
        }
        
        [Test]
        public void PriceCheck()
        {
            Instances testDataInstances = InstancesCreator.GetParametersFromJson();
            string actualCost = new MainPage(_driver)
                .OpenPage()
                .InvokeNewSearchRequest("Google Cloud Platform Pricing Calculator")
                .OpenPricingCalculatorLink()
                .ChooseComputeEngineElement()
                .putDataIntoInstancesBlock(testDataInstances)
                .GetEstimatedCost();
            Assert.AreEqual(actualCost, "1,082.77");
        }

    }
}
