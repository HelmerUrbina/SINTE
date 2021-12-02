/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanMatrizAsignacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Repository
public interface MatrizAsignacionDAO extends CrudRepository<BeanMatrizAsignacion, String>{
    
     @Query(nativeQuery = true, value =     "SELECT BRIGADA,\n" +
                                            "       NBRIGADA_CODIGO,\n" +
                                            "       ESTADO,\n" +
                                            "       CESTADO_CODIGO,\n" +
                                            "       COALESCE(COMBUSTIBLE_1_S,0) COMBUSTIBLE_1_S,\n" +
                                            "       COALESCE(COMBUSTIBLE_1_C,0) COMBUSTIBLE_1_C,\n" +
                                            "       COALESCE(COMBUSTIBLE_2_S,0) COMBUSTIBLE_2_S,\n" +
                                            "       COALESCE(COMBUSTIBLE_2_C,0) COMBUSTIBLE_2_C,\n" +
                                            "       COALESCE(COMBUSTIBLE_3_S,0) COMBUSTIBLE_3_S,\n" +
                                            "       COALESCE(COMBUSTIBLE_3_C,0) COMBUSTIBLE_3_C,\n" +
                                            "       COALESCE(COMBUSTIBLE_4_S,0) COMBUSTIBLE_4_S,\n" +
                                            "       COALESCE(COMBUSTIBLE_4_C,0) COMBUSTIBLE_4_C,\n" +
                                            "       COALESCE(COMBUSTIBLE_5_S,0) COMBUSTIBLE_5_S,\n" +
                                            "       COALESCE(COMBUSTIBLE_5_C,0) COMBUSTIBLE_5_C\n" +
                                            "FROM   (    SELECT NTIPO_COMBUSTIBLE_CODIGO,\n" +
                                            "                   NASIGNACION_SOLICITADO,\n" +
                                            "                   NASIGNACION_CANTIDAD,\n" +
                                            "                   UTIL.FUN_BRIGADA_ABREVIATURA(NBRIGADA_CODIGO) BRIGADA,\n"+
                                            "                   NBRIGADA_CODIGO,\n"+
                                            "                   UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) ESTADO,\n" +
                                            "                   CESTADO_CODIGO \n" +
                                            "              FROM SINTE_ASIGNACION_COMBUSTIBLE\n" +
                                            "             WHERE CPERIODO_CODIGO = ?1\n" +
                                            "               AND CMES_CODIGO = ?2\n" +
                                            "               AND NTIPO_ASIGNACION_CODIGO = ?3)\n" +
                                            "PIVOT  (SUM(NASIGNACION_SOLICITADO) AS S, SUM(NASIGNACION_CANTIDAD) AS C  FOR (NTIPO_COMBUSTIBLE_CODIGO) IN (1  AS COMBUSTIBLE_1,2 AS COMBUSTIBLE_2,3 AS COMBUSTIBLE_3,4 AS COMBUSTIBLE_4,5 AS COMBUSTIBLE_5))")
    List<BeanMatrizAsignacion> findMatriz(String periodo, String mes, Integer tipoAsignacion);

}
