using AuthorizationCianPageTests.driver;
using AuthorizationCianPageTests.utils;
using NUnit.Framework;
using OpenQA.Selenium;


namespace AuthorizationCianPageTests.tests
{
    [TestFixture]
    public class CommonConditions
    {
        protected WebDriver _driver;
        protected TabManager tabManager;
        
        [SetUp]
        public void Setup()
        {
            _driver = DriverSingleton.GetDriver();
            tabManager = new TabManager().InitTabManager();
        }

        [TearDown]
        public void StopBrowser()
        {
            DriverSingleton.closeDriver();
        }
    }
}
