package com.valtech.talent.program.mariokart.driver;

import com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model.Driver;
import com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model.DriverCategory;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Slf4j
public class ExcelDriverRepository implements DriverRepository {
    public Collection<Driver> loadDrivers() {
        List results = new ArrayList();
        try {

            InputStream excelFile = this.getClass().getResourceAsStream(("/drivers.xlsx"));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);
            log.info("Datasheet name : {}", sheet.getSheetName());

            sheet.iterator().forEachRemaining(row -> {
                String driverName = checkCell(row, 0);
                String category = checkCell(row, 1);
                category =category.isBlank() ? "M":category;
                if(!driverName.isBlank()) {
                    log.debug("driver {} {}", driverName, category);
                    results.add(new Driver(driverName, DriverCategory.valueOf(category)));
                }
            });


        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return results;
    }

    private String checkCell(Row row, int index) {
        return Optional.ofNullable(row.getCell(index))
                .filter(cell -> cell.getCellType() == CellType.STRING)
                .map(Cell::getStringCellValue)
                .filter(DriverUtils::validateLine).orElse("");
    }
}
