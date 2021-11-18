package com.ubs.bptargets;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BpService {

    @Autowired
    private BpRepository repository;

    public void saveCsv() {
        if(repository.count() != 0) {
            repository.deleteAll(); // Clear DB each time when setting data
        }
            try {
                CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
                Path myPath = Paths.get("C:/UnrealEngine/db/bp_target.csv");
                BufferedReader br = Files.newBufferedReader(myPath, StandardCharsets.UTF_8);
                CSVReader reader = new CSVReaderBuilder(br).withSkipLines(1).withCSVParser(parser).build();
                int id = 0;
                List<String[]> rows = reader.readAll();
                for (String[] row : rows) {
                    id++;
                    BusinessParameter bp = new BusinessParameter();
                    LocalDate modificationDate = LocalDate.parse(row[7]);
                    bp.setId(id);
                    bp.setType(row[0]);
                    bp.setCategory(row[1]);
                    bp.setSubcategory(row[2]);
                    bp.setDescription(row[3]);
                    bp.setScope(row[4]);
                    bp.setValue(row[5]);
                    bp.setState(row[6]);
                    bp.setModified(modificationDate);
                    bp.setReason(row[8]);
                    repository.save(bp);
                }

                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void writeCsv() {
        //TODO Write csv
        //TODO Adjust website design
        //TODO Try using csv beans
        //TODO Clean up project
    }

    private void saveBpOld() {
        String line = "";
        if (repository.count() == 0) {
            try {
                BufferedReader br = new BufferedReader(new FileReader("src/main/resources/bp_target.csv"));
                int id = 0;

                System.out.println(br.readLine());

                while ((line = br.readLine()) != null) {
                    String[] data = line.split("\\|");

                    for (int i = 0; i < data.length; i++) {
                        data[i] = data[i].substring(1, data[i].length() - 1);
                    }

                    id++;
                    BusinessParameter bp = new BusinessParameter();
                    LocalDate modificationDate = LocalDate.parse(data[7]);
                    bp.setId(id);
                    bp.setType(data[0]);
                    bp.setCategory(data[1]);
                    bp.setSubcategory(data[2]);
                    bp.setDescription(data[3]);
                    bp.setScope(data[4]);
                    bp.setValue(data[5]);
                    bp.setState(data[6]);
                    bp.setModified(modificationDate);
                    bp.setReason(data[8]);

                    repository.save(bp);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Database not empty!");
        }
    }
}
