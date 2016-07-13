package md.st.dao;

import java.io.Serializable;

//Interfata care identifica obiectele
public interface Identified<PK extends Serializable> {
  
	//Returneaza identificatorul obiectului
	public PK getId();
	
}
