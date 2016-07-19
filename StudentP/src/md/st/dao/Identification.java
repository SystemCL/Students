package md.st.dao;

import java.io.Serializable;

//Interfata care identifica obiectele
public interface Identification<PK extends Serializable> {
  
	//Returneaza identificatorul obiectului
	public PK getId();

	
}
