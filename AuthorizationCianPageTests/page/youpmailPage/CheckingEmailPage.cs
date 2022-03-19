using AuthorizationCianPageTests.utils;
using OpenQA.Selenium;
using System.Collections.Generic;
using System.Linq;

namespace AuthorizationCianPageTests.page.youpmailPage
{
    public class CheckingEmailPage : AbstractElement
    {
        private IReadOnlyCollection<IWebElement> CostInTheLetter => _driver.FindElements(By.XPath("//table//td[4]"));
        private IWebElement emailAddress => _driver.FindElement(By.XPath("//div[@class='bname']"));
        public CheckingEmailPage(IWebDriver driver) : base(driver) { }

        public string GetEmailAddress() => emailAddress.Text; 

        public string GetCost()
        {
            int tryCount = 0;
            do
            {
                _driver.Navigate().Refresh();
                _driver.SwitchTo().Frame("ifmail");
                tryCount++;
            } while (CostInTheLetter.Count == 0 && tryCount < 5);
            return StringUtils.GetValue(CostInTheLetter.First(), @"((?<=USD\s)[\d,.]*)");
        }


    }
}
