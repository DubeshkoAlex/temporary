using AuthorizationCianPageTests.driver;
using OpenQA.Selenium;
using System.Collections.Generic;

namespace AuthorizationCianPageTests.utils
{
    public class TabManager
    {
        private static Dictionary<int, string> tabs;
        private static readonly IWebDriver _driver = DriverSingleton.GetDriver();

        public TabManager() { }

        public TabManager InitTabManager()
        {
            if(null == tabs)
            {
                tabs = new Dictionary<int, string>();
                tabs.Add(1, _driver.CurrentWindowHandle);
            }
            return this;
        }

        public void SwitchToTab(int tabNumber) { _driver.SwitchTo().Window(tabs[tabNumber]); }

        public void OpenNewTab()
        {
            ((IJavaScriptExecutor)_driver).ExecuteScript("window.open()");
            List<string> currentWindowsList = new List<string>(_driver.WindowHandles);
            foreach (string tab in tabs.Values)
            {
                currentWindowsList.Remove(tab);
            }
            tabs.Add(tabs.Count + 1, new List<string>(currentWindowsList)[0]);
            SwitchToTab(tabs.Count);
        }
    }
}
