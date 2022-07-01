import Managers.NavesManager;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

import Models.NaveAbstracta;
import Models.NaveLanzadera;
import  org.junit.jupiter.api.Assertions.*;
import  org.junit.jupiter.api.Test;
class NavesManagerTest {
//implementacion de testing comprobando creacion de naves y polimorfismo
@Test
    void instanceOfTest(){
    var test= new NavesManager();
    NaveAbstracta result= NavesManager.crearLanzadera("nombre","propulsion","velocidad","peso",false, true);
    assertEquals(result.getClass() ,(NaveLanzadera.class));
    }
}