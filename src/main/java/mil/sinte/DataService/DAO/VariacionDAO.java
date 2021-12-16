/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.DAO;

import java.sql.Date;
import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanVariacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Repository
public interface VariacionDAO extends JpaRepository<BeanVariacion, String>{
    
   @Query(nativeQuery = true, value =   "SELECT NASIGNACION_VARIACION_CODIGO,\n" +
                                        "       CPERIODO_CODIGO,\n" +
                                        "       UTIL.FUN_BRIGADA_ABREVIATURA(NBRIGADA_CODIGO) NBRIGADA_CODIGO,\n" +
                                        "       NBRIGADA_CODIGO CODIGO_BRIGADA,\n" +
                                        "       UTIL.FUN_MESES_ABREVIATURA(CMES_CODIGO) CMES_CODIGO,\n" +
                                        "       CMES_CODIGO CODIGO_MES,\n" +
                                        "       UTIL.FUN_TIPO_ASIGNACION_ABREVIATUR(NTIPO_ASIGNACION_CODIGO) NTIPO_ASIGNACION_CODIGO,\n" +
                                        "       NTIPO_ASIGNACION_CODIGO CODIGO_ASIGNACION,\n" +
                                        "       UTIL.FUN_TIPO_COMBUSTIBLE_ABREVIATU(NTIPO_COMBUSTIBLE_CODIGO) NTIPO_COMBUSTIBLE_CODIGO,\n" +
                                        "       NTIPO_COMBUSTIBLE_CODIGO CODIGO_COMBUSTIBLE,\n" +
                                        "       DASIGNACION_VARIACION_FECHA,\n" +
                                        "       VASIGNACION_VARIACION_JUSTIFIC,\n" +
                                        "       UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO, \n" +
                                        "       VASIGNACION_VARIACION_RECHAZO\n" +
                                        "  FROM SINTE_ASIGNACION_VARIACION\n" +
                                        " WHERE CPERIODO_CODIGO = ?1\n" +
                                        "   AND NBRIGADA_CODIGO = ?2\n" +
                                        "   AND CMES_CODIGO = ?3")
    List<BeanVariacion> findAll(String periodo, Integer brigada, String mes);  
    
    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_ASIGNACION_VARIACION(:codigo, :periodo, :brigada, :mes, :asignacion, "
            + ":combustible, :fecha, :justificacion, :rechazo, :lista, :usuario, :modo)}", nativeQuery = true)
    void sp_variacion(
            @Param("codigo") Integer codigo,
            @Param("periodo") String periodo,
            @Param("brigada") Integer brigada,
            @Param("mes") String mes,
            @Param("asignacion") Integer asignacion,
            @Param("combustible") Integer combustible,
            @Param("fecha") Date fecha,
            @Param("justificacion") String justificacion,
            @Param("rechazo") String rechazo,
            @Param("lista") String lista,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
    
    
}
