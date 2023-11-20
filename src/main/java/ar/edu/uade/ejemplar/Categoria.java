package ar.edu.uade.ejemplar;

/**
 * 
 */
public enum Categoria {
    LIBRO(10),
    REVISTA(5),
    DIARIO(5),
    REVISTA_ESPECIALIZADA(5);
    
    private int cantDiasPrestamo;
    
    Categoria (int cantDiasPrestamo) {
    	this.cantDiasPrestamo = cantDiasPrestamo;
    }
   

	public int getCantDiasPrestamo() {
		return cantDiasPrestamo;
	}

	public void setCantDiasPrestamo(int cantDiasPrestamo) {
		this.cantDiasPrestamo = cantDiasPrestamo;
	}
    
    
}