/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanComisionDet;
import mil.sinte.DataService.DAO.ComisionDetDAO;
import mil.sinte.DataService.Service.ComisionDetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class ComisionDetServiceImpl implements ComisionDetService{

    @Autowired
    private ComisionDetDAO comisionDetDAO;
    
    @Override
    public List<BeanComisionDet> findAll(Integer codigo) {
        return comisionDetDAO.findAll(codigo);
    }
    
}
