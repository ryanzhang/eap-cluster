package com.redhat.eap;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@SessionScoped
@Named
public class Cluster implements Serializable {
    private static final long serialVersionUID = -1717410639659055684L;
    private Integer count = Integer.valueOf(0);

    public Cluster() {
    }

    public String getServer() {
        String server = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getServerName();
        String port = String.valueOf(((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getServerPort());
        return server + ":" + port;
    }

    public void increaseCount() {
        Integer var1 = this.count;
        Integer var2 = this.count = Integer.valueOf(this.count.intValue() + 1);
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getJbossNodeName() {
        return System.getProperty("jboss.node.name");
    }

    public String getJbossHostName() {
        return System.getProperty("jboss.host.name");
    }

    public String getJbossQualifiedHostName() {
        return System.getProperty("jboss.qualified.host.name");
    }

    public String getBaseDir() {
        return System.getProperty("jboss.server.base.dir");
    }
}
