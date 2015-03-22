package beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Yue Li
 */
public class CustomerBean implements Serializable {

    private String id;
    private String name;
    private String pwd;
    private int purchase;
    private int sales;

    private PropertyChangeSupport propertySupport;

    public CustomerBean() {
        propertySupport = new PropertyChangeSupport(this);
    }

    public String getNameProperty() {
        return name;
    }

    public void setNameProperty(String value) {
        String oldValue = name;
        name = value;
        propertySupport.firePropertyChange(id, oldValue, name);
    }

    public String getPwdProperty() {
        return this.pwd;
    }

    public void setPwdProperty(String pwd) {
        this.pwd = pwd;
    }

    public int getPurchaseProperty() {
        return this.purchase;
    }

    public void incrementPurchaseProperty() {
        this.purchase++;
    }

    public int getSalesProperty() {
        return this.sales;
    }

    public void incrementSalesProperty() {
        this.sales++;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

}
