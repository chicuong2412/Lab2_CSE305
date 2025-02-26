package Lab6;

import java.time.LocalDate;

import Lab6.RequestProduct.RequestProducts;

public class LowPriorityCreator extends RequestCreator {

    @Override
    public RequestProducts createRequest() {
        // TODO Auto-generated method stub
        var out = new LowPriorityConcrete();
        out.setPriority("Ignore");
        out.setStatus("Done");
        out.setExpire(LocalDate.now());
        return out;
    }

    @Override
    public void processRequest() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processRequest'");
    }

}
