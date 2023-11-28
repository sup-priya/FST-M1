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

    Pagetitle = driver.title

    if Pagetitle == "SuiteCRM":
        # Print the title of the page
         print("Page title matches 'SuiteCRM' : ", driver.title)
    else:
         print("Page title does not match 'SuiteCRM' : ", driver.title)