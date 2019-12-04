////////////////////////////////////////////////////////////////////
// Rebecca Schiavon 1163774
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.business.TakeAwayManager;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TakeAwayManagerTest {

	@Test
	public void Billing_ListOrder_CorrectTotal(){
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        TakeAwayManager testBill = new TakeAwayManager();

        itemsOrdered.add(new MenuItem("Panino primavera", MenuItem.items.Panino, 4.00));
        itemsOrdered.add(new MenuItem("Panino primavera", MenuItem.items.Panino, 4.00));
        itemsOrdered.add(new MenuItem("Coca cola", MenuItem.items.Bevanda, 1.50));
        itemsOrdered.add(new MenuItem("Patatine fritte", MenuItem.items.Fritto, 2.50));

        try{
            assertEquals(12.00, testBill.getOrderPrice(itemsOrdered), 0.0);
        } 
        catch (TakeAwayBillException exc){
            exc.getMessage();
        }
    }

}
