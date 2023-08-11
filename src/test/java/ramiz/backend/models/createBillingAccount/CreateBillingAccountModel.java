package ramiz.backend.models.createBillingAccount;

import java.util.ArrayList;

public class CreateBillingAccountModel {
    public String systemCode;
    public Customer customer;
    public BillingAccount billingAccount;

    public CreateBillingAccountModel(String systemCode, Customer customer, BillingAccount billingAccount) {
        this.systemCode = systemCode;
        this.customer = customer;
        this.billingAccount = billingAccount;
    }
}
