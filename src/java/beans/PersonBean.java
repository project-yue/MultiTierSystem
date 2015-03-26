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
public class PersonBean {

    private String name;
    private int age;
    private AddressBean address;

    public PersonBean() {
        setName("A N Other");
        setAge(21);
        this.address = new AddressBean();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    public AddressBean getAddress() {
        return address;
    }
}
