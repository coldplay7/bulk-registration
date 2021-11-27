package com.demo.registration.validation;

public class Violation {

    private String field;
    private String reason;
    private String msisdn;

    public Violation(String field, String reason, String msisdn) {
        this.field = field;
        this.reason = reason;
        this.msisdn = msisdn;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Violation{" +
                "field='" + field + '\'' +
                ", reason='" + reason + '\'' +
                ", msisdn='" + msisdn + '\'' +
                '}';
    }
}
