import pytest

def test_addition():
	
	num1 = 14
	num2 = 15
    
	sum = num1 + num2

	assert sum == 29

@pytest.mark.activity
def test_subtraction():
  
	num1 = 64
	num2 = 55
    
	diff = num1 - num2

	assert diff == 9

@pytest.mark.activity
def test_multiplication():
  
	num1 = 9
	num2 = 5
    
	prod = num1 * num2

	assert prod == 45

def test_division():
  
	num1 = 81
	num2 = 9
    
	quot = num1 / num2

	assert quot == 9