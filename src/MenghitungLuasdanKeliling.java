import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenghitungLuasdanKeliling {

    public static void main(String[] args) {
        String csvFile = "src/data/data/trapezoid.csv";
        String line;
        String csvSplitBy = ",";
        List<DataTrapezoid> trapezoids = new ArrayList<>(); // Use DataTrapezoid

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                double base1 = Double.parseDouble(data[0]);
                double base2 = Double.parseDouble(data[1]);
                double height = Double.parseDouble(data[2]);

                DataTrapezoid trapezoid = new DataTrapezoid(base1, base2, height); // Use DataTrapezoid
                trapezoids.add(trapezoid);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (DataTrapezoid trapezoid : trapezoids) { // Use DataTrapezoid
            System.out.println(trapezoid);
        }
    }
}