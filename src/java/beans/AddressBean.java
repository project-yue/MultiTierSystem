/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Collection;

public class AddressBean {

    private String streetNum;
    private String streetName;
    private String suburb;
    private String reigon;
    private String county;
    private String postcode;
    private Collection phoneNumbers;

    public AddressBean() {
        this.streetNum = "a number";
        this.streetName = "a street";
        this.suburb = "a suburb";
        this.reigon = "a region";
        this.county = "a county";
        this.postcode = "postcode";
    }

    public void setStreetNum(String line1) {
        this.streetNum = line1;
    }

    public String getStreetNum() {
        return streetNum;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setReigon(String reigon) {
        this.reigon = reigon;
    }

    public String getReigon() {
        return this.reigon;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCounty() {
        return county;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPostcode() {
        return postcode;
    }

    public Collection getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Collection phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
