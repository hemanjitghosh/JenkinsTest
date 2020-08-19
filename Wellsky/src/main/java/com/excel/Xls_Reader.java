package com.excel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

/**
 * 
 * @author E001518 - Debasish Pradhan (Architect)
 *
 */
public class Xls_Reader {
	
	//public String filename = System.getProperty("user.dir")+"\\TestData\\TestData.xls";
	public  String path;
	public  FileInputStream fis = null;
	public  FileOutputStream fileOut =null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row   =null;
	private XSSFCell cell = null;
	private String returnValue;
	
	public Xls_Reader(String path) {
		
		//System.out.println("file path: "+System.getProperty("user.dir"));
		System.out.println("Path is  ****    "+path);
		this.path=path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	// returns the row count in a sheet
	public int getRowCount(String sheetName){
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1)
			return 0;
		else{
		sheet = workbook.getSheetAt(index);
		int number=sheet.getLastRowNum()+1;
		return number;
		}
		
	}
	
	// returns the data from a cell
	public String getCellData(String sheetName,String colName,int rowNum){
		try{
			if(rowNum <=0)
				return "";
		//System.out.println("sheet Name"+sheetName);
		int index = workbook.getSheetIndex(sheetName);
		int col_Num=-1;
		if(index==-1)
			return "";
		
		sheet = workbook.getSheetAt(index);
		row=sheet.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++){
			//System.out.println(row.getCell(i).getStringCellValue().trim());
			if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
				col_Num=i;
		}
		if(col_Num==-1)
			return "";
		
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum-1);
		if(row==null)
			return "";
		cell = row.getCell(col_Num);
		
		if(cell==null)
			return "";
		//System.out.println(cell.getCellType());
		if(cell.getCellType()==Cell.CELL_TYPE_STRING)
			  return cell.getStringCellValue();
		else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA ){
			  
			  String cellText  = String.valueOf(cell.getNumericCellValue());
			  if (HSSFDateUtil.isCellDateFormatted(cell)) {
		           // format in form of M/D/YY
				  double d = cell.getNumericCellValue();

				  Calendar cal =Calendar.getInstance();
				  cal.setTime(HSSFDateUtil.getJavaDate(d));
		            cellText =
		             (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
		           cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
		                      cal.get(Calendar.MONTH)+1 + "/" + 
		                      cellText;
		           
		           //System.out.println(cellText);

		         }

			  
			  
			  return cellText;
		  }else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
		      return ""; 
		  else 
			  return String.valueOf(cell.getBooleanCellValue());
		
		}
		catch(Exception e){
			
			e.printStackTrace();
			return "row "+rowNum+" or column "+colName +" does not exist in xls";
		}
	}
	
	// returns the data from a cell
	public String getCellData(String sheetName,int colNum,int rowNum){
		try{
			if(rowNum <=0)
				return "";
		
		int index = workbook.getSheetIndex(sheetName);
		
		if(index==-1)
			return "";
		
	
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum-1);
		if(row==null)
			return "";
		cell = row.getCell(colNum);
		if(cell==null)
			return "";
		
	  if(cell.getCellType()==Cell.CELL_TYPE_STRING)
		  return cell.getStringCellValue();
	  else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA ){
		  
		  String cellText  = String.valueOf(cell.getNumericCellValue());
		  if (HSSFDateUtil.isCellDateFormatted(cell)) {
	           // format in form of M/D/YY
			  double d = cell.getNumericCellValue();

			  Calendar cal =Calendar.getInstance();
			  cal.setTime(HSSFDateUtil.getJavaDate(d));
	            cellText =
	             (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
	           cellText = cal.get(Calendar.MONTH)+1 + "/" +
	                      cal.get(Calendar.DAY_OF_MONTH) + "/" +
	                      cellText;
	           
	          // System.out.println(cellText);

	         }

		  
		  
		  return cellText;
	  }else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
	      return "";
	  else 
		  return String.valueOf(cell.getBooleanCellValue());
		}
		catch(Exception e){
			
			e.printStackTrace();
			return "row "+rowNum+" or column "+colNum +" does not exist  in xls";
		}
	}
	
	// returns true if data is set successfully else false
	public boolean setCellData(String sheetName,String colName,int rowNum, String data){
		try{
		fis = new FileInputStream(path); 
		workbook = new XSSFWorkbook(fis);

		if(rowNum<=0)
			return false;
		
		int index = workbook.getSheetIndex(sheetName);
		int colNum=-1;
		if(index==-1)
			return false;
		
		
		sheet = workbook.getSheetAt(index);
		

		row=sheet.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++){
			//System.out.println(row.getCell(i).getStringCellValue().trim());
			if(row.getCell(i).getStringCellValue().trim().equals(colName))
				colNum=i;
		}
		if(colNum==-1)
			return false;

		sheet.autoSizeColumn(colNum); 
		row = sheet.getRow(rowNum-1);
		if (row == null)
			row = sheet.createRow(rowNum-1);
		
		cell = row.getCell(colNum);	
		if (cell == null)
	        cell = row.createCell(colNum);

	    // cell style
	    //CellStyle cs = workbook.createCellStyle();
	    //cs.setWrapText(true);
	    //cell.setCellStyle(cs);
	    cell.setCellValue(data);

	    fileOut = new FileOutputStream(path);

		workbook.write(fileOut);

	    fileOut.close();	

		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	// returns true if data is set successfully else false
	public boolean setCellData(String sheetName,String colName,int rowNum, String data,String url){
		//System.out.println("setCellData setCellData******************");
		try{
		fis = new FileInputStream(path); 
		workbook = new XSSFWorkbook(fis);

		if(rowNum<=0)
			return false;
		
		int index = workbook.getSheetIndex(sheetName);
		int colNum=-1;
		if(index==-1)
			return false;
		
		
		sheet = workbook.getSheetAt(index);
		//System.out.println("A");
		row=sheet.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++){
			//System.out.println(row.getCell(i).getStringCellValue().trim());
			if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
				colNum=i;
		}
		
		if(colNum==-1)
			return false;
		sheet.autoSizeColumn(colNum); //ashish
		row = sheet.getRow(rowNum-1);
		if (row == null)
			row = sheet.createRow(rowNum-1);
		
		cell = row.getCell(colNum);	
		if (cell == null)
	        cell = row.createCell(colNum);
			
	    cell.setCellValue(data);
	    XSSFCreationHelper createHelper = workbook.getCreationHelper();

	    //cell style for hyperlinks
	    //by default hypelrinks are blue and underlined
	    CellStyle hlink_style = workbook.createCellStyle();
	    XSSFFont hlink_font = workbook.createFont();
	    hlink_font.setUnderline(XSSFFont.U_SINGLE);
	    hlink_font.setColor(IndexedColors.BLUE.getIndex());
	    hlink_style.setFont(hlink_font);
	    //hlink_style.setWrapText(true);

	    XSSFHyperlink link = createHelper.createHyperlink(XSSFHyperlink.LINK_FILE);
	    link.setAddress(url);
	    cell.setHyperlink(link);
	    cell.setCellStyle(hlink_style);
	      
	    fileOut = new FileOutputStream(path);
		workbook.write(fileOut);

	    fileOut.close();	

		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	// returns true if sheet is created successfully else false
	public boolean addSheet(String  sheetname){		
		
		FileOutputStream fileOut;
		try {
			 workbook.createSheet(sheetname);	
			 fileOut = new FileOutputStream(path);
			 workbook.write(fileOut);
		     fileOut.close();		    
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	// returns true if sheet is removed successfully else false if sheet does not exist
	public boolean removeSheet(String sheetName){		
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1)
			return false;
		
		FileOutputStream fileOut;
		try {
			workbook.removeSheetAt(index);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
		    fileOut.close();		    
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	// returns true if column is created successfully
	public boolean addColumn(String sheetName,String colName){
		//System.out.println("**************addColumn*********************");
		
		try{				
			fis = new FileInputStream(path); 
			workbook = new XSSFWorkbook(fis);
			int index = workbook.getSheetIndex(sheetName);
			if(index==-1)
				return false;
			
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		
		sheet=workbook.getSheetAt(index);
		
		row = sheet.getRow(0);
		if (row == null)
			row = sheet.createRow(0);
		
		//cell = row.getCell();	
		//if (cell == null)
		//System.out.println(row.getLastCellNum());
		if(row.getLastCellNum() == -1)
			cell = row.createCell(0);
		else
			cell = row.createCell(row.getLastCellNum());
	        
	        cell.setCellValue(colName);
	        cell.setCellStyle(style);
	        
	        fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
		    fileOut.close();		    

		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
		
		
	}
	// removes a column and all the contents
	public boolean removeColumn(String sheetName, int colNum) {
		try{
		if(!isSheetExist(sheetName))
			return false;
		fis = new FileInputStream(path); 
		workbook = new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
		XSSFCreationHelper createHelper = workbook.getCreationHelper();
		style.setFillPattern(HSSFCellStyle.NO_FILL);
		
	    
	
		for(int i =0;i<getRowCount(sheetName);i++){
			row=sheet.getRow(i);	
			if(row!=null){
				cell=row.getCell(colNum);
				if(cell!=null){
					cell.setCellStyle(style);
					row.removeCell(cell);
				}
			}
		}
		fileOut = new FileOutputStream(path);
		workbook.write(fileOut);
	    fileOut.close();
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
  // find whether sheets exists	
	public boolean isSheetExist(String sheetName){
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1){
			index=workbook.getSheetIndex(sheetName.toUpperCase());
				if(index==-1)
					return false;
				else
					return true;
		}
		else
			return true;
	}
	
	// returns number of columns in a sheet	
	public int getColumnCount(String sheetName){
		// check if sheet exists
		if(!isSheetExist(sheetName))
		 return -1;
		
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		
		if(row==null)
			return -1;
		
		return row.getLastCellNum();
	
	}
	
	// returns number of columns in a sheet	
		public int getColumnCount(String sheetName, int rowNumber){
			// check if sheet exists
			if(!isSheetExist(sheetName))
			 return -1;
			
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNumber);
			
			if(row==null)
				return -1;
			
			return row.getLastCellNum();
		
		}
	
	//String sheetName, String testCaseName,String keyword ,String URL,String message
	public boolean addHyperLink(String sheetName,String screenShotColName,String testCaseName,int index,String url,String message){
		//System.out.println("ADDING addHyperLink******************");
		
		url=url.replace('\\', '/');
		if(!isSheetExist(sheetName))
			 return false;
		
	    sheet = workbook.getSheet(sheetName);
	    
	    for(int i=2;i<=getRowCount(sheetName);i++){
	    	if(getCellData(sheetName, 0, i).equalsIgnoreCase(testCaseName)){
	    		//System.out.println("**caught "+(i+index));
	    		setCellData(sheetName, screenShotColName, i+index, message,url);
	    		break;
	    	}
	    }


		return true; 
	}
	public int getCellRowNum(String sheetName,String colName,String cellValue){
		
		for(int i=2;i<=getRowCount(sheetName);i++){
	    	if(getCellData(sheetName,colName , i).equalsIgnoreCase(cellValue)){
	    		return i;
	    	}
	    }
		return -1;
		
	}
		
	// to run this on stand alone
	public static void main(String arg[]) throws IOException{
		
		//System.out.println(filename);
		Xls_Reader datatable = null;
		

			 datatable = new Xls_Reader("H:\\Student_Selenium_Workspaces\\Framework_Weekend\\src\\Framework_XL_Files\\Controller.xlsx");
				for(int col=0 ;col< datatable.getColumnCount("TC5"); col++){
					System.out.println(datatable.getCellData("TC5", col, 1));
				}
	}
	
	
	public static String fn_GetCellData(String WbookPath, String SheetName, int RowNum, String ColumnName)
			throws IOException {

		FileInputStream FISObj = new FileInputStream(WbookPath);
		@SuppressWarnings("resource")
		XSSFWorkbook WbookObj = new XSSFWorkbook(FISObj);
		XSSFSheet WSheetObj = WbookObj.getSheet(SheetName);
		XSSFRow RowObj = WSheetObj.getRow(RowNum);
		int columnNumber = fn_GetCellNumberByColumName(WSheetObj, ColumnName);
		XSSFCell CellObj = RowObj.getCell(columnNumber, XSSFRow.CREATE_NULL_AS_BLANK);
		int celltypenumber = CellObj.getCellType();
		String CellVal = null;
		if (celltypenumber == XSSFCell.CELL_TYPE_NUMERIC) {
			Double DblCellVal = CellObj.getNumericCellValue();
			Integer intcellval = DblCellVal.intValue();
			CellVal = intcellval.toString();
		} else if (celltypenumber == XSSFCell.CELL_TYPE_STRING) {
			CellVal = CellObj.getStringCellValue();
		}
		return CellVal;
	}
	
	public static int fn_GetCellNumberByColumName(XSSFSheet WSheetObj, String ColumnName) throws IOException {

		XSSFRow FstRowObj = WSheetObj.getRow(0);
		int columnCount = FstRowObj.getLastCellNum();
		int columnNumber = 0;
		for (int i = 0; i <= columnCount - 1; i++) {
			XSSFCell cellObj = FstRowObj.getCell(i, XSSFRow.CREATE_NULL_AS_BLANK);
			String xl_ColumnName = cellObj.getStringCellValue();
			xl_ColumnName = xl_ColumnName.trim();
			ColumnName = ColumnName.trim();
			if (ColumnName.equalsIgnoreCase(xl_ColumnName) == true) {
				columnNumber = i;
				break;
			}
		}
		return columnNumber;
	}
	
	public HashMap<String, String> GetValue(String sheetName, String TestCaseName)		
	{
		
		HashMap<String , String> obj = new HashMap<String , String>();		
		int index = workbook.getSheetIndex(sheetName);

		if(index==-1)
			
		sheet = workbook.getSheetAt(index);
		int rowNo =getRowCount(sheetName);
		int coloumNo = (getColumnCount(sheetName));
		//int coloumNo = row.getLastCellNum();
		
		for(int i=0;i<=(rowNo-1);i++)
		{


			String Data = sheet.getRow(i).getCell(0).getStringCellValue();
			
			
			if(Data.contains(TestCaseName))
			{
				
				int count = i ;
				for(int j=1;j<=(coloumNo-1);j++)
				{
					int no = j;
					
					DataFormatter formatter = new DataFormatter();
					//String val = formatter.formatCellValue(sheet.getRow(row).getCell(col));
					
					String dummyValue = formatter.formatCellValue(sheet.getRow(count-1).getCell(j));
					obj.put(dummyValue, formatter.formatCellValue(sheet.getRow(count).getCell(no)));
					System.out.println(obj.keySet());
					
					
				}
				break;
				
			}



		}
		
		
		return obj;
		

	}

	
}
