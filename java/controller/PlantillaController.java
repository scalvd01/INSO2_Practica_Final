/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Mario
 */

@Named
@ViewScoped
public class PlantillaController implements Serializable{
    
    
    
    public void verificarYMostrar(){
        
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLoggeado") == null){
            try {
                //No existe usuario correctamente loggeado en la aplicacion y por tanto no se debe mostrar el formulario (e.g. si ponemos /faces/privado/principal.xhtml sin estar loggeados)
                //Redireccionamos según la direccion de contexto relativa a una página de error
                System.out.println(FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath());
                FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath()+"/faces/publico/permisosinsuficientes.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(PlantillaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Si existe usuario correctamente no hace nada y lo deja pasar cargándose el formulario
    }
}