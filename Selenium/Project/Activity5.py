# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.ui import WebDriverWait

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:

    # Navigate to the URL
    driver.get("http://alchemy.hguy.co/crm")
   
    # Find the username field
    username = driver.find_element(By.ID, "user_name")
    # Find the password field
    password = driver.find_element(By.ID, "username_password")

    # Enter the given credentials
    # Enter username
    username.send_keys("admin")
    # Enter password
    password.send_keys("pa$$w0rd")

    # Find the login button
    login = driver.find_element(By.XPATH, "//*[@id='bigbutton']")
    login.click()

    wait = WebDriverWait(driver, 60)

    toolbar = driver.find_element(By.XPATH, "//*[@id='ygddfdiv']")
    print("Toolbar colour is : ", toolbar.value_of_css_property('color'))