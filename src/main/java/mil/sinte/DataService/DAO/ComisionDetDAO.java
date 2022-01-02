/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanComisionDet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Repository
public interface ComisionDetDAO extends JpaRepository<BeanComisionDet, String> {

    @Query(nativeQuery = true, value = "SELECT NASIGNACION_COMISION_DETALLE CODIGO,\n"
            + "        UTIL.FUN_DEPENDENCIA_ABREVIATURA(NBRIGADA_CODIGO, NDEPENDENCIA_CODIGO) DEPENDENCIA,\n"
            + "        NDEPENDENCIA_CODIGO CODIGO_DEPENDENCIA,\n"
            + "        UTIL.FUN_VEHICULO(NVEHICULO_CODIGO) VEHICULO,\n"
            + "        NVEHICULO_CODIGO CODIGO_VEHICULO,\n"
            + "        UTIL.FUN_TIPO_COMBUSTIBLE_ABREVIATU(NTIPO_COMBUSTIBLE_CODIGO) COMBUSTIBLE,\n"
            + "        NTIPO_COMBUSTIBLE_CODIGO CODIGO_COMBUSTIBLE,\n"
            + "        NASIGNACION_COMISION_CANTIDAD,\n"
            + "        NASIGNACION_COMISION_DISTANCIA\n"
            + "   FROM SINTE_ASIGNACION_COMISION_DETA\n"
            + "  WHERE NASIGNACION_COMISION_CODIGO = ?1\n"
            + "  ORDER BY CODIGO")
    List<BeanComisionDet> findAll(Integer codigo);

}
