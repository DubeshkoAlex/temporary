using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AuthorizationCianPageTests.page.youpmailPage
{
    public class EmailGeneratedPage : AbstractElement
    {
        private IWebElement checkEmail => _driver.FindElement(By.XPath("//button[@onclick=\"egengo();\"]"));
        public EmailGeneratedPage(IWebDriver driver) : base(driver) { }

        public CheckingEmailPage OpenPost()
        {
            checkEmail.Click();
            return new CheckingEmailPage(_driver);
        }
    }
}
