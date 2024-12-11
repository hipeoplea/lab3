package beans;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import managedBeaans.DataBaseManager;
import models.Point;

import java.io.Serializable;
import java.util.ArrayList;

@Setter
@Getter
@Named("points")
@SessionScoped
public class PointsContainer implements Serializable {
    private ArrayList<Point> points = new ArrayList<>();

    @EJB
    DataBaseManager dataBaseManager;

//    @PostConstruct
//    @Transactional
//    public void init(){
//        points = dataBaseManager.getPoints();
//    }
}
