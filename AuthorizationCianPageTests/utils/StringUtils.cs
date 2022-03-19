using OpenQA.Selenium;
using System.Text;
using System.Text.RegularExpressions;

namespace AuthorizationCianPageTests.utils
{
    public class StringUtils
    {

        public static string GetValue(IWebElement element, string pattern)
        {
            StringBuilder actualValue = new StringBuilder();

            Regex regex = new Regex(pattern);
            Match match = regex.Match(element.Text);

            while (match.Success)
            {
                actualValue.Append(match.Groups[1].Value);
                match = match.NextMatch();
            }
            return actualValue.ToString();
        }

    }
}
