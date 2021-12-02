package mil.sinte.DataService.DAO;

import java.sql.Date;
import java.util.List;

import mil.sinte.BusinessServices.Beans.BeanVehiculosBrigada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Repository
public interface VehiculosBrigadaDAO extends JpaRepository<BeanVehiculosBrigada, String> {

    @Query(nativeQuery = true, value = "SELECT NVEHICULO_CODIGO,"
            + "NDEPENDENCIA_CODIGO, UTIL.FUN_VEHICULO(NVEHICULO_CODIGO) CPERIODO_CODIGO, "
            + "UTIL.FUN_DEPENDENCIA_ABREVIATURA(NBRIGADA_CODIGO, NDEPENDENCIA_CODIGO) NBRIGADA_CODIGO,"
            + "DVEHICULO_BRIGADA_FECHA, UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_VEHICULOS_BRIGADAS WHERE "
            + "CPERIODO_CODIGO=?1 AND "
            + "NBRIGADA_CODIGO=?2 "
            + "ORDER BY CESTADO_CODIGO, CPERIODO_CODIGO")
    public List<BeanVehiculosBrigada> findAll(String periodo, Integer brigada);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_VEHICULO_BRIGADA(:periodo, :brigada, :dependencia, :vehiculo, :fecha, :usuario, :modo)}", nativeQuery = true)
    void sp_vehiculosBrigadas(
            @Param("periodo") String periodo,
            @Param("brigada") String brigada,
            @Param("dependencia") Integer dependencia,
            @Param("vehiculo") Integer vehiculo,
            @Param("fecha") Date fecha,
            @Param("usuario") String usuario,
            @Param("modo") String modo);

}
