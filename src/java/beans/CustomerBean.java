package beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Yue Li
 */
public class CustomerBean implements Serializable {
    
    private String id;
    
    private String firstName;
    private String lastName;
    
    private PropertyChangeSupport propertySupport;
    
    public CustomerBean() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public String getSampleProperty() {
        return firstName;
    }
    
    public void setSampleProperty(String value) {
        String oldValue = firstName;
        firstName = value;
        propertySupport.firePropertyChange(id, oldValue, firstName);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
}
