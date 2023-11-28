# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

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

    toolbar = driver.find_element(By.ID, "grouptab_0")
    toolbar.click
    
    toolbar1 = driver.find_element(By.ID, "moduleTab_9_Leads")
    toolbar1.click

    toolbar2 = driver.find_element(By.XPATH, "//table/tbody/tr[1]/td[10]/*")
    toolbar2.click  

    for i in range(10):
        toolbar3 = driver.find_element(By.XPATH, "//table/tbody/tr[" + i + "]/td[3]/b/a")
        print("Row name is : ", toolbar3.text)

        toolbar4 = driver.find_element(By.XPATH, "//table/tbody/tr["+ i + "]/td[8]/a")
        print("Row user is : ", toolbar4.text)