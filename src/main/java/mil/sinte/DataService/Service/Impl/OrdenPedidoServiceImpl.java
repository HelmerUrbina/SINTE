package mil.sinte.DataService.Service.Impl;

import java.text.SimpleDateFormat;
import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanOrdenPedido;
import mil.sinte.BusinessServices.Beans.BeanOrdenPedidoDetalle;
import mil.sinte.DataService.DAO.OrdenPedidoDAO;
import mil.sinte.DataService.DAO.OrdenPedidoDetalleDAO;
import mil.sinte.DataService.Service.OrdenPedidoService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class OrdenPedidoServiceImpl implements OrdenPedidoService {

    @Autowired
    private OrdenPedidoDAO ordenPedidoDAO;

    @Autowired
    private OrdenPedidoDetalleDAO ordenPedidoDetalleDAO;

    @Override
    public List<BeanOrdenPedido> getListaOrdenPedidos(String periodo, String mes) {
        return ordenPedidoDAO.findByPeriodoAndMes(periodo, mes);
    }

    @Override
    public BeanOrdenPedido getOrdenPedido(String periodo, Integer ordenPedido) {
        return ordenPedidoDAO.findByPeriodoAndOrdenPedido(periodo, ordenPedido);
    }

    @Override
    public List<BeanOrdenPedidoDetalle> getListaOrdenPedidoDetalle(String periodo, Integer ordenPedido) {
        return ordenPedidoDetalleDAO.findByPeriodoAndOrdenPedido(periodo, ordenPedido);
    }

    @Override
    public String guardarOrdenPedido(BeanOrdenPedido objBnOrdenPedido, String usuario, String modo) {
        String result = "GUARDO";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false); //No Complaciente en Fecha
            java.util.Date fecha_util = sdf.parse(Utiles.checkFecha(objBnOrdenPedido.getFecha()));
            ordenPedidoDAO.sp_ordenPedido(
                    objBnOrdenPedido.getPeriodo(),
                    objBnOrdenPedido.getOrdenPedido(),
                    Utiles.checkNum(objBnOrdenPedido.getTipoAsignacion()),
                    Utiles.checkNum(objBnOrdenPedido.getFuenteFinanciamiento()),
                    new java.sql.Date(fecha_util.getTime()),
                    Utiles.checkNum(objBnOrdenPedido.getGrifo()),
                    objBnOrdenPedido.getEstado(),
                    usuario,
                    modo);
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }
}
