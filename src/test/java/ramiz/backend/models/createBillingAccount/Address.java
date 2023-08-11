package ramiz.backend.models.createBillingAccount;

public class Address {

    public String globalId;
    public String flatNumber;

    public Address(String globalId, String flatNumber) {
        this.globalId = globalId;
        this.flatNumber = flatNumber;
    }
}

