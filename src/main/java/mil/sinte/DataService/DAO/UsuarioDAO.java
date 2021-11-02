package mil.sinte.DataService.DAO;

import mil.sinte.BusinessServices.Beans.BeanUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Repository
public interface UsuarioDAO extends JpaRepository<BeanUsuario, String> {

    BeanUsuario findByUsuario(String usuario);

    BeanUsuario findByUsuarioAndEstado(String usuario, String estado);

}
