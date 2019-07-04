#Author: David Toledo
#Date: 07/04/2019
#Program: Sales Tax Application
#Language: Java
#Tools: Ubuntu 18.04, Visual Studio Code.
#Remark:

The purpose of this App is to calcualte sales tax for items that are read from a txt file containing product details.
txt files are retrived from the current working directory where App.java resides.
the txt files are read line by line and are parsed to extract the required data for the App to calculate sales tax.

txt files are required to have the following format to successfuly be able to extract desired data.
qty[whitespace]description[whitespace]at[whitespace]cost

any number of files can be fed into this App as long as they are placed in the same directory as the App. It is not limited to 3 files.

How To Run:
1. This App assumes you have Java Development Kit (JDK) with corresponsing compiler (javac) installed
2. From terminal navigate into SalesTax directory: cd SalesTax
3. Execute script file "solution", from terminal: ./solution
  a. if script file cannot execute, make sure it is marked as executable, from terminal: chmod +x solution
  b. solution script will compile the App.
  c. solution script will execute the App and pass all .txt files residing in the same directory as arguments.
4. terminal should display output.
