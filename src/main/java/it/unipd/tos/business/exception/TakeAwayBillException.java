////////////////////////////////////////////////////////////////////
// Rebecca Schiavon 1163774
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exception;

public class TakeAwayBillException extends Throwable {
    private String mex;

    public TakeAwayBillException(String exc){
        this.mex = exc;
    }

    public String getMessage(){
        return this.mex;
    }
} 