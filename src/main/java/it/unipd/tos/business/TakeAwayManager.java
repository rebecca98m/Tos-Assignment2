////////////////////////////////////////////////////////////////////
// Rebecca Schiavon 1163774
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

public class TakeAwayManager implements TakeAwayBill{
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {
        double total = 0.0;
        int numeroPanini=0;
        double totaleCibo = 0.0;
        double totaleBevande = 0.0;
        double paninoMenoCostoso = Double.MAX_VALUE;
        
        for (MenuItem menuItem : itemsOrdered) {
        if(menuItem.getType() == MenuItem.items.Bevanda) {
                totaleBevande += menuItem.getPrice();
            }
            else {
                totaleCibo += menuItem.getPrice();
            }

        if(menuItem.getType() == MenuItem.items.Panino){
            numeroPanini++;
            if(paninoMenoCostoso > menuItem.getPrice()){
                paninoMenoCostoso = menuItem.getPrice();
            }
        }
    }
        
        if(numeroPanini > 5){
            totaleCibo -= (paninoMenoCostoso/2);
        }
        if(totaleCibo > 50.0){
            totaleCibo -= (totaleCibo*0.1);
        }
            
        return totaleCibo+totaleBevande;
}
}