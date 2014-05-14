/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.co.waterdancer.simplepipeline;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author charlie
 */
@Named(value = "UploadBean")
@SessionScoped
public class UploadBean implements Serializable {
    
    @ManagedProperty(value="#{input}")
    private String input;
    private HashMap<String, String> sequences;
    @ManagedProperty(value="#{count}")
    private int count;
    /**
     * Creates a new instance of UploadBean
     */
    public UploadBean() {
        sequences = new HashMap<>();
        //System.out.println("Upload bean created");
    }

    /**
     * @return the sequences
     */
    public HashMap<String, String> getSequences() {
        if (sequences.isEmpty()){
            fill();
        }
        return sequences;
    }

    /**
     * private method to populate sequences hashmap
     * with the input string.
     */
    private void fill() {
        String [] lines;
        String id = "";
        String seq = "";
        boolean sameSeq = false;
        if (input != null){
            lines = input.split("\\n");
            for (String line : lines){
                if (line.startsWith(">") && !id.isEmpty()){
                    System.out.println("id: "+id+"\nseq: "+ seq);
                    sequences.put(id, seq);
                    id = "";
                    seq = "";
                }else if (line.startsWith(">")){
                    System.out.println("in elif: " + line);
                    id = line.substring(1);
                }else {
                    seq = seq + line.trim();
                }
            }
            if (!(id.isEmpty() && seq.isEmpty())){
                sequences.put(id, seq);
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
        System.out.println("Input has been recognized: " + input);
        sequences.clear();
        this.input = input;
        fill();
        
    }
    
}
