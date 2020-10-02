package com.fresco.jdbc.code.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.jdbc.ScriptRunner;


public class RunningScripts {
   public static void runDbScript() throws Exception {      
      try{
    	  
    	  File file= new File("db.sql");
    	  Connection con = DbUtil.getConnection();
    	  Reader reader = new BufferedReader(new FileReader(file));
    	  System.out.println("Running script from file : "+file.getCanonicalPath());
    	  ScriptRunner sr = new ScriptRunner(con);    	  
    	  sr.setAutoCommit(true);
    	  sr.setStopOnError(true);
    	  sr.runScript(reader);
    	  System.out.println("script execution done..!");
    	  
      }catch(Exception e){
    	  e.printStackTrace();
      }
   }
}