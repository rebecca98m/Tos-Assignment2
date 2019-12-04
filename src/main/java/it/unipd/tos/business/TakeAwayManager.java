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
        double paninoMenoCostoso = Double.MAX_VALUE;
        
        for (MenuItem menuItem : itemsOrdered) {
            total += menuItem.getPrice();
        if(menuItem.getType() == MenuItem.items.Panino){
            numeroPanini++;
            if(paninoMenoCostoso > menuItem.getPrice()){
                paninoMenoCostoso = menuItem.getPrice();
            }
        }
    }
        
        if(numeroPanini > 5){
            total = total - (paninoMenoCostoso/2);
        }
            
        return total;
}
}