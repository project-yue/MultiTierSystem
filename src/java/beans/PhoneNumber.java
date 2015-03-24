/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author mk29
 */
public class PhoneNumber {

    private String std;
    private String number;

    public String getNumber() {
        return number;
    }

    public String getStd() {
        return std;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setStd(String std) {
        this.std = std;
    }
}
