/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanVariacionDet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Repository
public interface VariacionDetDAO extends JpaRepository<BeanVariacionDet, String>{
    
    @Query(nativeQuery = true, value =  "SELECT UTIL.FUN_DEPENDENCIA_ABREVIATURA(NBRIGADA_CODIGO, NDEPENDENCIA_CODIGO) NDEPENDENCIA_CODIGO,\n" +
                                        "       NDEPENDENCIA_CODIGO CODIGO_DEPENDENCIA,\n" +
                                        "       UTIL.FUN_VEHICULO(NVEHICULO_CODIGO) NVEHICULO_CODIGO,\n" +
                                        "       NVEHICULO_CODIGO CODIGO_VEHICULO,\n" +
                                        "       CASE WHEN CASIGNACION_VARIACION_TIPO='1' THEN 'ANULACIÓN' ELSE 'CREDITO' END CASIGNACION_VARIACION_TIPO,\n" +
                                        "       CASIGNACION_VARIACION_TIPO CODIGO_TIPO_ASIGNACION,\n" +
                                        "       NASIGNACION_VARIACION_CANTIDAD,\n" +
                                        "       VASIGNACION_VARIACION_JUSTIFIC\n" +
                                        "  FROM SINTE_ASIGNACION_VARIACION_DET\n" +
                                        " WHERE NASIGNACION_VARIACION_CODIGO = ?1")
    List<BeanVariacionDet> findAll(Integer codigo);
    
}
