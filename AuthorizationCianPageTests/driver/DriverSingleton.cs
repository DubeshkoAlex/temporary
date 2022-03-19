
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Edge;
using OpenQA.Selenium.Firefox;
using WebDriverManager;
using WebDriverManager.DriverConfigs.Impl;

namespace AuthorizationCianPageTests.driver
{
    public class DriverSingleton
    {

        private static WebDriver _driver;

        DriverSingleton() { }

        public static WebDriver GetDriver()
        {
            if (null == _driver)
            {
                switch ("edge") //System.Environment.GetEnvironmentVariable("browser")
                {
                    case "firefox":
                        {
                            new DriverManager().SetUpDriver(new FirefoxConfig());
                            _driver = new FirefoxDriver();
                            break;
                        }
                    case "edge":
                        {
                            new DriverManager().SetUpDriver(new EdgeConfig());
                            _driver = new EdgeDriver();
                            break;
                        }
                    default:
                        {
                            new DriverManager().SetUpDriver(new ChromeConfig());
                            _driver = new ChromeDriver();
                            break;
                        }
                }
                _driver.Manage().Window.Maximize();
            }
            return _driver;
        }

        public static void closeDriver()
        {
            _driver.Quit();
            _driver = null;
        }
    }
}
