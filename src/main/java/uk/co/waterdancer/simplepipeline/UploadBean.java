/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.waterdancer.simplepipeline;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.biojava3.core.sequence.DNASequence;

/**
 *
 * @author charlie
 */
@ManagedBean(name="UploadBean")
@Named(value = "UploadBean")
@SessionScoped
public class UploadBean implements Serializable {

    private String input;
    private HashMap<String, DNASequence> sequences;
    private int count;
    private boolean testing = false;


    /**
     * Creates a new instance of UploadBean
     */
    public UploadBean() {
        sequences = new HashMap<>();

    }

    public void setTesting(boolean testing) {
        this.testing = testing;
    }
    

    /**
     * @return the sequences
     */
    public HashMap<String, DNASequence> getSequences() {
        if (sequences.isEmpty()) {
            fill();
        }
        return sequences;
    }

    /**
     * private method to populate sequences hashmap with the input string.
     */
    private void fill() {
        String[] lines;
        String id = "";
        String seq = "";
        if (input != null) {
            lines = input.split("\\n");
            for (String line : lines) {             
                if (line.startsWith(">") && !id.isEmpty()) {
                    sequences.put(id, new DNASequence(seq));
                    id = "";
                    seq = "";
                }
                if (line.startsWith(">")) {
                    id = line.substring(1).trim();
                } else {
                    seq = seq + line.trim();
                }
            }
            if (!(id.isEmpty() && seq.isEmpty())) {
                sequences.put(id, new DNASequence(seq));
            }
        }
    }

    /**
     * @return the count
     */
    public int getCount() {
        count = sequences.size();
        return count;
    }

    /**
     * @return the input
     */
    public String getInput() {
        return input;
    }

    /**
     * @param input the input to set
     */
    public void setInput(String input) {
        //System.out.println("Input has been recognized: " + input);
        sequences.clear();
        this.input = input;
        fill();
        if (!testing){
            redirect();
        }
    }
    
    private void redirect(){
        String url = "uploaded.xhtml";
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {
            ec.redirect(url);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
