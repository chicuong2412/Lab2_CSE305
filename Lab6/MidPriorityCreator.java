package Lab6;

import java.time.LocalDate;

import Lab6.RequestProduct.RequestProducts;

public class MidPriorityCreator extends RequestCreator {

    @Override
    public RequestProducts createRequest() {
        // TODO Auto-generated method stub
        var out = new MidPriorityConcrete();
        out.setPriority("Medium");
        out.setStatus("Accepted");
        out.setExpire(LocalDate.now().plusMonths(1));
        return out;
    }

    @Override
    public void processRequest() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processRequest'");
    }

}
