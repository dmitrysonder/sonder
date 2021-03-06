import org.openqa.selenium.Dimension
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.safari.SafariDriver

baseUrl = 'http://madison.craigslist.org'

// default driver...
driver = { new FirefoxDriver() }

environments {
    // specify environment via -Dgeb.env=ie
    'ie' {
        def ieDriver = new File('src/test/resources/IEDriverServer.exe')
        System.setProperty('webdriver.ie.driver', ieDriver.absolutePath)
        driver = { new InternetExplorerDriver() }
    }

    'chrome' {
        def chromeDriver = new File('src/test/resources/chromedriver.exe')
        System.setProperty('webdriver.chrome.driver', chromeDriver.absolutePath)
        driver = { new ChromeDriver() }
    }

    'ff' {
        driver = { new FirefoxDriver() }
        //driver..manage().window().setSize(new Dimension(1028, 768))
    }

    'safari' {
        driver = { new SafariDriver() }
    }

}

reportsDir = "target/geb-reports"

waiting {
    timeout = 6
    retryInterval = 0.5
    slow { timeout = 12 }
    reallyslow { timeout = 24 }
}
