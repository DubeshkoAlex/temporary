using AuthorizationCianPageTests.page.cloudGooglePage.calculatorPageElements;
using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AuthorizationCianPageTests.page.cloudGooglePage
{
    public class PricingCalculatorPage : AbstractElement
    {

        private IWebElement computeEngineElement => _driver.FindElement(By.XPath("//div[@title='Compute Engine']/parent::md-tab-item"));

        public PricingCalculatorPage(IWebDriver driver) : base(driver) { }
        
        private PricingCalculatorPage SwitchToMyFrame()
        {
            _driver.SwitchTo().Frame(0).SwitchTo().Frame("myFrame");
            return this;
        }
        
        public InstancesBlock ChooseComputeEngineElement()
        {
            SwitchToMyFrame();
            computeEngineElement.Click();
            return new InstancesBlock(_driver);
        }
        
    }
}
