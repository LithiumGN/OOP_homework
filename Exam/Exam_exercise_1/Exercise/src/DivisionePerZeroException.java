public class DivisionePerZeroException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DivisionePerZeroException() {
		super("Divisione per zero!");
		}
	public DivisionePerZeroException(String msg){ 
		super(msg); 
		}
	
}