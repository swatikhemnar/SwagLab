package utility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrization {
	
	public static String getData(int row,int column) throws EncryptedDocumentException, IOException
	{
		FileInputStream file =new FileInputStream("E:\\Eclipse\\SwagLab\\src\\test\\resources\\TestCaseData.xlsx");
	    String input=WorkbookFactory.create(file).getSheet("Cred").getRow(row).getCell(column).getStringCellValue();
	    return input;
	}
	
	

}