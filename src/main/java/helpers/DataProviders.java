package helpers;


import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataProviders {
        private static final String PATH = "src/main/resources/data.txt";

        @DataProvider(name = "usersData")
        public static Object[][] usersLogins() throws IOException {
            List<String> rows = readLines(new File(PATH));
            int rowsNumber = rows.size();
            int dataInRow = rows.get(0).split(",").length;
            Object[][] data = new Object[rowsNumber][dataInRow];
            for (int i = 0; i < rows.size(); i++) {
                Object[] currentRow = rows.get(i).split(",");
                data[i] = currentRow;
            }
            return data;
        }

        private static List<String> readLines(File source) throws IOException {
            try (FileReader inputStream = new FileReader(source);
                 BufferedReader in = new BufferedReader(inputStream)) {
                List<String> strings = new ArrayList<>();
                String line;
                while ((line = in.readLine()) != null) {
                    strings.add(line);
                }
                return strings;
            }
        }
}
