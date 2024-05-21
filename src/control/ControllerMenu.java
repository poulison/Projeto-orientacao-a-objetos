
package control;


import model.Investidor;
import view.Menu;

/**
 *
 * @author Paulo
 */
public class ControllerMenu {
    private Menu view;
    private Investidor investidor; 
    
    public ControllerMenu(Menu view, Investidor investidor){
        this.view = view;
        this.investidor = investidor;
    }
    
    
    
}
