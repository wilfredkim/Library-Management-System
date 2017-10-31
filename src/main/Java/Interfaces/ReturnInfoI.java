package Interfaces;

import Entities.ReturnInfo;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface ReturnInfoI {
    boolean recordInfo(ReturnInfo returnInfo);
    ArrayList<ReturnInfo> viewreturnInfo(ReturnInfo returnInfo);

}
