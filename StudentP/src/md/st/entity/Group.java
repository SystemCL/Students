package md.st.entity;


import md.st.dao.Identification;
import md.st.entity.annotations.*;

@Entity(tableName = "Group")
public class Group implements Identification<Integer> {
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

	public void setNomGroup(String nomGroup) {
		this.nomGroup = nomGroup;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	@Override
	public String toString(){
		return " id: " + id + "\n" +
	           " nameGroup: " + nomGroup+ "\n" +
				" faculty: " + faculty + "\n\n";
	}


}
