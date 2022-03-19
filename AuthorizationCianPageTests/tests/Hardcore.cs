using AuthorizationCianPageTests.model;
using AuthorizationCianPageTests.page.cloudGooglePage;
using AuthorizationCianPageTests.page.cloudGooglePage.calculatorPageElements;
using AuthorizationCianPageTests.page.youpmailPage;
using AuthorizationCianPageTests.service;
using NUnit.Framework;
using System;


namespace AuthorizationCianPageTests.tests
{
    public class Hardcore : CommonConditions
    {
        [Test]
        public void PostPriceCheck()
        {
            Instances testDataInstances = InstancesCreator.GetParametersFromJson();
            EmailBlock emailGoogleCloudBlock = new MainPage(_driver)
                .OpenPage()
                .InvokeNewSearchRequest("Google Cloud Platform Pricing Calculator")
                .OpenPricingCalculatorLink()
                .ChooseComputeEngineElement()
                .putDataIntoInstancesBlock(testDataInstances)
                .ClickOnSendEstimationByEmail();
            tabManager.OpenNewTab();
            CheckingEmailPage checkingEmailPage = new YoupmailHomePage(_driver)
                .OpenPage()
                .GenerateRandomEmail()
                .OpenPost();
            string emailAddress = checkingEmailPage.GetEmailAddress();
            tabManager.SwitchToTab(1);
            String estimatedCost = emailGoogleCloudBlock
                .PutDataIntoEmailBlock(emailAddress)
                .SendEmail()
                .GetEstimatedCost();
            tabManager.SwitchToTab(2);
            string costFromLetter = checkingEmailPage.GetCost();
            tabManager.SwitchToTab(1);
            Assert.AreEqual(estimatedCost, costFromLetter);


        }
    }
}
