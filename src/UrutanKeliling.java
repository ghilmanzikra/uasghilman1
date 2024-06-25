import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UrutanKeliling {
    public static void main(String[] args) {
        String csvFile = "src/data/data/trapezoid.csv";
        String line;
        String csvSplitBy = ",";
        List<DataTrapezoid> trapezoids = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                double base1 = Double.parseDouble(data[0]);
                double base2 = Double.parseDouble(data[1]);
                double height = Double.parseDouble(data[2]);

                DataTrapezoid trapezoid = new DataTrapezoid(base1, base2, height);
                trapezoids.add(trapezoid);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort trapezoids by perimeter
        Collections.sort(trapezoids, new Comparator<DataTrapezoid>() {
            @Override
            public int compare(DataTrapezoid t1, DataTrapezoid t2) {
                return Double.compare(t1.calculatePerimeter(), t2.calculatePerimeter());
            }
        });

        int index = 1;
        for (DataTrapezoid trapezoid : trapezoids) {
            System.out.println("keliling " + index + ": " + trapezoid.calculatePerimeter());
            index++;
        }
    }
}
