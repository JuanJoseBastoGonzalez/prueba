/*package com.mycompany.prueba;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelCRUD {
    private String filePath;
    private Workbook workbook;
    private Sheet sheet;
    
    public ExcelCRUD(String filePath, String sheetName) throws IOException {
        this.filePath = filePath;
        
        File file = new File(filePath);
        if (file.exists()) {
            String extension = filePath.substring(filePath.lastIndexOf("."));
            FileInputStream fis = new FileInputStream(file);
            
            if (extension.equals(".xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else if (extension.equals(".xls")) {
                workbook = new HSSFWorkbook(fis);
            }
            
            fis.close();
        } else {
            // Crear nuevo archivo .xlsx por defecto si no existe
            workbook = new XSSFWorkbook();
        }
        
        sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            sheet = workbook.createSheet(sheetName);
            // Crear fila de encabezados si es una nueva hoja
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Nombre");
            headerRow.createCell(2).setCellValue("Edad");
            headerRow.createCell(3).setCellValue("Email");
            
            saveChanges();
        }
    }
    
    private void saveChanges() throws IOException {
        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        fos.close();
    }
    
    // CREATE
    public void addRecord(Map<String, String> data) throws IOException {
        int lastRowNum = sheet.getLastRowNum();
        Row newRow = sheet.createRow(lastRowNum + 1);
        
        newRow.createCell(0).setCellValue(data.getOrDefault("IDFDFDFD", ""));
        newRow.createCell(1).setCellValue(data.getOrDefault("Nombre", ""));
        newRow.createCell(2).setCellValue(data.getOrDefault("Edad", ""));
        newRow.createCell(3).setCellValue(data.getOrDefault("Email", ""));
        
        saveChanges();
    }
    
    // READ (todos los registros)
    public List<Map<String, String>> getAllRecords() {
        List<Map<String, String>> records = new ArrayList<>();
        
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Map<String, String> record = new HashMap<>();
                record.put("ID", getCellValue(row.getCell(0)));
                record.put("Nombre", getCellValue(row.getCell(1)));
                record.put("Edad", getCellValue(row.getCell(2)));
                record.put("Email", getCellValue(row.getCell(3)));
                
                records.add(record);
            }
        }
        
        return records;
    }
    
    // READ (un registro por ID)
    public Map<String, String> getRecordById(String id) {
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null && getCellValue(row.getCell(0)).equals(id)) {
                Map<String, String> record = new HashMap<>();
                record.put("ID", getCellValue(row.getCell(0)));
                record.put("Nombre", getCellValue(row.getCell(1)));
                record.put("Edad", getCellValue(row.getCell(2)));
                record.put("Email", getCellValue(row.getCell(3)));
                
                return record;
            }
        }
        return null;
    }
    
    // UPDATE
    public void updateRecord(String id, Map<String, String> newData) throws IOException {
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null && getCellValue(row.getCell(0)).equals(id)) {
                if (newData.containsKey("Nombre")) {
                    row.getCell(1).setCellValue(newData.get("Nombre"));
                }
                if (newData.containsKey("Edad")) {
                    row.getCell(2).setCellValue(newData.get("Edad"));
                }
                if (newData.containsKey("Email")) {
                    row.getCell(3).setCellValue(newData.get("Email"));
                }
                
                saveChanges();
                return;
            }
        }
    }
    
    // DELETE
    public void deleteRecord(String id) throws IOException {
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null && getCellValue(row.getCell(0)).equals(id)) {
                sheet.removeRow(row);
                
                // Mover las filas siguientes hacia arriba
                if (i < sheet.getLastRowNum()) {
                    sheet.shiftRows(i + 1, sheet.getLastRowNum(), -1);
                }
                
                saveChanges();
                return;
            }
        }
    }
    
    private String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }
    
    public void close() throws IOException {
        workbook.close();
    }
}*/