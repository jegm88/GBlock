/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.interfaceServicios;

import co.com.gblock.entity.Tercero;
import co.com.gblock.services.utilidad.TipoTercero;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FGulfo
 */
@Local
public interface ITerceroServicio extends IGenericaServicio<Tercero, Long> {

    Tercero consultarPorNumeroId(String id);

    List<Tercero> listarPorTipo(TipoTercero tipo);

    List<Tercero> listarHabilitados();
}
