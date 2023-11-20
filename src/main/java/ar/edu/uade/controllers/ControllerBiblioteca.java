package ar.edu.uade.controllers;

import ar.edu.uade.ejemplar.EjemplaresFachada;
import ar.edu.uade.prestamo.PrestamoFachada;
import ar.edu.uade.usuario.Socio;
import ar.edu.uade.usuario.SociosFacade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ControllerBiblioteca {
    private static ControllerBiblioteca instancia;
    private EjemplaresFachada ejemplaresFachada;
    private PrestamoFachada prestamoFachada;
    private SociosFacade sociosFacade;

    private ControllerBiblioteca() {
        this.ejemplaresFachada = EjemplaresFachada.getInstance();
        this.prestamoFachada = PrestamoFachada.getInstance();
        this.sociosFacade = SociosFacade.getInstance();
    }

    public static ControllerBiblioteca getInstance() {
        if (instancia == null) {
            instancia = new ControllerBiblioteca();
        }
        return instancia;
    }


    /* =======================================================
     *                  EJERCIOS POR SEDE
     * =======================================================
     */
    public HashMap<String, ArrayList<String>> getEjerciciosPorSede(){
        HashMap<String, ArrayList<String>> ejerciciosPorSede = new HashMap<String, ArrayList<String>>();
        /*
        ArrayList<Sede> sedes = gym.getListaSedes();
        for(Sede sede : sedes){
            HashSet<Ejercicio> ejercicios = sede.getEjerciciosDisponibles();
            //System.out.print("aqui -->" +ejercicios.toString());
            ArrayList<String> ejerciciosDisponibles = new ArrayList<>();
            for(Ejercicio ejercicio: ejercicios) {
                if (ejercicio != null) {
                    ejerciciosDisponibles.add(ejercicio.getNombre());
                }
            }
            ejerciciosPorSede.put(sede.getUbicacion(),ejerciciosDisponibles);
        }*/
        return ejerciciosPorSede;
    }

    public boolean estaEnLista(String valor, ArrayList<String> valores){
        for(int i = 0; i < valores.size(); i++){
            if(valor.equals(valores.get(i))){
                return true;
            }
        }
        return false;
    }




    public List<Map<String, String>> getListaSocios() {
        return sociosFacade.getInfoSocios();
    }

    public List<Map<String, String>> getListaEjemplares() {
        return ejemplaresFachada.getInfoEjemplares();
    }

    public List<Map<String, String>> getListaPrestamos() {
        return prestamoFachada.getInfoPrestamos();
    }
}
