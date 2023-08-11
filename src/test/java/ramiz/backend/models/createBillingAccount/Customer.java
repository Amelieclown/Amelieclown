package ramiz.backend.models.createBillingAccount;

import java.util.ArrayList;


public class Customer {
    public Integer customerId;
    public String lastName;
    public String firstName;
    public String secondName;
    public ArrayList<IdentifyDoc> identifyDocs;
    public Address address;

    public Customer(int customerId, String lastName, String firstName, String secondName, ArrayList<IdentifyDoc> identifyDocs, Address address) {
        this.customerId = customerId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.identifyDocs = identifyDocs;
        this.address = address;
    }
}

