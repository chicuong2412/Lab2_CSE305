package Lab6;

import java.time.LocalDate;

import Lab6.RequestProduct.RequestProducts;

public class HighPriorityCreator extends RequestCreator {

    @Override
    public RequestProducts createRequest() {
        // TODO Auto-generated method stub
        var out = new HighPriorityConcrete();
        out.setPriority("Emergency");
        out.setStatus("Accept");
        out.setExpire(LocalDate.now());
        return out;
    }

    @Override
    public void processRequest() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processRequest'");
    }

}
