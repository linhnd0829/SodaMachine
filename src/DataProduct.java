import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public abstract class DataProduct {
    public static List<Product> getData() {

        List<Product> listProduction = new ArrayList<Product>();

        String line = "";  
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader(Def.DATA_PRODUCT_FILE_PATH));
            boolean firstRow = true;  
            while ((line = br.readLine()) != null)
            {
                if(firstRow){
                    firstRow = false;
                    continue;
                } 
                String[] product = line.split(splitBy);
                Product p = new Product(Integer.parseInt(product[0]),product[1],Integer.parseInt(product[2]));
                listProduction.add(p); 
            }   
            br.close();
        } catch (Exception e) {
            System.out.println("Fail fetching data \n");
            e.printStackTrace();
        } 
        
        return listProduction;
    }
}
