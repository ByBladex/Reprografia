/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam.reprografia.recursos;

import java.util.ArrayList;

/**
 *
 * @author josel
 */
public class MockDAODocumentos {
    private final ArrayList<Documento> listaDocumentos;
    boolean falloConexion;
    
    MockDAODocumentos() throws Exception{
        listaDocumentos = new ArrayList();
        listaDocumentos.add(new Documento(1, 20, new Alumno("12345678A","Maria","Remedios","Gonzalez","PRIMEROBACH")));
        listaDocumentos.add(new Documento(2, 40, new Profesor("12345678B","Aiden","Diaz","Mellado","SEGUNDOESO")));
    }
    
    public int insertarDocumento(Documento documento){
        if(this.getDocumento(documento.getId()) == null){
            listaDocumentos.add(documento);
            return 1;
        }
        else{
            return 0;
        }
    }
    
    public int eliminarDocumento(Documento documento){
        if(listaDocumentos.remove(documento))
            return 1;
        else
            return 0;
    }
    
    public Documento getDocumento(Integer id) {
        for(Documento documento: listaDocumentos){
            if(documento.getId().equals(id))
                return documento;
        }
        return null;
    }
    
    public ArrayList<Documento> getDocumentos(){
        return listaDocumentos;
    }
}
