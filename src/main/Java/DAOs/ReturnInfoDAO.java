package DAOs;

import Entities.ReturnInfo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.ArrayList;

public class ReturnInfoDAO extends  CustomDAO<ReturnInfo> {

    public ReturnInfoDAO(EntityManager entityManager) {
        super(entityManager);
    }
    public boolean recordInfo(ReturnInfo returnInfo) {
        return  this.addCustom(returnInfo);
    }
    @SuppressWarnings("unchecked")
    public ArrayList<ReturnInfo> viewreturnInfo(ReturnInfo returnInfo) {
        try{
            return (ArrayList<ReturnInfo>) entityManager.createNamedQuery("viewreturnInfobyId").setParameter("issueBook",returnInfo.getIssuedBook()).getResultList();
        }catch (PersistenceException px) {
            px.printStackTrace();
            return null;
        }
    }
}
