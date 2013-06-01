/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.interfaceServicios;

import co.com.gblock.entity.TipoDocumento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FGulfo
 */
@Local
public interface ITipoDocumentoServicio extends IGenericaServicio<TipoDocumento, Integer> {
    
    TipoDocumento consultarPorNombre(String nombre);

    List<TipoDocumento> listarHabilitados();
}
