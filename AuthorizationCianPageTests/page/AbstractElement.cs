using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Text;

namespace AuthorizationCianPageTests.page
{
    public abstract class AbstractElement
    {
        protected IWebDriver _driver;

        protected readonly int WAIT_TIMEOUT_SECONDS = 10;

        public AbstractElement(IWebDriver driver)
        {
            this._driver = driver;
        }
    }
}
