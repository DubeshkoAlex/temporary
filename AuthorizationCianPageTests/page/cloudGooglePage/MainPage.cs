using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using OpenQA.Selenium.Support;
using System;

namespace AuthorizationCianPageTests.page.cloudGooglePage
{
    public class MainPage : AbstractElement
    {

        private readonly String PAGE_URL = "https://cloud.google.com/";
                
        private readonly By searchInputXpath = By.XPath("//input[@aria-label='Search']");
        public MainPage(IWebDriver driver) : base(driver) { }

        public MainPage OpenPage()
        {
            _driver.Navigate().GoToUrl(PAGE_URL);
            return this;
        }

        public ResultsSearchPage InvokeNewSearchRequest(string text)
        {
            new WebDriverWait(_driver, TimeSpan.FromSeconds(WAIT_TIMEOUT_SECONDS))
                .Until(_driver => _driver.FindElement(searchInputXpath).Displayed);
            IWebElement searchInput = _driver.FindElement(searchInputXpath);
            searchInput.Click();
            searchInput.SendKeys(text);
            searchInput.SendKeys(Keys.Enter);
            return new ResultsSearchPage(_driver);
        }

    }
}
