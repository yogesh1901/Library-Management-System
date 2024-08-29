package com.dh.lms.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Reader {
 
    BufferedReader reader;
    StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    public Reader() {
        reader = new BufferedReader(new InputStreamReader(System.in) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    private String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }
    
    public String nextLine() {
       String out="";
       try{
        out=reader.readLine();
       } catch(IOException e){
        e.printStackTrace();
       }
       return out;
    }

    public int nextInt()  {
        int out=0;
        try{
            out=Integer.parseInt( next() );
        } catch(IOException e){
            e.printStackTrace();
        }
        return out;
    }
    public long nextLong()  {
        long out=0;
        try{
            out=Long.parseLong( next() );
        } catch(IOException e){
            e.printStackTrace();
        }
        return out;
    }

    }
	
    //  double nextDouble() throws IOException {

    //     return Double.parseDouble( next() );
    // }
