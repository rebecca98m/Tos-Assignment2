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
import org.junit.rules.ExpectedException;
import org.junit.Rule;

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
	
	@Test
    public void Bill_ListOrderWithMoreThan5Sandwich_CorrectTotalWithDiscount50() throws TakeAwayBillException{
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        TakeAwayManager testBill = new TakeAwayManager();

        itemsOrdered.add(new MenuItem("Panino primavera", MenuItem.items.Panino, 4.00));
        itemsOrdered.add(new MenuItem("Hot dog" , MenuItem.items.Panino, 4.00));
        itemsOrdered.add(new MenuItem("Panino primavera", MenuItem.items.Panino, 4.00));
        itemsOrdered.add(new MenuItem("Coca cola", MenuItem.items.Bevanda, 1.50));
        itemsOrdered.add(new MenuItem("Patatine fritte", MenuItem.items.Fritto, 2.50));
        itemsOrdered.add(new MenuItem("Hot dog" , MenuItem.items.Panino, 4.00));
        itemsOrdered.add(new MenuItem("Olive ascolane" , MenuItem.items.Fritto, 3.00));
        itemsOrdered.add(new MenuItem("Hot dog" , MenuItem.items.Panino, 4.00));
        itemsOrdered.add(new MenuItem("Panino primavera", MenuItem.items.Panino, 4.00));
        itemsOrdered.add(new MenuItem("Coca cola" , MenuItem.items.Bevanda, 1.50));
        itemsOrdered.add(new MenuItem("Hot dog" , MenuItem.items.Panino, 4.00));
        itemsOrdered.add(new MenuItem("Olive ascolane" , MenuItem.items.Fritto, 3.00));

        try {
            assertEquals(37.5, testBill.getOrderPrice(itemsOrdered), 0.0);
        } 
        catch (TakeAwayBillException exc){
            exc.getMessage();
        }
    }
	
    @Test
    public void Bill_ListOrderWithMoreThan50_CorrectTotalWithDiscount10() throws TakeAwayBillException {
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        TakeAwayManager testBill = new TakeAwayManager();
        
        itemsOrdered.add(new MenuItem("Panino primavera", MenuItem.items.Panino, 40.00));
        itemsOrdered.add(new MenuItem("Panino primavera", MenuItem.items.Panino, 15.00));
        itemsOrdered.add(new MenuItem("Coca cola" , MenuItem.items.Bevanda, 1.50));
        itemsOrdered.add(new MenuItem("Olive ascolane" , MenuItem.items.Fritto, 3.00));
  
        try {
            assertEquals(53.7, testBill.getOrderPrice(itemsOrdered), 0.0);
        } 
        catch (TakeAwayBillException exc){
            exc.getMessage();
        }
    }
    
    @Test
    public void Bill_ListOrderWithLessThan10_CorrectTotalWithIncrement() throws TakeAwayBillException {
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        TakeAwayManager testBill = new TakeAwayManager();

        itemsOrdered.add(new MenuItem("Hot dog" , MenuItem.items.Panino, 3.50));

        try {
            assertEquals(4, testBill.getOrderPrice(itemsOrdered), 0.0);
        } 
        catch (TakeAwayBillException exc){
            exc.getMessage();
        }
    } 
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void NumberElementsExceed30_Test() throws TakeAwayBillException {
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        TakeAwayManager testBill = new TakeAwayManager();

        thrown.expect(TakeAwayBillException.class);
        thrown.expectMessage("Non ci possono essere più di 30 elementi nell'ordine");

        for(int i = 1; i <= 35; i++)
        	itemsOrdered.add(new MenuItem("Hot dog" , MenuItem.items.Panino, 3.50));

        testBill.getOrderPrice(itemsOrdered);
    } 

}
