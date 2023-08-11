package ramiz.backend.test;

import org.junit.Test;
import ramiz.backend.models.createBillingAccount.*;
import ramiz.backend.specification.Specifications;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class createBillingAccount {
    private final HashMap<String, String> headers = new HashMap<>() {{
        put("x-request-id", "autotestRamizdjan");
    }};
    private final String url = "https://sales-dev-api.south.rt.ru/apiman-gateway";
    private final String path = "/adapters-sales/integration-module-router/1.0-dev/createBillingAccount";

    @Test
    public void postCreateBillWithoutXrequestid400() {
        Specifications.installSpec(Specifications.requestFloppa(url, path), Specifications.response400());

        CreateBillingAccountModel createBillingAccountModel = createModel();
        sendRequest(createBillingAccountModel, "Header 'X-Request-Id' is required", "EX_VALIDATION_ERROR", new HashMap<>());
    }

    @Test
    public void postCreateBillWithoutSystemCode400() {
        Specifications.installSpec(Specifications.requestFloppa(url, path), Specifications.response400());

        CreateBillingAccountModel createBillingAccountModel = createModel();
        createBillingAccountModel.systemCode = null;
        sendRequest(createBillingAccountModel, "'systemCode' field required and not empty!", "EX_VALIDATION_ERROR", headers);

    }

    @Test
    public void postCreateBillWithoutСustomer400() {
        Specifications.installSpec(Specifications.requestFloppa(url, path), Specifications.response400());

        CreateBillingAccountModel createBillingAccountModel = createModel();
        createBillingAccountModel.customer = null;
        sendRequest(createBillingAccountModel, "'customer' field required!", "EX_VALIDATION_ERROR", headers);

    }

    @Test
    public void postCreateBillWithoutBillingAccount400() {
        Specifications.installSpec(Specifications.requestFloppa(url, path), Specifications.response400());

        CreateBillingAccountModel createBillingAccountModel = createModel();
        createBillingAccountModel.billingAccount = null;
        sendRequest(createBillingAccountModel, "billingAccount' field required!", "EX_VALIDATION_ERROR", headers);

    }

    @Test
    public void postCreateBillWithoutCustomerCustomerId400() {
        Specifications.installSpec(Specifications.requestFloppa(url, path), Specifications.response400());

        CreateBillingAccountModel createBillingAccountModel = createModel();
        createBillingAccountModel.customer.customerId = null;
        sendRequest(createBillingAccountModel, "'customer.customerId' field required and not empty!", "EX_VALIDATION_ERROR", headers);

    }

    @Test
    public void postCreateBillWithoutCustomerLastName400() {
        Specifications.installSpec(Specifications.requestFloppa(url, path), Specifications.response400());

        CreateBillingAccountModel createBillingAccountModel = createModel();
        createBillingAccountModel.customer.lastName = null;
        sendRequest(createBillingAccountModel, "'customer.lastName' field required and not empty!", "EX_VALIDATION_ERROR", headers);

    }

    @Test
    public void postCreateBillWithoutCustomerFirstName400() {
        Specifications.installSpec(Specifications.requestFloppa(url, path), Specifications.response400());

        CreateBillingAccountModel createBillingAccountModel = createModel();
        createBillingAccountModel.customer.firstName = null;
        sendRequest(createBillingAccountModel, "'customer.lastName' field required and not empty!", "EX_VALIDATION_ERROR", headers);

    }

    @Test
    public void postCreateBillWithoutidentifyDocsTypeCode400() {
        Specifications.installSpec(Specifications.requestFloppa(url, path), Specifications.response400());

        CreateBillingAccountModel createBillingAccountModel = createModel();
        createBillingAccountModel.customer.identifyDocs.get(0).typeCode = null;
        sendRequest(createBillingAccountModel, "'customer.lastName' field required and not empty!", "EX_VALIDATION_ERROR", headers);

    }

    @Test
    public void postCreateBilldWithoutidentifyDocsNumber400() {
        Specifications.installSpec(Specifications.requestFloppa(url, path), Specifications.response400()); // преднастройка вызова

        CreateBillingAccountModel createBillingAccountModel = createModel();
        createBillingAccountModel.customer.identifyDocs.get(0).number = null;
        sendRequest(createBillingAccountModel, "'identifyDoc.number' field required and not empty!", "EX_VALIDATION_ERROR", headers);

    }

    @Test
    public void postCreateBillWithoutidentifyDocsIssuedDate400() {
        Specifications.installSpec(Specifications.requestFloppa(url, path), Specifications.response400()); // преднастройка вызова

        CreateBillingAccountModel createBillingAccountModel = createModel();
        createBillingAccountModel.customer.identifyDocs.get(0).issuedDate = null;
        sendRequest(createBillingAccountModel, "'identifyDoc.issuedDate' field required!", "EX_VALIDATION_ERROR", headers);

    }

    @Test
    public void postCreateBillInccorrectidentifyDocsIssuedDate400() {
        Specifications.installSpec(Specifications.requestFloppa(url, path), Specifications.response400()); // преднастройка вызова

        CreateBillingAccountModel createBillingAccountModel = createModel();
        createBillingAccountModel.customer.identifyDocs.get(0).issuedDate = "2005/23213/32321";
        sendRequest(createBillingAccountModel, "Error format for field: customer.identifyDocs.issuedDate", "EX_VALIDATION_ERROR", headers);

    }

    @Test
    public void postCreateBillInccorrectidentifyDocsbirthDate400() {
        Specifications.installSpec(Specifications.requestFloppa(url, path), Specifications.response400()); // преднастройка вызова

        CreateBillingAccountModel createBillingAccountModel = createModel();
        createBillingAccountModel.customer.identifyDocs.get(0).birthDate = "2005/23213/32321";
        sendRequest(createBillingAccountModel, "Error format for field: customer.identifyDocs.birthDate", "EX_VALIDATION_ERROR", headers);

    }

    @Test
    public void postCreateBillInccorrectidentifyDocsendDate400() {
        Specifications.installSpec(Specifications.requestFloppa(url, path), Specifications.response400()); // преднастройка вызова

        CreateBillingAccountModel createBillingAccountModel = createModel();
        createBillingAccountModel.customer.identifyDocs.get(0).issuedDate = "2005/23213/32321";
        sendRequest(createBillingAccountModel, "Error format for field: customer.identifyDocs.endDate", "EX_VALIDATION_ERROR", headers);

    }

    @Test
    public void postCreateBillWithoutidentifyDocsCustomerAddressGlobalId400() {
        Specifications.installSpec(Specifications.requestFloppa(url, path), Specifications.response400()); // преднастройка вызова

        CreateBillingAccountModel createBillingAccountModel = createModel();
        createBillingAccountModel.customer.address.globalId = null;
        sendRequest(createBillingAccountModel, "address.globalId' field required and not empty!", "EX_VALIDATION_ERROR", headers);

    }

    @Test
    public void postCreateBillWithoutidentifyDocsBillingAccountPaymentMethod400() {
        Specifications.installSpec(Specifications.requestFloppa(url, path), Specifications.response400()); // преднастройка вызова

        CreateBillingAccountModel createBillingAccountModel = createModel();
        createBillingAccountModel.billingAccount.paymentMethod = null;
        sendRequest(createBillingAccountModel, "'billingAccount.paymentMethod' field required!", "EX_VALIDATION_ERROR", headers);

    }

    @Test
    public void postCreateBillInccorrectidentifyDocsBillingAccounSystemCode400() {
        Specifications.installSpec(Specifications.requestFloppa(url, path), Specifications.response400()); // преднастройка вызова

        CreateBillingAccountModel createBillingAccountModel = createModel();
        createBillingAccountModel.systemCode = "CTK.RAMIZ.CRM";
        sendRequest(createBillingAccountModel, "Создание лицевого счёта недоступно для указанной системы", "EX_VALIDATION_ERROR", headers);

    }

    @Test
    public void postCreateBillCorrectRequestidentifyDocsBillingAccoun200() {
        Specifications.installSpec(Specifications.requestFloppa(url, path), Specifications.response200()); // преднастройка вызова

        CreateBillingAccountModel createBillingAccountModel = createModel();
        given()
                .queryParam("apikey", "51c465d2-9a10-4159-ad7a-2b86b41f3e58")
                .headers(headers)
                .when()
                .body(createBillingAccountModel)
                .post()
                .then()
                .body("$", hasKey("billingAccountNumber"));

    }

    @Test
    public void postCreateBillWithoutBillingAccountSalesChannelCode400() {
        Specifications.installSpec(Specifications.requestFloppa(url, path), Specifications.response400()); // преднастройка вызова

        CreateBillingAccountModel createBillingAccountModel = createModel();
        createBillingAccountModel.billingAccount.salesChannelCode = null;
        sendRequest(createBillingAccountModel, "'billingAccount.salesChannelCode' field required and not empty!", "EX_VALIDATION_ERROR", headers);

    }

    @Test
    public void postCreateBillReplicationCode500() {
        Specifications.installSpec(Specifications.requestFloppa(url, path), Specifications.responseSystemcode(500)); // преднастройка вызова

        CreateBillingAccountModel createBillingAccountModel = createModel();
        createBillingAccountModel.customer.customerId = 0000;
        given()
                .queryParam("apikey", "51c465d2-9a10-4159-ad7a-2b86b41f3e58")
                .headers(headers)
                .when()
                .body(createBillingAccountModel)
                .post()
                .then();
    }
    @Test
    public void postCreateBillReplicationCode400() {
        Specifications.installSpec(Specifications.requestFloppa(url, path), Specifications.response400()); // преднастройка вызова

        CreateBillingAccountModel createBillingAccountModel = createModel();
        createBillingAccountModel.billingAccount.address.globalId = "0000";
        sendRequest(createBillingAccountModel, "Не задано значение для параметра kladrRegionId", "EX_AMDOCS_RESPONSE_ERROR", headers);

    }
    public CreateBillingAccountModel createModel() {
        Address address = new Address("76364578", "22");
        BillingAccount billingAccount = new BillingAccount("credit", "B2x_AC", address);
        IdentifyDoc identifyDoc = new IdentifyDoc("PASSPORT_RU", "213313", "232132", "test 1", "2008-06-03", "2023-06-03", "Test", "2023-06-03", "Зюзин");
        Customer customer = new Customer(30838596, "Николаев", "Игорь", "Владимирович", new ArrayList<>(List.of(identifyDoc)), address);
        CreateBillingAccountModel createBillingAccountModel = new CreateBillingAccountModel("CTK.ALL.CRM", customer, billingAccount);
        return createBillingAccountModel;
    }

    public void sendRequest(CreateBillingAccountModel createBillingAccountModel, String message, String error, HashMap<String, String> headers) {
        given()
                .queryParam("apikey", "51c465d2-9a10-4159-ad7a-2b86b41f3e58")
                .headers(headers)
                .when()
                .body(createBillingAccountModel)
                .post()
                .then()
                .body("message", containsString(message))
                .body("error", equalTo(error));
    }
}