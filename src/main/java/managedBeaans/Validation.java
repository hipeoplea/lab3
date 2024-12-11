package managedBeaans;


import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("validation")
@SessionScoped
public class Validation implements Serializable {
    public boolean validate(double x, double y, double r) {
        return (validateX(x) && validateY(y) && validateR(r));
    }

    private boolean validateX(double x) {
        double[] arr = new double[]{-3, -2, -1, 0, 1, 2, 3, 4, 5};
        for (double value : arr) {
            if (value == x) return true;
        }
        return false;
    }

    private boolean validateY(double y) {
        return y >= -3 && y <= 5;
    }

    private boolean validateR(double r) {
        return r >= 1 && r <= 4;
    }

}