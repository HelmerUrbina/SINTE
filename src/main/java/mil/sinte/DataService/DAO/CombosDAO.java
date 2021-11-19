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
            + "a.CPERIODO_CODIGO AS CODIGO, a.CPERIODO_CODIGO AS DESCRIPCION "
            + "FROM SINTE_PERIODOS a WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getPeriodos();

    @Query(nativeQuery = true, value = "SELECT "
            + "a.NDIVISION_EJERCITO_CODIGO AS CODIGO, "
            + "a.VDIVISION_EJERCITO_ABREVIATURA AS DESCRIPCION "
            + "FROM SINTE_DIVISION_EJERCITO a WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getDivisionEjercito();

    @Query(nativeQuery = true, value = "SELECT "
            + "a.NTIPO_COMBUSTIBLE_CODIGO AS CODIGO, "
            + "a.VTIPO_COMBUSTIBLE_ABREVIATURA AS DESCRIPCION  "
            + "FROM SINTE_TIPO_COMBUSTIBLE a WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getTipoCombustible();

    @Query(nativeQuery = true, value = "SELECT "
            + "a.CDEPARTAMENTO_CODIGO AS CODIGO, "
            + "a.VDEPARTAMENTO_NOMBRE AS DESCRIPCION "
            + "FROM SINTE_DEPARTAMENTO a WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getDepartamentos();

    @Query(nativeQuery = true, value = "SELECT "
            + "a.CPROVINCIA_CODIGO AS CODIGO, "
            + "a.VPROVINCIA_NOMBRE AS DESCRIPCION "
            + "FROM SINTE_PROVINCIA a WHERE "
            + "CDEPARTAMENTO_CODIGO=?1 AND "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getProvincias(String departamento);

    @Query(nativeQuery = true, value = "SELECT "
            + "a.CUBIGEO_CODIGO AS CODIGO, "
            + "a.VUBIGEO_NOMBRE AS DESCRIPCION "
            + "FROM SINTE_UBIGEO a WHERE "
            + "a.CDEPARTAMENTO_CODIGO=?1 AND "
            + "a.CPROVINCIA_CODIGO=?2 AND "
            + "a.CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getUbigeo(String departamento, String provincia);

    @Query(nativeQuery = true, value = "SELECT "
            + "a.NTIPO_DEPENDENCIA_CODIGO AS CODIGO, "
            + "a.VTIPO_DEPENDENCIA_ABREVIATURA AS DESCRIPCION  "
            + "FROM SINTE_TIPO_DEPENDENCIA a WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getTipoDependencia();

    @Query(nativeQuery = true, value = "SELECT "
            + "NVEHICULO_TIPO_CODIGO CODIGO, "
            + "VVEHICULO_TIPO_DESCRIPCION DESCRIPCION "
            + "FROM SINTE_VEHICULO_TIPO WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getTipoVehiculo();

    @Query(nativeQuery = true, value = "SELECT "
            + "NVEHICULO_CLASE_CODIGO CODIGO, "
            + "VVEHICULO_CLASE_DESCRIPCION DESCRIPCION "
            + "FROM SINTE_VEHICULO_CLASE WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getClaseVehiculo();

    @Query(nativeQuery = true, value = " SELECT "
            + "NMARCA_CODIGO CODIGO, "
            + "VMARCA_NOMBRE DESCRIPCION "
            + "FROM SINTE_MARCAS WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getMarca();

    @Query(nativeQuery = true, value = " SELECT "
            + "NMARCA_MODELO_CODIGO CODIGO, "
            + "VMARCA_MODELO_DESCRIPCION DESCRIPCION "
            + "FROM SINTE_MARCAS_MODELOS WHERE "
            + "CESTADO_CODIGO='AC' AND "
            + "NMARCA_CODIGO=?1 "
            + "ORDER BY CODIGO")
    List<BeanCombos> getModelo(String marca);

    @Query(nativeQuery = true, value = " SELECT "
            + "NCOLOR_CODIGO CODIGO, "
            + "VCOLOR_DESCRIPCION DESCRIPCION "
            + "FROM SINTE_COLORES WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getColor();

    @Query(nativeQuery = true, value = "SELECT "
            + "NSOAT_ASEGURADORA_CODIGO CODIGO, "
            + "VSOAT_ASEGURADORA_NOMBRE DESCRIPCION "
            + "FROM SINTE_SOAT_ASEGURADORA WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getSoat();

    @Query(nativeQuery = true, value = "SELECT "
            + "NAREA_LABORAL_CODIGO CODIGO, "
            + "VAREA_LABORAL_DESCRIPCION DESCRIPCION "
            + "FROM SINTE_AREA_LABORAL WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getAreaLaboral();

    @Query(nativeQuery = true, value = "SELECT "
            + "NUSUARIO_ROL_CODIGO CODIGO, "
            + "VUSUARIO_ROL_NOMBRE DESCRIPCION "
            + "FROM SINTE_USUARIOS_ROLES WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getRol();

    @Query(nativeQuery = true, value = "SELECT "
            + "NVEHICULO_CODIGO CODIGO, "
            + "VVEHICULO_PLACA DESCRIPCION "
            + "FROM SINTE_VEHICULOS WHERE "
            + "NVEHICULO_CODIGO NOT IN (SELECT NVEHICULO_CODIGO "
            + "FROM SINTE_VEHICULOS_BRIGADAS WHERE "
            + "CPERIODO_CODIGO=?1) "
            + "ORDER BY CODIGO")
    List<BeanCombos> getVehiculosByPeriodo(String periodo);

    @Query(nativeQuery = true, value = "SELECT "
            + "NDEPENDENCIA_CODIGO CODIGO, "
            + "VDEPENDENCIA_ABREVIATURA DESCRIPCION "
            + "FROM SINTE_DEPENDENCIAS WHERE "
            + "NBRIGADA_CODIGO=?1 "
            + "ORDER BY CODIGO")
    List<BeanCombos> getDependenciaByBrigada(Integer brigada);

    @Query(nativeQuery = true, value = "SELECT "
            + "NTIPO_ASIGNACION_CODIGO AS CODIGO, "
            + "VTIPO_ASIGNACION_ABREVIATURA AS DESCRIPCION "
            + "FROM SINTE_TIPO_ASIGNACION WHERE "
            + "NTIPO_ASIGNACION_CODIGO NOT IN (SELECT NTIPO_ASIGNACION_CODIGO "
            + "FROM SINTE_PERIODO_TIPO_ASIGNACION WHERE CPERIODO_CODIGO=?1) AND "
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
            + "NBRIGADA_CODIGO AS CODIGO, "
            + "VBRIGADA_ABREVIATURA AS DESCRIPCION "
            + "FROM SINTE_BRIGADAS WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getBrigadas();

    @Query(nativeQuery = true, value = "SELECT "
            + "NBRIGADA_CODIGO AS CODIGO, "
            + "UTIL.FUN_BRIGADA_ABREVIATURA(NBRIGADA_CODIGO) AS DESCRIPCION "
            + "FROM SINTE_PROG_CLASE_III_TECHOS WHERE "
            + "CPERIODO_CODIGO=?1 AND "
            + "NTIPO_ASIGNACION_CODIGO=?2 AND "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getBrigadasByPeriodoTipoAsignacion(String periodo, Integer tipoAsignacion);

    @Query(nativeQuery = true, value = "SELECT "
            + "NBRIGADA_CODIGO AS CODIGO, "
            + "UTIL.FUN_BRIGADA_ABREVIATURA(NBRIGADA_CODIGO) AS DESCRIPCION "
            + "FROM SINTE_USUARIOS WHERE "
            + "VUSUARIO_CODIGO=?1 AND "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getBrigadasByUsuario(String usuario);

    @Query(nativeQuery = true, value = "SELECT "
            + "NDEPENDENCIA_CODIGO CODIGO, "
            + "VDEPENDENCIA_ABREVIATURA DESCRIPCION FROM "
            + "SINTE_DEPENDENCIAS WHERE "
            + "NDEPENDENCIA_CODIGO NOT IN (SELECT NDEPENDENCIA_CODIGO "
            + "FROM SINTE_VEHICULOS_BRIGADAS WHERE "
            + "NBRIGADA_CODIGO=?2 AND "
            + "CPERIODO_CODIGO=?1 AND "
            + "NVEHICULO_CODIGO=?3) AND "
            + "NBRIGADA_CODIGO=?2 "
            + "ORDER BY CODIGO")
    List<BeanCombos> getDependenciaByVehiAndBrigAndPeri(String periodo, Integer brigada, Integer vehiculo);

    @Query(nativeQuery = true, value = "SELECT "
            + "NVEHICULO_CODIGO AS CODIGO, "
            + "'' AS DESCRIPCION "
            + "FROM SINTE_VEHICULOS "
            + "WHERE NVEHICULO_CODIGO NOT IN (SELECT NVEHICULO_CODIGO "
            + "FROM SINTE_VEHICULOS_BRIGADAS WHERE "
            + "CPERIODO_CODIGO=?1 AND "
            + "NBRIGADA_CODIGO=?2) "
            + "ORDER BY CODIGO")
    List<BeanCombos> getVehiculosByBrigadaAndPeriodo(String periodo, Integer brigada);

    @Query(nativeQuery = true, value = "SELECT "
            + "NVEHICULO_CODIGO AS CODIGO, "
            + "UTIL.FUN_VEHICULO(NVEHICULO_CODIGO) DESCRIPCION "
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
}
