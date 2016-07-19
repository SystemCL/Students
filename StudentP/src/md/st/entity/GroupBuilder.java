package md.st.entity;

import md.st.dao.Identification;
import md.st.entity.annotations.Column;

public class GroupBuilder implements Identification<Integer> {
	@Column(name = "id")
	private Integer id;
    @Column(name = "nameGroup")
	public String nomGroup;
    @Column(name = "faculty")
	public String faculty;

    public Integer getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public String getNomGroup() {
		return nomGroup;
	}

	public String getFaculty() {
		return faculty;
	}

	public GroupBuilder nomGroup(String nomGroup){
		this.nomGroup = nomGroup;
		return this;
	}

	public GroupBuilder faculty(String faculty){
		this.faculty = faculty;
		return this;
	}
	
	public Group build(){
		Group group = new Group();
		group.setNomGroup(nomGroup);
		group.setFaculty(faculty);
		return group;
	}

}
