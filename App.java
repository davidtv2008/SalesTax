/*
Author: David Toledo
Date: 07/04/2019
Program: Sales Taxes main App
Remark:
This app was created to read in txt files from
current working directory where App.java resides
and parse the lines from each file to extract qty, imported status
description and cost of an item.

Sales tax and imported tax will be calculated for each item
and a total tax and grand total will be displayed for each file

App can handle any number of .txt files that will contain item details
and is not limited to the 3 test files residing with this app
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public final class App {
    private App() {
    
    }
    public static void main(String[] args) {

        //receipt will hold all baskets created, where each basket represents each txt file
        ArrayList<Basket> receipt = new ArrayList<Basket>();

        //iterate through all txt files that have passed as arguments
        //all files with extension .txt will be passed using *.txt as the argument
        for(int i = 0; i < args.length; i++){

            Basket basket = new Basket();
            
            //read all files
            BufferedReader reader;
            try{
                
                //args contain txt file names
                reader = new BufferedReader(new FileReader(args[i]));
                String line = reader.readLine();
                while(line != null){

                    //create our items and pass each line of text to parse qty, description, and cost. also perform tax calculation
                    Item item = new Item(line);

                    //append each item to each basket
                    basket.add(item);

                    //continue reading each line
                    line = reader.readLine();
                }
            } catch(IOException e){
                e.printStackTrace();
            }

            //append each basket to receipt list
            receipt.add(basket);
        }

        //output all results from receipt
        for(int i = 0; i < receipt.size(); i++){
            
            //retrieve each basket from receipt
            Basket basket = receipt.get(i);

            for(int j = 0; j < basket.size(); j++){

                //retrieve each item from the basket
                Item item = basket.get(j);
                
                System.out.println(item.get_description());
            }

            //output totals with 2 decimal formatting
            System.out.println("Sales Taxes: " + String.format("%.02f",basket.get_tax_total()));
            System.out.println("Total: " + String.format("%.02f",basket.get_grand_total()) + "\n");
        }
    }
}