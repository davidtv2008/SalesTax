/*
Author: David Toledo
Date: 07/04/2019
Program: Sales Taxes, Basket
*/

import java.util.ArrayList;

public class Basket{

    //use an array list container to hold all items
    private ArrayList<Item> basket;
    private Double sales_tax_total = 0.00;
    private Double grand_total = 0.00;

    //constructor
    Basket(){
        basket = new ArrayList<Item>();
    }

    public void add(Item item){

        //append items to our basket
        basket.add(item);

        //every time an item is added, update the sales_tax_total and grand total
        sales_tax_total += item.get_tax_amount();
        grand_total += item.get_item_total();

    }

    public void remove(int index){

        //every time an item is removed from the basket update costs
        Item item = basket.get(index);

        sales_tax_total -= item.get_tax_amount();
        grand_total -= item.get_item_total();

        //remove the item from the basket
        basket.remove(index);
    }

    public Item get(int index){
        return basket.get(index);
    }

    public Double get_tax_total(){
        
        return sales_tax_total;
    }

    public Double get_grand_total(){
        
        return grand_total;
    }

    public int size(){
        return basket.size();
    }
}
