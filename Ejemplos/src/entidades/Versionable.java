package entidades;

public interface Versionable<T extends Versionable<T>> {
	int getVersion();
	
	/**
	 * Ejemplo de BiOperator
	 * Recibe 2 parametros de tipo X
	 * Devuelve un parametro de tipo X
	 * @param versionable
	 * @param aComparar
	 * @return
	 */
	static <T extends Versionable<T>> T esVersionMayor(T versionable, T aComparar) {
		T aRetornar = null;
		if(versionable.getVersion()>aComparar.getVersion()) {
			aRetornar=(T) versionable;
		} else {
			aRetornar=aComparar;
		}
		
		return aRetornar;
	}
	
	default <T extends Versionable<T>> T esVersionMenor(T aComparar) {
		T aRetornar = null;
		if(this.getVersion()<aComparar.getVersion()) {
			aRetornar=(T) this;
		} else {
			aRetornar=aComparar;
		}
		
		return aRetornar;
	}
}
