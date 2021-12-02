package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanSoatAseguradora;
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
public interface SoatAseguradoraDAO extends JpaRepository<BeanSoatAseguradora, String> {

    @Query(nativeQuery = true, value = "SELECT NSOAT_ASEGURADORA_CODIGO, "
            + "VSOAT_ASEGURADORA_NOMBRE, VSOAT_ASEGURADORA_TELEFONO, VSOAT_ASEGURADORA_DIRECCION, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_SOAT_ASEGURADORA "
            + "ORDER BY NSOAT_ASEGURADORA_CODIGO")
    @Override
    List<BeanSoatAseguradora> findAll();

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_SOAT_ASEGURADORA(:codigo, :nombre, :telefono, :direccion, :usuario, :modo)}", nativeQuery = true)
    void sp_soat_aseguradora(
            @Param("codigo") Integer codigo,
            @Param("nombre") String nombre,
            @Param("telefono") String telefono,
            @Param("direccion") String direccion,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
}
