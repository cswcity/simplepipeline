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
import java.util.Map.Entry;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import org.biojava3.core.sequence.DNASequence;

/**
 *
 * @author charlie
 */
@ManagedBean(name="TrimBean")
@Named(value = "TrimBean")
@SessionScoped
public class TrimBean implements Serializable {
    
    @ManagedProperty(value="#{sequences}")
    UploadBean uploaded;
    
    @Inject HashMap<String, DNASequence> sequences;
    
    private int count;
    /**
     * Creates a new instance of TrimBean
     */
    public TrimBean() {
        if (uploaded != null){
            sequences = uploaded.getSequences();
        }else{
            System.out.println("Uploaded bean is null");
        }
        //getSequ
    }
    
    public HashMap<String, DNASequence> getSequences(){
        for (Entry<String, DNASequence> entry : sequences.entrySet()){
            if (entry.getValue().getLength() < 200){
                sequences.remove(entry.getKey());
            }
        }
        return sequences;
    }

    /**
     * @return the count
     */
    public int getCount() {
        count = sequences.size();
        return count;
    }


    
    
    
}
