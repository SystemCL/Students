package md.st.dao;

import md.st.dao.GenericDao;
import md.st.dao.GeneralException;

public interface DaoFactory<Context> {
	
	//pentru a crea obiecte care vor lucra cu BD
	public interface DaoCreator<Context> {
        public GenericDao create(Context context);
    }

    //Intoarce conexiunea la BD
    public Context getContext() throws GeneralException;

    //Intoarce obiectul pentru manipularea cu starea persistenta a lui
    public GenericDao getDao(Context context, Class dtoClass) throws GeneralException;

}
