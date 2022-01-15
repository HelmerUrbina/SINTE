/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mil.sinte.UserServices.Grifos;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.DataService.Service.GrifoDespachoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Controller
@Slf4j
public class GrifoDespachoController {

    @Autowired
    private GrifoDespachoService grifoDespachoService;

    @RequestMapping(value = "/GrifoDespacho")
    public String getGrifoDespacho(String mode) {
        switch (mode) {
            case "grifoDespacho":
                return "Grifos/GrifoDespacho";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/GrifoDespachoDetalle")
    @ResponseBody
    public String getGrifoDespachoDetalle(String mode, String placa) {
        switch (mode) {
            case "G":
                return new Gson().toJson(grifoDespachoService.getDespachoByPlaca(placa));
            default:
                return "ERROR";
        }
    }

}
