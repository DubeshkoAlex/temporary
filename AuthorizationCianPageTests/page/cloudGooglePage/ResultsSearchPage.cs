using OpenQA.Selenium;
using System.Collections.Generic;


namespace AuthorizationCianPageTests.page.cloudGooglePage
{
    public class ResultsSearchPage : AbstractElement
    {
        private IReadOnlyCollection<IWebElement> GoogleCloudPricingCalculatorLink => _driver.FindElements(By.XPath("//div[@class='gs-title']//b[text()='Google Cloud Pricing Calculator']"));

        public ResultsSearchPage(IWebDriver driver) : base(driver) { }

        public PricingCalculatorPage OpenPricingCalculatorLink()
        {
            int tryCount = 0;
            while (GoogleCloudPricingCalculatorLink.Count == 0 && tryCount < 5)
            {
                _driver.Manage().Cookies.DeleteAllCookies();
                _driver.Navigate().Refresh();
                tryCount++;
            }
            IList<IWebElement> googleCloudPricingCalculatorLinkFirst = new List<IWebElement>(GoogleCloudPricingCalculatorLink);
            googleCloudPricingCalculatorLinkFirst[0].Click();
            return new PricingCalculatorPage(_driver);
        }
    }
}
