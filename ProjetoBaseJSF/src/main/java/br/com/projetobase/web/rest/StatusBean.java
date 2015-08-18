package br.com.projetobase.web.rest;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StatusBean implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

    public StatusBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	
}
