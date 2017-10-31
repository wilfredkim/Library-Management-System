package Beans;

import DAOs.ReturnInfoDAO;
import Entities.ReturnInfo;
import Interfaces.ReturnInfoI;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Stateless
@Local
public class ReturnInfoBean  implements ReturnInfoI {
    @PersistenceContext
    EntityManager entityManager;

    public boolean recordInfo(ReturnInfo returnInfo) {
        ReturnInfoDAO returnInfoDAO = new ReturnInfoDAO(entityManager);
      return   returnInfoDAO.recordInfo(returnInfo);
    }

    public ArrayList<ReturnInfo> viewreturnInfo(ReturnInfo returnInfo) {
        ReturnInfoDAO returnInfoDAO = new ReturnInfoDAO(entityManager);
        return   returnInfoDAO.viewreturnInfo(returnInfo);
    }
}
