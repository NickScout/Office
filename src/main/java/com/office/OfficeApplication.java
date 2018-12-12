package com.office;

import com.office.dao.EmployeeDAO;
import com.office.dao.PositionDAO;
import com.office.entity.Employee;
import com.office.entity.Position;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OfficeApplication {

    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private PositionDAO positionDAO;

    @PostConstruct
    public void Boot() {
        AttemptFirstBoot();

    }

    public void AttemptFirstBoot() {
        if (positionDAO.count() == 0) { //check is positions table is empty
            //if it is, fill in basic positions

            Position CEO = new Position();
            CEO.setName("CEO");
            CEO.setDescription("Boss of the gym");
            CEO.setSalary(999999);

            Position Private = new Position();
            Private.setName("Private");
            Private.setDescription("Loves Landsknechts and Blackwater");
            Private.setSalary(700);

            Position Officer = new Position();
            Officer.setName("Officer");
            Officer.setDescription("Thinks he is irreplaceable");
            Officer.setSalary(1500);

            Position Colonel = new Position();
            Colonel.setName("Colonel");
            Colonel.setDescription("Tough son of a bitch");
            Colonel.setSalary(2500);

            Position FieldMedic = new Position();
            FieldMedic.setName("Private medic");
            FieldMedic.setDescription("Keeps Hyppocrates owe in his own way");
            FieldMedic.setSalary(2500);

            var positions = new ArrayList<Position>();
            positions.add(CEO);
            positions.add(Private);
            positions.add(Officer);
            positions.add(Colonel);
            positions.add(FieldMedic);

            positionDAO.saveAll(positions);

        }

        if(!employeeDAO.findById(new Long(1)).isPresent()){
            Employee NickScout = new Employee();
            NickScout.setName("Nick Scout");
            NickScout.setBirth(Date.valueOf("1997-12-08"));
            NickScout.setPosition(positionDAO.findById(new Long(1)).get());
            employeeDAO.save(NickScout);
        }

    }

    public static void main(String[] args) {
	    SpringApplication.run(OfficeApplication.class, args);

	}
}
