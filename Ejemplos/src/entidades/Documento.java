package entidades;

import java.util.Arrays;
import java.util.List;

public class Documento implements Versionable<Documento> {
	private String titulo;
	private int version;
	
	public Documento() {
		super();
	}
	
	public Documento(String titulo, int version) {
		super();
		this.titulo = titulo;
		this.version = version;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Documento [titulo=" + titulo + ", version=" + version + "]";
	}
	
	public static List<Documento> documentosParaTest(){
		return Arrays.asList(
				new Documento("A", 7),
				new Documento("B", 6),
				new Documento("C", 5),
				new Documento("D", 4),
				new Documento("C", 3),
				new Documento("B", 2),
				new Documento("A", 1)
				);
	}
	
}
