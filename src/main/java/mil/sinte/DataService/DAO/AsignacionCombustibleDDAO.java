/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanAsignacionCombustibleD;
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
public interface AsignacionCombustibleDDAO extends JpaRepository<BeanAsignacionCombustibleD, String>{
    
    @Query(nativeQuery = true, value =  "SELECT CPERIODO_CODIGO,\n" +
                                        "       UTIL.FUN_BRIGADA_ABREVIATURA(NBRIGADA_CODIGO) NBRIGADA_CODIGO,\n" +
                                        "       UTIL.FUN_MESES_ABREVIATURA(CMES_CODIGO) CMES_CODIGO,\n" +
                                        "       UTIL.FUN_TIPO_ASIGNACION_ABREVIATUR(NTIPO_ASIGNACION_CODIGO) NTIPO_ASIGNACION_CODIGO,\n" +
                                        "       UTIL.FUN_TIPO_COMBUSTIBLE_ABREVIATU(NTIPO_COMBUSTIBLE_CODIGO) NTIPO_COMBUSTIBLE_CODIGO,\n" +
                                        "       UTIL.FUN_DEPENDENCIA_ABREVIATURA(NBRIGADA_CODIGO,NDEPENDENCIA_CODIGO) NDEPENDENCIA_CODIGO,\n" +
                                        "       UTIL.FUN_VEHICULO(NVEHICULO_CODIGO) NVEHICULO_CODIGO,\n" +
                                        "       NASIGNACION_DETALLE_CANTIDAD,\n" +
                                        "       NASIGNACION_DETALLE_SOLICITADO,\n" +
                                        "       NDEPENDENCIA_CODIGO VUSUARIO_CREADOR,\n" +
                                        "       NVEHICULO_CODIGO DUSUARIO_CREADOR,\n" +
                                        "       CASE WHEN (SELECT NASIGNACION_CANTIDAD \n" +
                                        "                    FROM SINTE_ASIGNACION_COMBUSTIBLE \n" +
                                        "                   WHERE CPERIODO_CODIGO = ?1\n" +
                                        "                     AND NBRIGADA_CODIGO = ?2\n" +
                                        "                     AND CMES_CODIGO =?3\n" +
                                        "                     AND NTIPO_ASIGNACION_CODIGO =?4\n" +
                                        "                     AND NTIPO_COMBUSTIBLE_CODIGO =?5) > 0 THEN 0 \n" +
                                        "            WHEN (SELECT CESTADO_CODIGO \n" +
                                        "                    FROM SINTE_ASIGNACION_COMBUSTIBLE \n" +
                                        "                   WHERE CPERIODO_CODIGO = ?1\n" +
                                        "                     AND NBRIGADA_CODIGO = ?2\n" +
                                        "                     AND CMES_CODIGO =?3\n" +
                                        "                     AND NTIPO_ASIGNACION_CODIGO =?4\n" +
                                        "                     AND NTIPO_COMBUSTIBLE_CODIGO =?5) = 'CE' THEN 0\n" +
                                        "            ELSE 1 END VUSUARIO_CODIGO\n" +
                                        "  FROM SINTE_ASIGNACION_COMBUSTIBLE_D\n" +
                                        " WHERE CPERIODO_CODIGO = ?1\n" +
                                        "   AND NBRIGADA_CODIGO = ?2\n" +
                                        "   AND CMES_CODIGO =?3\n" +
                                        "   AND NTIPO_ASIGNACION_CODIGO =?4\n" +
                                        "   AND NTIPO_COMBUSTIBLE_CODIGO =?5")
    List<BeanAsignacionCombustibleD> findAll(String periodo, Integer brigada, String mes, Integer tipoAsignacion, Integer tipoCombustible);
    
    
    @Query(nativeQuery = true, value =  "SELECT CPERIODO_CODIGO,\n" +
                                        "       '' NBRIGADA_CODIGO,\n" +
                                        "       '' CMES_CODIGO,\n" +
                                        "       '' NTIPO_ASIGNACION_CODIGO,\n" +
                                        "       '' NTIPO_COMBUSTIBLE_CODIGO,\n" +
                                        "       UTIL.FUN_TIPO_DEPENDENCIA_ABREVIATU(NDEPENDENCIA_CODIGO) NDEPENDENCIA_CODIGO,\n" +
                                        "       UTIL.FUN_VEHICULO(NVEHICULO_CODIGO) NVEHICULO_CODIGO,\n" +
                                        "       NASIGNACION_DETALLE_CANTIDAD,\n" +
                                        "       NASIGNACION_DETALLE_SOLICITADO,\n" +
                                        "       NDEPENDENCIA_CODIGO VUSUARIO_CREADOR,\n" +
                                        "       NVEHICULO_CODIGO DUSUARIO_CREADOR,\n" +
                                        "       '' VUSUARIO_CODIGO\n" +
                                        "  FROM SINTE_ASIGNACION_COMBUSTIBLE_D\n" +
                                        " WHERE CPERIODO_CODIGO =?1\n" +
                                        "   AND NBRIGADA_CODIGO =?2\n" +
                                        "   AND CMES_CODIGO =?3\n" +
                                        "   AND NTIPO_ASIGNACION_CODIGO =?4\n" +
                                        "   AND NTIPO_COMBUSTIBLE_CODIGO =?5")
    List<BeanAsignacionCombustibleD> findAllAprobacion(String periodo, Integer brigada, String mes, Integer tipoAsignacion, Integer tipoCombustible);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_ASIGNACION_COMBUSTIB_D(:periodo, :brigada, :mes, :tipoAsignacion, :tipoCombustible, :dependencia, :vehiculo, :cantidad, :solicitud, :usuario, :modo)}", nativeQuery = true)
    void sp_asignacion_combustible_d(
            @Param("periodo") String codigo,
            @Param("brigada") Integer nombre,
            @Param("mes") String mes,
            @Param("tipoAsignacion") Integer tipoAsignacion,
            @Param("tipoCombustible") Integer tipoCombustible,
            @Param("dependencia") Integer dependencia,
            @Param("vehiculo") Integer vehiculo,
            @Param("cantidad") Integer cantidad,
            @Param("solicitud") Integer solicitud,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
    
    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_ASIGNACION_COMBUSTIB_A(:periodo, :brigada, :mes, :tipoAsignacion, :tipoCombustible, :arrayDetalle, :usuario, :modo)}", nativeQuery = true)
    void sp_asignacion_combustible_a(
            @Param("periodo") String codigo,
            @Param("brigada") Integer nombre,
            @Param("mes") String mes,
            @Param("tipoAsignacion") Integer tipoAsignacion,
            @Param("tipoCombustible") Integer tipoCombustible,
            @Param("arrayDetalle") String arrayDetalle,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
    
}
