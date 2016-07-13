package md.st.dao;

import java.io.Serializable;
import java.util.List;

import md.st.dao.PersistException;
import md.st.dao.Identified;

public interface GenericDao<T extends Identified<PK>, PK extends Serializable> {
	
	//Creeaza o noua inregistrare si obiectul sau
	public T create() throws PersistException;
    
	//Creeaza o noua inregistrare care corespunde obiectului object
    public T persist(T object)  throws PersistException;

    //Returneaza obiectul care corespunde inregistrarii cu PK key sau null
    public T getByPK(PK key) throws PersistException;

    //Salveaza starea obiectului group in BD
    public void update(T object) throws PersistException;

    //Sterge inregistrarea despre obiect din BD
    public void delete(T object) throws PersistException;

    //Returneaza lista obiectelor care corespunde tuturor inregistrarilor din BD
    public List<T> getAll() throws PersistException;

}
