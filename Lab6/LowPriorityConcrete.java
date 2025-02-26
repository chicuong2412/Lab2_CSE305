package Lab6;

import java.time.LocalDate;

import Lab6.RequestProduct.RequestProducts;

public class LowPriorityConcrete implements RequestProducts {
    private String priority;
    private LocalDate expireDate;
    private String status;

    @Override
    public void setPriority(String priority) {
        // TODO Auto-generated method stub
        this.priority = priority;
    }

    @Override
    public void setExpire(LocalDate expireDate) {
        // TODO Auto-generated method stub
        this.expireDate = expireDate;
    }

    @Override
    public void setStatus(String status) {
        // TODO Auto-generated method stub
        this.status = status;
    }

    @Override
    public void processRequest() {
        // TODO Auto-generated method stub
        System.out.println("Request denied");
    }

}
