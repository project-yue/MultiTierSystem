package beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Yue Li
 */
public class UserBean implements Serializable {

    private String id;
    private String name;
    private String pwd;
    private String share;
    private String use;

    private PropertyChangeSupport propertySupport;

    public UserBean() {
        propertySupport = new PropertyChangeSupport(this);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        String oldValue = name;
        name = value;
//        propertySupport.firePropertyChange(id, oldValue, name);
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getShare() {
        return this.share;
    }

    public void setShare(String value) {
        this.share = value;
    }

    public String getUse() {
        return this.use;
    }

    public void setUse(String value) {
        this.use = value;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

}
