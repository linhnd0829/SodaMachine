import java.util.*;

public class Machine {

    List<Product> listProduction;

    public Machine(){
    }

    public void run(){

        listProduction = DataProduct.getData();
        if(listProduction.isEmpty()){
            return;
        }
        while(true){
            try {
                Thread.sleep(Def.delayTimeBetweenTransaction * 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            UI.printWelcome();
            UI.printCashInput();

            //start transaction
            Transaction transaction = new Transaction();

            // insert cash
            int userCashInput = UI.getInput();
            if(!checkCashInput(userCashInput)){
                UI.printGoodbye();
                transaction = null;
                System.gc();
                continue;
            }
            int lastNodeValue = Def.NOTES[userCashInput];
            transaction.setLastNode(lastNodeValue);
            UI.printInsertedCash(lastNodeValue);
            
            // select product
            UI.printProduct(listProduction);

            int userProductInput = UI.getInput();
            if(!checkProductInput(userProductInput)){
                transaction.sendBackLastNode();
                UI.printGoodbye();
                transaction = null;
                System.gc();
                continue;
            }

            Product product = new Product(listProduction.get(userProductInput));
            if(lastNodeValue < product.getPrice()){
                transaction.sendBackLastNode();
                UI.printNotEnoughCash();
                UI.printGoodbye();
                transaction = null;
                System.gc();
                continue;
            }

            // send product and remaining cash
            transaction.sendProductToUser(product);
            transaction.sendRemainingCash(lastNodeValue - product.getPrice());
            
            // reset
            lastNodeValue = 0;
            transaction = null;
            System.gc();
            UI.printGoodbye();
        }
        
    }

    public boolean checkCashInput(int userCashInput){
        if(userCashInput <0 || userCashInput>=Def.NOTES.length){
            UI.printInvalidInput();
            return false;
        }
        if(userCashInput ==0) return false; 
        return true;
    }

    public boolean checkProductInput(int userProductInput){
        if(userProductInput <0 || userProductInput>=listProduction.size()){
            UI.printInvalidInput();
            return false;
        }
        if(userProductInput ==0) return false; 
        return true;
    }
}
