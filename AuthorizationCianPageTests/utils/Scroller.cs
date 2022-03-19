using AuthorizationCianPageTests.driver;
using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using System;


namespace AuthorizationCianPageTests.utils
{
    public class Scroller
    {
        private readonly int WAIT_TIMEOUT_SECONDS = 10;
        private WebDriver _driver = DriverSingleton.GetDriver();

        public void ScrollToElement(By elementLocator)
        {
            new WebDriverWait(_driver, TimeSpan.FromSeconds(WAIT_TIMEOUT_SECONDS))
                   .Until(_driver => _driver.FindElement(elementLocator).Displayed);
            IWebElement element = _driver.FindElement(elementLocator);
            ((IJavaScriptExecutor)_driver).ExecuteScript("arguments[0].scrollIntoView(true);", element);
        }
        public void ScrollToElement(IWebElement element)
        {
            ((IJavaScriptExecutor)_driver).ExecuteScript("arguments[0].scrollIntoView(true);", element);
        }
    }
}
