#Author: David Toledo
#Date: 07/04/2019
#Program: Sales Tax Application
#Language: Java
#Tools: Ubuntu 18.04, Visual Studio Code.

Remark:

The purpose of this App is to calcualte sales tax for items that are read from a txt file containing product details.
txt files are retrived from the current working directory where App.java resides.
the txt files are read line by line and are parsed to extract the required data for the App to calculate sales tax.

txt files are required to have the following format to successfuly be able to extract desired data.
qty[whitespace]description[whitespace]at[whitespace]cost

any number of files can be fed into this App as long as they are placed in the same directory as the App. It is not limited to 3 files.

## Option 1 Running all .txt files at once##

**How To Run (Ubuntu 18.04 "Linux")**
1. This App assumes you have Java Development Kit (JDK) installed.
2. From terminal navigate into SalesTax directory: 
	cd SalesTax
3. From terminal Execute script file "solution.bat":
	./solution.bat
	a. if script file cannot execute, make sure it is marked as executable, from terminal: 
		chmod +x solution
	b. solution script will compile and execute the App
	c. solution script will execute the App and pass all .txt filenames residing in the same directory as arguments to App.
4. terminal should display output.


**How To Run (Windows OS)**
1. This App assumes you have Java Development Kit (JDK) installed.
2. From command prompt "CMD" navigate into SalesTax directory: 
	cd SalesTax
3. From command prompt "CMD" execute script file "solution.bat":
	solution.bat
	a. solution script will execute the App and pass all .txt filenames residing in the same directory as arguments to App.
4. terminal should display output.

## Option 2 Running only user specified .txt files##
1. from CMD or Terminal Navigate into SalesTax folder
2. from CMD or Terminal, execute App and pass filenames as arguments
	a. java App file1.txt file2.txt etc...
		b. if App cannot execute, compile it first
			javac *.java, then repeat step a.
3. Program will display receipts only for those files provided by user.