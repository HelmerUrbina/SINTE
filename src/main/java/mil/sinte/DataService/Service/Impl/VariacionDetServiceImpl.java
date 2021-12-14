/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanVariacionDet;
import mil.sinte.DataService.DAO.VariacionDetDAO;
import mil.sinte.DataService.Service.VariacionDetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class VariacionDetServiceImpl implements VariacionDetService{

    @Autowired
    private VariacionDetDAO variacionDetDAO;
    
    @Override
    public List<BeanVariacionDet> getBeanVariacionDets(Integer codigo) {
        return variacionDetDAO.findAll(codigo);
    }
    
}
