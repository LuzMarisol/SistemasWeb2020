package mx.uv.basededatos;

public class Usuarios {
    private String id;
    private String email;
    private String password;
    
	public Usuarios(String id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String email(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String id(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
}
