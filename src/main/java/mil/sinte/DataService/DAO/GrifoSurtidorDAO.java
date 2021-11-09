package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanGrifoSurtidor;
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
public interface GrifoSurtidorDAO extends JpaRepository<BeanGrifoSurtidor, String> {

    @Query(nativeQuery = true, value = "SELECT "
            + "NGRIFO_CODIGO, NGRIFO_SURTIDOR_CODIGO, NTIPO_COMBUSTIBLE_CODIGO, "
            + "UTIL.FUN_TIPO_COMBUSTIBLE_ABREVIATU(NTIPO_COMBUSTIBLE_CODIGO) VTIPO_COMBUSTIBLE_DESCRIPCION, "
            + "VGRIFO_SURTIDOR_NOMBRE, NGRIFO_SUTIDOR_CAPACIDAD, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_GRIFO_SURTIDOR WHERE "
            + "NGRIFO_CODIGO=?1 "
            + "ORDER BY NGRIFO_SURTIDOR_CODIGO")
    List<BeanGrifoSurtidor> findByGrifo(Integer grifo);

    @Query(nativeQuery = true, value = "SELECT "
            + "NGRIFO_CODIGO, NGRIFO_SURTIDOR_CODIGO, NTIPO_COMBUSTIBLE_CODIGO, '' VTIPO_COMBUSTIBLE_DESCRIPCION, "
            + "VGRIFO_SURTIDOR_NOMBRE, NGRIFO_SUTIDOR_CAPACIDAD, CESTADO_CODIGO "
            + "FROM SINTE_GRIFO_SURTIDOR WHERE "
            + "NGRIFO_CODIGO=?1 AND "
            + "NGRIFO_SURTIDOR_CODIGO=?2 ")
    public BeanGrifoSurtidor findByGrifoSurtidor(Integer grifo, Integer codigo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_GRIFO_SURTIDOR(:grifo, :grifoSurtidor, :tipoCombustible,"
            + ":surtidor, :capacidad, :usuario, :modo)}", nativeQuery = true)
    void sp_grifoSurtidor(
            @Param("grifo") Integer grifo,
            @Param("grifoSurtidor") Integer grifoSurtidor,
            @Param("tipoCombustible") Integer tipoCombustible,
            @Param("surtidor") String surtidor,
            @Param("capacidad") Integer capacidad,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
}
