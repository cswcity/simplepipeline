/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.co.waterdancer.simplepipeline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.biojava3.core.sequence.DNASequence;

/**
 *
 * @author charlie
 */
@Named(value = "MIDAlignBean")
@SessionScoped
public class MIDAlignBean implements Serializable {
    /** List of input sequences in biojava DNA seq form */
    private HashMap<String, DNASequence> seqs;
    /** The input sequences in raw text form */
    private String fasta;
    /** The Roche 454 MID tags in biojava DNA seq form */
    private HashMap<String, DNASequence> mids;
    //this seems insane - there must be a better way
    /** The path from the package to the resources folder */
    private String prefix = "../../../../../../resources/";
    /**
     * Creates a new instance of MIDAlignBean
     */
    public MIDAlignBean() {

        mids = new HashMap<>();
        
        try (InputStream in = this.getClass().getResourceAsStream(prefix+"MID.txt");
             InputStreamReader is = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(is);){
            String line = null;
            while ((line = br.readLine()) != null){
                Pattern p = Pattern.compile("(MID-\\d+)\\s+([ATGC]+)");
                Matcher m = p.matcher(line);
                System.out.println(line);
                if (m.find()){
                    mids.put(m.group(1), new DNASequence(m.group(2)));
                }
                System.out.println(line);
            }
            
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
        
    }

    /**
     * @return the seqs
     */
    public HashMap<String, DNASequence> getSeqs() {
        return seqs;
    }

    /**
     * @param fasta the sequences with which to populate seqs
     */
    public void populate(String fasta){
        //TODO add regex for populating the 
        //seqs HashMap from the fasta format
    }
    
    private DNASequence trimMID(DNASequence seq, 
            HashMap<String, DNASequence> mids){
        //TODO add alignment for first 20 bases for MID against
        // the sequence. If MID found (>=8 matches out of 10) then
        // trim and return trimed else return original.
        return seq;
    }
    
    
    
    
}
