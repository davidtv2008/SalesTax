/*
Author: David Toledo
Date: 07/04/2019
Program: Sales Taxes Item
*/

class Item {

    //properties of Item
    private int qty = 0;
    private String description = null;
    private Double cost = 0.00;
    private Double total_cost = 0.00;
    private Double sales_tax = 0.00;
    private double sales_tax_amount = 0.00;
    private double imported_tax = 0.00;
    private double imported_tax_amount = 0.00;
    private boolean imported = false;
    private boolean exempt = false;

    //string to parse and separate
    private String item_details;

    //constructor
    //upon creating this object, pass from the txt file string containing item details
    Item(String item_details){

        this.item_details = item_details;

        parseText();

        set_imported_tax();

        set_sales_tax();

        set_total_cost();
    }

    private void parseText(){

        //extract the item description only
        int desc_start_index = item_details.indexOf(" ") + 1;
        int desc_end_index = item_details.indexOf(" at");

        description = item_details.substring(desc_start_index,desc_end_index) + ": ";

        //extract the qty from the text, locate the first occurrence of a whitespace as end index
        int qty_start_index = 0;
        int qty_end_index = item_details.indexOf(" ");

        qty = Integer.parseInt(item_details.substring(qty_start_index,qty_end_index));

        //extract the cost from the text, locate " at " and add to index + 3
        int cost_start_index = item_details.indexOf(" at ") + 3;
        int cost_end_index = item_details.length();

        cost = Double.parseDouble(item_details.substring(cost_start_index,cost_end_index));
        
        //determine if item is an imported item
        imported = item_details.contains("imported");

        //determine if item is exempt from sales tax, from three types
        String[] exempt_items = {"book","chocolate","pills"};

        //iterate all 3 categories and end loop if exempt item found
        for(int i = 0; i < exempt_items.length; i++){
            if(item_details.contains(exempt_items[i])){
                exempt = true;
                break;
            }
        }
    }

    private void set_imported_tax(){

        //add a 5% tax if is imported, otherwise 0%
        if(imported){
            imported_tax = 5.00;

        }else{

            imported_tax = 0.00;
        }

        //calculate the imported tax amount
        imported_tax_amount = (cost * imported_tax) / 100;

        //round to nearest 0.05
        imported_tax_amount = Math.ceil(imported_tax_amount * 20.00) / 20.00;
    }

    private void set_sales_tax(){

        //add 10% sales tax to items not exempt
        if(exempt){
            sales_tax = 0.00;
        }
        else{
            sales_tax = 10.00;
        }

        //calculate the sales tax amount
        sales_tax_amount = (cost * sales_tax) / 100;

        //round to nearest 0.05
        sales_tax_amount = Math.ceil((sales_tax_amount * 20.00)) / 20.00;
    }

    private void set_total_cost(){
        
        //keep 2 decimal places
        total_cost = Math.round((cost + imported_tax_amount + sales_tax_amount) * 100) / 100.0;
    }

    public Double get_tax_amount(){

        return sales_tax_amount + imported_tax_amount;
    }

    public Double get_imported_amount(){

        return imported_tax_amount;
    }

    public Double get_item_total(){
        
        return total_cost;
    }

    public String get_description(){
        return qty + " " + description + String.format("%.02f", total_cost);
    }
}