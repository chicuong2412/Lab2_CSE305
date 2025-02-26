package Lab6.RequestProduct;

import java.time.LocalDate;

/**
 * RequestProducts
 */
public interface RequestProducts {

    void setPriority(String priority);

    void setExpire(LocalDate expireDay);

    void setStatus(String status);

    void processRequest();
}