package utilitariosSO;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class LogManager 
{
	private final static String DEFAULT_FILE_ERRORS = "DefaultLog.txt";
	
	public static void WriteDefaultLog(String errors)
	{
		LogManager.WriteLog(DEFAULT_FILE_ERRORS, errors);
	}
	
	private static void WriteLog(String file, String errors)
	{		
		try
		{   
			//FileWriter(String fileName, boolean append)
			
			String appPath = System.getProperty("user.dir");
			
		    FileWriter fstream = new FileWriter(appPath + "\\" + file, true);
		    BufferedWriter out = new BufferedWriter(fstream);
		    //Mais para frente a gente incrementa o log
		    //Mandando o exception e ele lento todo o stacktrace... mais to meio cansado
		    //laggggg
		    out.write(Utilitarios.getDateTime() + ": ");
		    out.write(errors + "\r\n");
		    out.write("\r\n");
		    out.close();
		    fstream.close();
		    }catch (Exception e)
		    {
		    	//Esse é o unico erro q não podemos logar né xDDD
		    	System.err.println("Error: " + e.getMessage());
		    }
	}
}
