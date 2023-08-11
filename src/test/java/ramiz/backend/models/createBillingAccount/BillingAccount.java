package ramiz.backend.models.createBillingAccount;

public class BillingAccount {

    public String paymentMethod;
    public String salesChannelCode;
    public Address address;

    public BillingAccount(String paymentMethod, String salesChannelCode, Address address) {
        this.paymentMethod = paymentMethod;
        this.salesChannelCode = salesChannelCode;
        this.address = address;
    }
}
