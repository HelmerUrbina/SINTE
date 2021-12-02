package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanCombos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Repository
public interface CombosDAO extends CrudRepository<BeanCombos, String> {

    @Query(nativeQuery = true, value = "SELECT "
            + "CPERIODO_CODIGO AS CODIGO, CPERIODO_CODIGO AS DESCRIPCION "
            + "FROM SINTE_PERIODOS WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getPeriodos();

    @Query(nativeQuery = true, value = "SELECT "
            + "NDIVISION_EJERCITO_CODIGO AS CODIGO, VDIVISION_EJERCITO_ABREVIATURA AS DESCRIPCION "
            + "FROM SINTE_DIVISION_EJERCITO WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getDivisionEjercito();

    @Query(nativeQuery = true, value = "SELECT "
            + "NTIPO_COMBUSTIBLE_CODIGO AS CODIGO, VTIPO_COMBUSTIBLE_ABREVIATURA AS DESCRIPCION "
            + "FROM SINTE_TIPO_COMBUSTIBLE WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getTipoCombustible();

    @Query(nativeQuery = true, value = "SELECT "
            + "CDEPARTAMENTO_CODIGO AS CODIGO, VDEPARTAMENTO_NOMBRE AS DESCRIPCION "
            + "FROM SINTE_DEPARTAMENTO WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getDepartamentos();

    @Query(nativeQuery = true, value = "SELECT "
            + "CPROVINCIA_CODIGO AS CODIGO, VPROVINCIA_NOMBRE AS DESCRIPCION "
            + "FROM SINTE_PROVINCIA WHERE "
            + "CDEPARTAMENTO_CODIGO=?1 AND "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getProvincias(String departamento);

    @Query(nativeQuery = true, value = "SELECT "
            + "CUBIGEO_CODIGO AS CODIGO, VUBIGEO_NOMBRE AS DESCRIPCION "
            + "FROM SINTE_UBIGEO WHERE "
            + "CDEPARTAMENTO_CODIGO=?1 AND "
            + "CPROVINCIA_CODIGO=?2 AND "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getUbigeo(String departamento, String provincia);

    @Query(nativeQuery = true, value = "SELECT "
            + "NTIPO_DEPENDENCIA_CODIGO AS CODIGO, VTIPO_DEPENDENCIA_ABREVIATURA AS DESCRIPCION "
            + "FROM SINTE_TIPO_DEPENDENCIA WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getTipoDependencia();

    @Query(nativeQuery = true, value = "SELECT "
            + "NVEHICULO_TIPO_CODIGO CODIGO, VVEHICULO_TIPO_DESCRIPCION DESCRIPCION "
            + "FROM SINTE_VEHICULO_TIPO WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getTipoVehiculo();

    @Query(nativeQuery = true, value = "SELECT "
            + "NVEHICULO_CLASE_CODIGO CODIGO, VVEHICULO_CLASE_DESCRIPCION DESCRIPCION "
            + "FROM SINTE_VEHICULO_CLASE WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getClaseVehiculo();

    @Query(nativeQuery = true, value = "SELECT "
            + "NMARCA_CODIGO CODIGO, VMARCA_NOMBRE DESCRIPCION "
            + "FROM SINTE_MARCAS WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getMarca();

    @Query(nativeQuery = true, value = "SELECT "
            + "NMARCA_MODELO_CODIGO CODIGO, VMARCA_MODELO_DESCRIPCION DESCRIPCION "
            + "FROM SINTE_MARCAS_MODELOS WHERE "
            + "NMARCA_CODIGO=?1 AND "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getModelo(String marca);

    @Query(nativeQuery = true, value = "SELECT "
            + "NCOLOR_CODIGO CODIGO, VCOLOR_DESCRIPCION DESCRIPCION "
            + "FROM SINTE_COLORES WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getColor();

    @Query(nativeQuery = true, value = "SELECT "
            + "NSOAT_ASEGURADORA_CODIGO CODIGO, VSOAT_ASEGURADORA_NOMBRE DESCRIPCION "
            + "FROM SINTE_SOAT_ASEGURADORA WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getSoat();

    @Query(nativeQuery = true, value = "SELECT "
            + "NAREA_LABORAL_CODIGO CODIGO, VAREA_LABORAL_DESCRIPCION DESCRIPCION "
            + "FROM SINTE_AREA_LABORAL WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getAreaLaboral();

    @Query(nativeQuery = true, value = "SELECT "
            + "NUSUARIO_ROL_CODIGO CODIGO, VUSUARIO_ROL_NOMBRE DESCRIPCION "
            + "FROM SINTE_USUARIOS_ROLES WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getRol();

    @Query(nativeQuery = true, value = "SELECT "
            + "NVEHICULO_CODIGO CODIGO, VVEHICULO_PLACA DESCRIPCION "
            + "FROM SINTE_VEHICULOS WHERE "
            + "NVEHICULO_CODIGO NOT IN (SELECT NVEHICULO_CODIGO "
            + "FROM SINTE_VEHICULOS_BRIGADAS WHERE "
            + "CPERIODO_CODIGO=?1 AND "
            + "CESTADO_CODIGO='AC') "
            + "ORDER BY CODIGO")
    List<BeanCombos> getVehiculosByPeriodo(String periodo);

    @Query(nativeQuery = true, value = "SELECT "
            + "NDEPENDENCIA_CODIGO CODIGO, VDEPENDENCIA_ABREVIATURA DESCRIPCION "
            + "FROM SINTE_DEPENDENCIAS WHERE "
            + "NBRIGADA_CODIGO=?1 AND CESTADO_CODIGO = 'AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getDependenciaByBrigada(Integer brigada);

    @Query(nativeQuery = true, value = "SELECT "
            + "NTIPO_ASIGNACION_CODIGO AS CODIGO, VTIPO_ASIGNACION_ABREVIATURA AS DESCRIPCION "
            + "FROM SINTE_TIPO_ASIGNACION WHERE "
            + "NTIPO_ASIGNACION_CODIGO NOT IN (SELECT NTIPO_ASIGNACION_CODIGO "
            + "FROM SINTE_PERIODO_TIPO_ASIGNACION WHERE "
            + "CPERIODO_CODIGO=?1) AND "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getPeriodoTipoAsignacionPendiente(String periodo);

    @Query(nativeQuery = true, value = "SELECT "
            + "NTIPO_ASIGNACION_CODIGO AS CODIGO, "
            + "UTIL.FUN_TIPO_ASIGNACION_ABREVIATUR(NTIPO_ASIGNACION_CODIGO) AS DESCRIPCION "
            + "FROM SINTE_PERIODO_TIPO_ASIGNACION WHERE "
            + "CPERIODO_CODIGO=?1 AND "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getTipoAsignacionByPeriodo(String periodo);

    @Query(nativeQuery = true, value = "SELECT "
            + "NBRIGADA_CODIGO AS CODIGO, VBRIGADA_ABREVIATURA AS DESCRIPCION "
            + "FROM SINTE_BRIGADAS WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getBrigadas();

    @Query(nativeQuery = true, value = "SELECT "
            + "NBRIGADA_CODIGO AS CODIGO, UTIL.FUN_BRIGADA_ABREVIATURA(NBRIGADA_CODIGO) AS DESCRIPCION "
            + "FROM SINTE_PROG_CLASE_III_TECHOS WHERE "
            + "CPERIODO_CODIGO=?1 AND "
            + "NTIPO_ASIGNACION_CODIGO=?2 AND "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getBrigadasByPeriodoTipoAsignacion(String periodo, Integer tipoAsignacion);

    @Query(nativeQuery = true, value = "SELECT "
            + "NBRIGADA_CODIGO AS CODIGO, UTIL.FUN_BRIGADA_ABREVIATURA(NBRIGADA_CODIGO) AS DESCRIPCION "
            + "FROM SINTE_USUARIOS WHERE "
            + "VUSUARIO_CODIGO=?1 AND "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getBrigadasByUsuario(String usuario);

    @Query(nativeQuery = true, value = "SELECT "
            + "NDEPENDENCIA_CODIGO CODIGO, VDEPENDENCIA_ABREVIATURA DESCRIPCION "
            + "FROM SINTE_DEPENDENCIAS WHERE "
            + "NDEPENDENCIA_CODIGO NOT IN (SELECT NDEPENDENCIA_CODIGO "
            + "FROM SINTE_VEHICULOS_BRIGADAS WHERE "
            + "CPERIODO_CODIGO=?1 AND "
            + "NBRIGADA_CODIGO=?2 AND "
            + "NVEHICULO_CODIGO=?3) AND "
            + "NBRIGADA_CODIGO=?2 "
            + "ORDER BY CODIGO")
    List<BeanCombos> getDependenciaByVehiAndBrigAndPeri(String periodo, Integer brigada, Integer vehiculo);

    @Query(nativeQuery = true, value = "SELECT "
            + "NVEHICULO_CODIGO AS CODIGO, '' AS DESCRIPCION "
            + "FROM SINTE_VEHICULOS WHERE "
            + "NVEHICULO_CODIGO NOT IN (SELECT NVEHICULO_CODIGO "
            + "FROM SINTE_VEHICULOS_BRIGADAS WHERE "
            + "CPERIODO_CODIGO=?1 AND "
            + "NBRIGADA_CODIGO=?2) "
            + "ORDER BY CODIGO")
    List<BeanCombos> getVehiculosByBrigadaAndPeriodo(String periodo, Integer brigada);

    @Query(nativeQuery = true, value = "SELECT "
            + "NVEHICULO_CODIGO AS CODIGO, UTIL.FUN_VEHICULO(NVEHICULO_CODIGO) DESCRIPCION "
            + "FROM SINTE_VEHICULOS_BRIGADAS WHERE "
            + "CPERIODO_CODIGO=?1 AND "
            + "NBRIGADA_CODIGO=?2 "
            + "ORDER BY CODIGO")
    List<BeanCombos> getVehiculosByPeriodoAndBrigada(String periodo, Integer brigada);

    @Query(nativeQuery = true, value = "SELECT "
            + "NTIPO_COMBUSTIBLE_CODIGO AS CODIGO, "
            + "UTIL.FUN_TIPO_COMBUSTIBLE_ABREVIATU(NTIPO_COMBUSTIBLE_CODIGO) DESCRIPCION "
            + "FROM SINTE_VEHICULOS_TIPO_COMBUSTIB WHERE "
            + "NVEHICULO_CODIGO=?1 "
            + "ORDER BY CODIGO")
    List<BeanCombos> getTipoCombustibleByVehiculo(Integer vehiculo);
    
    @Query(nativeQuery = true, value =  "SELECT CMES_CODIGO CODIGO,\n" +
                                        "       VMES_DESCRIPCION DESCRIPCION\n" +
                                        "  FROM SINTE_MESES\n" +
                                        " WHERE CESTADO_CODIGO = 'AC'\n" +
                                        " ORDER BY TO_NUMBER(CODIGO)")
    List<BeanCombos> getMeses();
    
    @Query(nativeQuery = true, value =  " SELECT NTIPO_COMBUSTIBLE_CODIGO CODIGO,\n" +
                                        "        VTIPO_COMBUSTIBLE_DESCRIPCION DESCRIPCION\n" +
                                        "   FROM SINTE_TIPO_COMBUSTIBLE  \n" +
                                        "  WHERE NTIPO_COMBUSTIBLE_CODIGO NOT IN (SELECT NTIPO_COMBUSTIBLE_CODIGO\n" +
                                        "                                           FROM SINTE_ASIGNACION_COMBUSTIBLE\n" +
                                        "                                          WHERE CPERIODO_CODIGO =?1\n" +
                                        "                                            AND NBRIGADA_CODIGO =?2\n" +
                                        "                                            AND CMES_CODIGO =?3\n" +
                                        "                                            AND NTIPO_ASIGNACION_CODIGO =?4)\n" +
                                        "  ORDER BY CODIGO")
    List<BeanCombos> getTipoCombustibleByAsignacionCombustible(String anio, Integer brigada, String mes, Integer tipoAsignacion);
    
    @Query(nativeQuery = true, value =  "SELECT NVEHICULO_CODIGO CODIGO,\n" +
                                        "       UTIL.FUN_VEHICULO(NVEHICULO_CODIGO) DESCRIPCION\n" +
                                        "  FROM SINTE_VEHICULOS_BRIGADAS\n" +
                                        " WHERE CPERIODO_CODIGO =?1\n" +
                                        "   AND NBRIGADA_CODIGO =?2\n" +
                                        "   AND NDEPENDENCIA_CODIGO =?6\n" +
                                        "   AND NVEHICULO_CODIGO NOT IN (SELECT NVEHICULO_CODIGO\n" +
                                        "                                  FROM SINTE_ASIGNACION_COMBUSTIBLE_D\n" +
                                        "                                 WHERE CPERIODO_CODIGO =?1\n" +
                                        "                                   AND NBRIGADA_CODIGO =?2\n" +
                                        "                                   AND CMES_CODIGO =?3\n" +
                                        "                                   AND NTIPO_ASIGNACION_CODIGO =?4\n" +
                                        "                                   AND NTIPO_COMBUSTIBLE_CODIGO =?5\n" +
                                        "                                   AND NDEPENDENCIA_CODIGO =?6)\n" +
                                        "   AND NVEHICULO_CODIGO IN (SELECT NVEHICULO_CODIGO  \n" +
                                        "                                  FROM SINTE_VEHICULOS_TIPO_COMBUSTIB\n" +
                                        "                                 WHERE NTIPO_COMBUSTIBLE_CODIGO =?5)" +
                                        "  ORDER BY CODIGO")
    List<BeanCombos> getVehiculoByAsignacionCombustible(String anio, Integer brigada, String mes, Integer tipoAsignacion, Integer tipoCombustible,Integer dependencia);
}
