using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AuthorizationCianPageTests.page.youpmailPage
{
    public class YoupmailHomePage : AbstractElement
    {
        private readonly string PAGE_URL = "https://yopmail.com/";
        private IWebElement emailRandomGenerate => _driver.FindElement(By.XPath("//div[@id='listeliens']/a[@href='email-generator']"));
        public YoupmailHomePage(IWebDriver driver) : base(driver) { }

        public YoupmailHomePage OpenPage()
        {
            _driver.Navigate().GoToUrl(PAGE_URL);
            return this;
        }

        public EmailGeneratedPage GenerateRandomEmail()
        {
            emailRandomGenerate.Click();
            return new EmailGeneratedPage(_driver);
        }

    }
}
