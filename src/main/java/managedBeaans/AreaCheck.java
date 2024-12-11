package managedBeaans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("areaCheck")
@SessionScoped
public class AreaCheck implements Serializable {

    public boolean isInArea(double x, double y, double r){
        return checkSquare(x, y, r) || checkCircle(x, y, r) || checkTriangle(x, y, r);
    }

    private boolean checkSquare(double x, double y, double r){
        return (y>=0 && y<=r && x >= 0 && x <= r);
    }

    private boolean checkCircle(double x, double y, double r){
        return (x * r >= 0 && y * r <= 0 && Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) <= r);
    }

    private boolean checkTriangle(double x, double y, double r){
        boolean withinXBounds = (0 >= x) && (x <= r/2);
        boolean withinYBounds = (y <= r / 2) && (y >= 0);
        boolean aboveHypotenuse = (y >= 0.5 * x + r / 2);

        return withinXBounds && withinYBounds && aboveHypotenuse;
    }
}
