public class Product {
    private int productID;
    private String name;
    private int price;

    public Product(int productID, String name, int price){
        this.productID = productID;
        this.name = name;
        this.price = price;
    }

    public Product(Product p){
        this.productID = p.getID();
        this.name = p.getName();
        this.price = p.getPrice();
    }

    public int getID(){
        return productID;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public void setID(int productID){
        this.productID = productID;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(int price){
        this.price = price;
    }

    @Override
    public String toString(){
        return "ID : " + productID + " Name : " + name + " Price : " + price;
    }
}
