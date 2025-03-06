import java.util.List;
import java.util.ArrayList;

class Property {
    private final String name;
    private final double rentAmount;
    private final Owner owner;

    public Property(PropertyBuilder propertyBuilder) {
        this.name = propertyBuilder.getName();
        this.rentAmount = propertyBuilder.getRentAmount();
        this.owner = propertyBuilder.getOwner();
    }

    public String getName() {
        return name;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public Owner getOwner() {
        return owner;
    }

    public void printPropertyDetails() {
        System.out.println("Property: " + name);
        System.out.println("Rent Amount: $" + rentAmount);
        System.out.println("Owner: " + owner.getOwnerName());
        System.out.println("Location: " + owner.getLocation());
    }

    public double getYearlyRent() {
        return rentAmount * 12;
    }
}

class Owner {
    private final String ownerName;
    private final String location;

    public Owner(OwnerBuilder ownerBuilder) {
        this.ownerName = ownerBuilder.getOwnerName();
        this.location = ownerBuilder.getLocation();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getLocation() {
        return location;
    }
}

class OwnerBuilder {
    private final String ownerName;
    private final String location;

    public OwnerBuilder(String ownerName, String location) {
        this.ownerName = ownerName;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public Owner build() {
        return new Owner(this);
    }
}

class PropertyBuilder {
    private final String name;
    private final double rentAmount;
    private final Owner owner;

    public PropertyBuilder(String name, double rentAmount, String ownerName, String location) {
        this.name = name;
        this.rentAmount = rentAmount;
        this.owner = new OwnerBuilder(ownerName, location).build();
    }

    public String getName() {
        return name;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public Owner getOwner() {
        return owner;
    }

    public Property build() {
        return new Property(this);
    }

}

class FinancialReport {
    private String reportTitle;
    private List<Property> properties;
    private double totalRent;

    public FinancialReport(String reportTitle, List<Property> properties) {
        this.reportTitle = reportTitle;
        this.properties = properties;
    }

    public void generateReport() {
        System.out.println("Financial Report: " + reportTitle);
        System.out.println("----------------------------");
        for (Property property : properties) {
            property.printPropertyDetails();
            printPropertySummary(property);
        }

        totalRent = calculateTotal(properties);

        System.out.println("Total Rent Amount: $" + totalRent);
    }

    private double calculateTotal(List<Property> properties) {
        double total = 0;
        for (Property property : properties) {
            total += property.getRentAmount();
        }
        return total;
    }

    private void printPropertySummary(Property property) {
        property.printPropertyDetails();

        System.out.println(new RankProperty(property, new ComparatorV1()).ranking());
        System.out.println("Yearly Rent: $" + property.getYearlyRent());
        System.out.println("--------------------");
    }
}

class RankProperty {

    private final Property property;
    private final Comparator comparator;

    public RankProperty(Property property, Comparator comparator) {
        this.property = property;
        this.comparator = comparator;
    }

    public Comparator getComparator() {
        return comparator;
    }

    public Property getProperty() {
        return property;
    }

    public String ranking() {
        return comparator.classifyProperty(property);
    }

}

interface Comparator {
    String classifyProperty(Property property);
}

class ComparatorV1 implements Comparator {

    @Override
    public String classifyProperty(Property property) {
        if (isPremium(property))
            return Constrant.PREMIUM_STRING;
        else
            return Constrant.STANDARD_STRING;
    }

    public boolean isPremium(Property property) {
        return property.getRentAmount() > Constrant.PREMIUM_RENT_THRESHOLD;
    }

}

class Constrant {

    public static final double PREMIUM_RENT_THRESHOLD = 2000.0;

    public static final String PREMIUM_STRING = "This is a premium property.";

    public static final String STANDARD_STRING = "This is a standard property.";
}

public class ReportV1 {
    public static void main(String[] args) {
        Property property1 = new PropertyBuilder("Apartment A", 1500.0, "John Doe", "City Center").build();
        Property property2 = new PropertyBuilder("House B", 2000.0, "Jane Smith", "Suburb").build();
        Property property3 = new PropertyBuilder("Condo C", 1800.0, "Bob Johnson", "Downtown").build();

        FinancialReport financialReport = new FinancialReport("Monthly Rent Summary",
                List.of(property1, property2, property3));
        financialReport.generateReport();

    }
}
