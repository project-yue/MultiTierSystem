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
    private int share;
    private int use;

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

    public int getShare() {
        return this.share;
    }

    public void setShare(int value) {
        this.share = value;
    }

    public int getUse() {
        return this.use;
    }

    public void setUse(int value) {
        this.use = value;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

}
