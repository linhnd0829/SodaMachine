import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private Cash lastNode;

    public Cash getLastNode(){
        return this.lastNode;
    }

    public void setLastNode(int value){
        lastNode = new Cash(value);
    }

    public void sendBackLastNode(){
        // send back the last node of cash that the user inserted
        UI.printSendBackLastNode(lastNode.getValue());
        lastNode = null;
        return;
    }

    public void sendProductToUser(Product product){
        UI.printSendProduct(product);
        return;
    }

    public void sendRemainingCash(int value){
        if(value <=0) return;
        List<Cash> remaining = new ArrayList<Cash>();
        int i = Def.NOTES.length-1;
        while(i>0){
            if(value < 0) break;
            if(value >= Def.NOTES[i]){
                Cash cash = new Cash(Def.NOTES[i]);
                remaining.add(cash);
                value -= Def.NOTES[i];
            }
            else i--;
        }
        UI.printSendRemainingCash(remaining);
    }
}
