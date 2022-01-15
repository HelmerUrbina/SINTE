package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanOrdenPedido;
import mil.sinte.BusinessServices.Beans.BeanOrdenPedidoDetalle;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface OrdenPedidoService {

    public List<BeanOrdenPedido> getListaOrdenPedidos(String periodo, String mes);

    public BeanOrdenPedido getOrdenPedido(String periodo, Integer ordenPedido);

    public List<BeanOrdenPedidoDetalle> getListaOrdenPedidoDetalle(String periodo, Integer ordenPedido);

    public String guardarOrdenPedido(BeanOrdenPedido objBnOrdenPedido, String usuario, String modo);
}
