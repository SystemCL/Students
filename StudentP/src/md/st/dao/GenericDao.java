package md.st.dao;

import java.io.Serializable;
import java.util.List;


import md.st.dao.Identification;
import md.st.dao.GeneralException;

public interface GenericDao<T extends Identification<PK>, PK extends Serializable>{
	
	//Creeaza o noua conexiune si obiectul sau
	public T create() throws GeneralException;
	
	//Creeaza o noua inregistrare care corespunde obiectului object
    public T insert(T object) throws GeneralException;

    //Returneaza obiectul care corespunde inregistrarii cu PK key sau null
    public T getByPK(PK key) throws GeneralException;

    //Salveaza starea obiectului in BD
    public void update(T object) throws GeneralException;

    //Sterge inregistrarea despre obiect din BD
    public void delete(T object) throws GeneralException;

    //Returneaza lista obiectelor care corespunde tuturor inregistrarilor din BD
    public List<T> getAll() throws GeneralException;

}
