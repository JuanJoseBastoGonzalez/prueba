package com.mycompany.prueba;

import java.awt.Menu;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.*;
import org.apache.poi.ss.util.CellReference;

public class Prueba {
    /*public static void main(String[] args) {
        // 1. Configuración de archivos
        Menu_principal menu_principal = new Menu_principal();
        menu_principal.setVisible(true);

        String jsonPath = "datos.json";
        String excelPath = "datos.xlsx";

        try {
            // 2. Leer archivo JSON
            FileInputStream jsonFis = new FileInputStream(jsonPath);
            JSONObject json = new JSONObject(new JSONTokener(jsonFis));
            jsonFis.close();

            // 3. Extraer valores con manejo de nulos
            String tipoDocumento = json.optString("tipoDocumento", "---");
            String noDocumento = json.optString("noDocumento", "---");
            String noPlaca = json.optString("noPlaca", "---");
            String procedencia = json.optString("procedencia", "---");

            // 4. Modificar Excel
            FileInputStream excelFis = new FileInputStream(excelPath);
            Workbook workbook = new XSSFWorkbook(excelFis);
            Sheet sheet = workbook.getSheetAt(0);

            // Asignación a celdas específicas
            setCellValue(sheet, "A10", tipoDocumento);      // Tipo Documento en A10
            setCellValue(sheet, "G12", noDocumento);       // N° Documento en G12
            setCellValue(sheet, "D14", noPlaca);           // Placa en D14
            setCellValue(sheet, "B5", procedencia);        // Procedencia en B5

            // 5. Guardar cambios
            FileOutputStream fos = new FileOutputStream(excelPath);
            workbook.write(fos);
            
            // Cerrar recursos
            fos.close();
            excelFis.close();
            workbook.close();

            System.out.println("Excel actualizado correctamente!");
            System.out.println("\nValores insertados:");
            System.out.println("A10 (Tipo Documento): " + tipoDocumento);
            System.out.println("G12 (N° Documento): " + noDocumento);
            System.out.println("D14 (Placa): " + noPlaca);
            System.out.println("B5 (Procedencia): " + procedencia);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void setCellValue(Sheet sheet, String cellRef, String value) {
        CellReference ref = new CellReference(cellRef);
        Row row = sheet.getRow(ref.getRow());
        if (row == null) {
            row = sheet.createRow(ref.getRow());
        }
        Cell cell = row.getCell(ref.getCol());
        if (cell == null) {
            cell = row.createCell(ref.getCol());
        }
        cell.setCellValue(value);
    }*/
}