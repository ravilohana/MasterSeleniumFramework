import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

//https://www.callicoder.com/java-read-write-csv-file-apache-commons-csv/
// read this article


public class CSVReader {
    public static void main(String[] args) {

        String filePath = "src/test/resources/csvFiles/us_tax_rates.csv";
/*
        try{
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            // Reading all records at once into memory
            List<CSVRecord> csvRecords = csvParser.getRecords();
            System.out.println(Arrays.toString(csvRecords.get(0).values()));
            /*
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String countryCode = csvRecord.get(0);
                String stateCode = csvRecord.get(1);
                String zipCode = csvRecord.get(2);
                String city = csvRecord.get(3);
                String rate = csvRecord.get(4);
                String taxName = csvRecord.get(5);


                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Country Code : " + countryCode);
                System.out.println("State Code : " + stateCode);
                System.out.println("Zip Code : " + zipCode);
                System.out.println("City : " + city);
                System.out.println("Rate% : " + rate);
                System.out.println("Tax Name : " + taxName);
                System.out.println("---------------\n\n");
            }


        }catch (Exception e){

        }
*/

        try{
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim());
            for (CSVRecord csvRecord : csvParser) {
                // Accessing values by Header names
                String countryCode = csvRecord.get("Country Code");
                String stateCode = csvRecord.get("State Code");
                String zipCode = csvRecord.get("Rate %");
                String city = csvRecord.get("Tax Name");



                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Country Code : " + countryCode);
                System.out.println("State Code : " + stateCode);
                System.out.println("Zip Code : " + zipCode);
                System.out.println("City : " + city);
                System.out.println("---------------\n\n");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
