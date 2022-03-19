using AuthorizationCianPageTests.utils;
using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AuthorizationCianPageTests.page.cloudGooglePage.calculatorPageElements
{
    public class EmailBlock : AbstractElement
    {
        private Scroller scroller = new();

        private IWebElement emailInput => _driver.FindElement(By.XPath("//input[contains(@ng-model,'user.email')]"));
        private IWebElement sendEmailButton => _driver.FindElement(By.XPath("//button[@aria-label='Send Email']"));

        public EmailBlock(IWebDriver driver) : base(driver) { }

        public EmailBlock PutDataIntoEmailBlock(string emailAddress)
        {
            _driver.SwitchTo().Frame(0).SwitchTo().Frame("myFrame");
            emailInput.SendKeys(emailAddress);
            return this;
        }

        public EstimateBlock SendEmail()
        {
            scroller.ScrollToElement(emailInput);
            sendEmailButton.Click();
            return new EstimateBlock(_driver);
        }

    }
}
