package DAO;

import Model.Producto;
import java.util.List;

public interface ProductoDAO {
    public List<Producto> ListarProducto();
    public Producto editarPro(int id_pro_edit);
    public boolean guardarPro(Producto producto);
    public boolean borrarPro(int id_pro_borrar);
}
