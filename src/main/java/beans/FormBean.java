package beans;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import managedBeaans.AreaCheck;
import managedBeaans.DataBaseManager;
import managedBeaans.Validation;
import models.Point;

import java.io.Serializable;

@Named("formBean")
@Getter
@Setter
@SessionScoped
public class FormBean implements Serializable {

    @Inject
    Validation validation;

    @Inject
    AreaCheck areaCheck;

    @Inject
    PointsContainer pointsContainer;

    @EJB
    DataBaseManager dataBaseManager;

    private Double x;

    private Double y;

    private Double r;

    @Transactional
    public String submit(){
        if (validation.validate(x, y, r)){
            Point point = new Point(x,y,r, areaCheck.isInArea(x, y, r));
            System.out.println(point);
            dataBaseManager.insertIntoTable(point);
            pointsContainer.getPoints().add(0, point);
        }
        return null;
    }


}
