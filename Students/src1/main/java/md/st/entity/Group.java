package md.st.entity;

import md.st.dao.Identified;

public class Group implements Identified<Integer> {
    private Integer id = null;
    private String nomGroup;
	private String faculty;

    public Integer getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public String getNomGroup() {
		return nomGroup;
	}

	public void setNomGroup(String nomGroup) {
		this.nomGroup = nomGroup;
	}
	
	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}


}
