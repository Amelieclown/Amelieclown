package ramiz.backend.models.createBillingAccount;

public class IdentifyDoc {

    public String typeCode;
    public String number;
    public String series;
    public String issuedBy;
    public String issuedDate;
    public String endDate;
    public String issuedByDepartment;
    public String birthDate;
    public String birthPlace;

    public IdentifyDoc(String typeCode, String number, String series, String issuedBy, String issuedDate, String endDate, String issuedByDepartment, String birthDate, String birthPlace) {
        this.typeCode = typeCode;
        this.number = number;
        this.series = series;
        this.issuedBy = issuedBy;
        this.issuedDate = issuedDate;
        this.endDate = endDate;
        this.issuedByDepartment = issuedByDepartment;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
    }
}

