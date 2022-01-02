/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.UserServices.ClaseIII;

import com.google.gson.Gson;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanAsignacionCombustible;
import mil.sinte.BusinessServices.Beans.BeanAsignacionCombustibleDetalle;
import mil.sinte.BusinessServices.Beans.BeanMatrizAsignacion;
import mil.sinte.DataService.Service.AsignacionCombustibleService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import mil.sinte.DataService.Service.AsignacionCombustibleDetalleService;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Controller
@Slf4j
public class AsignacionCombustibleController {

    @Autowired
    private AsignacionCombustibleService asignacionCombustibleService;

    @Autowired
    private AsignacionCombustibleDetalleService asignacionCombustibleDService;

    @RequestMapping(value = "/AsignacionCombustible")
    public String getAsignacionCombustible(String mode) {
        switch (mode) {
            case "asignacionCombustible":
                return "ClaseIII/AsignacionCombustible";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/AsignacionCombustibleAprobacion")
    public String getAsignacionCombustibleAprobacion(String mode) {
        switch (mode) {
            case "asignacionCombustibleAprobacion":
                return "ClaseIII/AsignacionCombustibleAprobacion";
            case "asignacionCombustibleAprobacionII":
                return "ClaseIII/AsignacionCombustibleAprobacionII";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/AsignacionCombustibleDetalle")
    @ResponseBody
    public String getAsignacionCombustibleDetalle(String mode, String periodo, String brigada, String mes, String tipoAsignacion) {
        switch (mode) {
            case "G":
                return new Gson().toJson(asignacionCombustibleService.getAsignacionCombustibles(periodo, brigada, mes, tipoAsignacion));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduAsignacionCombustible")
    @ResponseBody
    public String setAsignacionCombustible(
            @RequestParam("mode") String mode,
            @RequestParam("periodo") String periodo,
            @RequestParam("brigada") String brigada,
            @RequestParam("mes") String mes,
            @RequestParam("tipoAsignacion") String tipoAsignacion,
            @RequestParam("tipoCombustible") String tipoCombustible) {
        BeanAsignacionCombustible objAsignacionCombustible = new BeanAsignacionCombustible();
        objAsignacionCombustible.setPeriodo(periodo);
        objAsignacionCombustible.setBrigada(brigada);
        objAsignacionCombustible.setMes(mes);
        objAsignacionCombustible.setTipoAsignacion(tipoAsignacion);
        objAsignacionCombustible.setTipoCombustible(tipoCombustible);
        return "" + asignacionCombustibleService.guardarAsignacionCombustible(objAsignacionCombustible, Utiles.getUsuario(), mode);
    }

    @RequestMapping(value = "/IduAsignacionCombustibleAprobacion")
    @ResponseBody
    public String setAsignacionCombustibleAprobacion(
            @RequestParam("mode") String mode,
            @RequestParam("periodo") String periodo,
            @RequestParam("brigada") String brigada,
            @RequestParam("mes") String mes,
            @RequestParam("tipoAsignacion") String tipoAsignacion,
            @RequestParam("arrayDetalle") String arrayDetalle) {
        BeanAsignacionCombustible objAsignacionCombustible = new BeanAsignacionCombustible();
        objAsignacionCombustible.setPeriodo(periodo);
        objAsignacionCombustible.setBrigada(brigada);
        objAsignacionCombustible.setMes(mes);
        objAsignacionCombustible.setTipoAsignacion(tipoAsignacion);
        objAsignacionCombustible.setEstado(arrayDetalle);

        return "" + asignacionCombustibleService.guardarAsignacionCombustibleAprobacion(objAsignacionCombustible, Utiles.getUsuario(), mode);
    }

    @RequestMapping(value = "/IduAsignacionCombustibleAprobacion2")
    @ResponseBody
    public String setAsignacionCombustibleAprobacion2(
            @RequestParam("mode") String mode,
            @RequestParam("periodo") String periodo,
            @RequestParam("mes") String mes,
            @RequestParam("tipoAsignacion") String tipoAsignacion,
            @RequestParam("arrayDetalle") String arrayDetalle) {
        BeanAsignacionCombustible objAsignacionCombustible = new BeanAsignacionCombustible();
        objAsignacionCombustible.setPeriodo(periodo);
        objAsignacionCombustible.setMes(mes);
        objAsignacionCombustible.setTipoAsignacion(tipoAsignacion);
        objAsignacionCombustible.setEstado(arrayDetalle);

        return "" + asignacionCombustibleService.guardarAsignacionCombustibleAprobacion2(objAsignacionCombustible, Utiles.getUsuario(), mode);
    }

    @RequestMapping(value = "/AsignacionCombustibleDDetalle")
    @ResponseBody
    public String getAsignacionCombustibleDDetalle(String mode, String periodo, String brigada, String mes, String tipoAsignacion, String tipoCombustible) {
        switch (mode) {
            case "G":
                return new Gson().toJson(asignacionCombustibleDService.getAsignacionCombustibleDs(periodo, brigada, mes, tipoAsignacion, tipoCombustible));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduAsignacionCombustibleD")
    @ResponseBody
    public String setAsignacionCombustibleD(
            @RequestParam("mode") String mode,
            @RequestParam("periodo") String periodo,
            @RequestParam("brigada") String brigada,
            @RequestParam("mes") String mes,
            @RequestParam("tipoAsignacion") String tipoAsignacion,
            @RequestParam("tipoCombustible") String tipoCombustible,
            @RequestParam("dependencia") String dependencia,
            @RequestParam("vehiculo") String vehiculo,
            @RequestParam("cantidad") Integer cantidad,
            @RequestParam("solicitado") Integer solicitado
    ) {
        BeanAsignacionCombustibleDetalle objAsignacionCombustibleD = new BeanAsignacionCombustibleDetalle();
        objAsignacionCombustibleD.setPeriodo(periodo);
        objAsignacionCombustibleD.setBrigada(brigada);
        objAsignacionCombustibleD.setMes(mes);
        objAsignacionCombustibleD.setTipoAsignacion(tipoAsignacion);
        objAsignacionCombustibleD.setTipoCombustible(tipoCombustible);
        objAsignacionCombustibleD.setDependencia(dependencia);
        objAsignacionCombustibleD.setVehiculo(vehiculo);
        objAsignacionCombustibleD.setCantidad(cantidad);
        objAsignacionCombustibleD.setSolicitado(solicitado);

        return "" + asignacionCombustibleDService.guardarAsignacionCombustibleD(objAsignacionCombustibleD, Utiles.getUsuario(), mode);
    }

    @RequestMapping(value = "/AsignacionCombustibleADetalle")
    @ResponseBody
    public String getAsignacionCombustibleADetalle(String mode, String periodo, String brigada, String mes, String tipoAsignacion, String tipoCombustible) {
        switch (mode) {
            case "G":
                return new Gson().toJson(asignacionCombustibleDService.getAsignacionCombustibleA(periodo, brigada, mes, tipoAsignacion, tipoCombustible));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduAsignacionCombustibleA")
    @ResponseBody
    public String setAsignacionCombustibleA(
            @RequestParam("mode") String mode,
            @RequestParam("periodo") String periodo,
            @RequestParam("brigada") String brigada,
            @RequestParam("mes") String mes,
            @RequestParam("tipoAsignacion") String tipoAsignacion,
            @RequestParam("tipoCombustible") String tipoCombustible,
            @RequestParam("arrayDetalle") String arrayDetalle
    ) {
        BeanAsignacionCombustibleDetalle objAsignacionCombustibleD = new BeanAsignacionCombustibleDetalle();
        objAsignacionCombustibleD.setPeriodo(periodo);
        objAsignacionCombustibleD.setBrigada(brigada);
        objAsignacionCombustibleD.setMes(mes);
        objAsignacionCombustibleD.setTipoAsignacion(tipoAsignacion);
        objAsignacionCombustibleD.setTipoCombustible(tipoCombustible);
        objAsignacionCombustibleD.setVehiculo(arrayDetalle);

        return "" + asignacionCombustibleDService.guardarAsignacionCombustibleA(objAsignacionCombustibleD, Utiles.getUsuario(), mode);
    }

    @RequestMapping(value = "/AsignacionCombustibleAIIDetalle")
    @ResponseBody
    public String getAsignacionCombustibleAIIDetalle(String mode, String periodo, String mes, String tipoAsignacion) {
        switch (mode) {
            case "G":
                List<BeanMatrizAsignacion> list = asignacionCombustibleService.getMatrizAsignacion(periodo, mes, tipoAsignacion);
                System.out.println("salio bueno :3" + list.size());
                // System.out.println(new Gson().toJson(asignacionCombustibleService.getMatrizAsignacion(periodo, mes, tipoAsignacion))+"");
                return new Gson().toJson(asignacionCombustibleService.getMatrizAsignacion(periodo, mes, tipoAsignacion));
            default:
                return "ERROR";
        }
    }

}
