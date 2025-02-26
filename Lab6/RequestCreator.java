package Lab6;

import java.time.LocalDate;
// import java.util.Date;
import java.util.Scanner;

import Lab6.RequestProduct.RequestProducts;

public abstract class RequestCreator {

    public abstract RequestProducts createRequest();

    public abstract void processRequest();

}
