

package jpaejemplo.persistencia;

import java.util.List;
import jpaejemplo.entidades.Usuario;


public class UsuarioDAO extends DAO<Usuario>{
    
    public void guardarUsuario(Usuario usuario){
        super.guardar(usuario);
    }
    
    public void actualizarUsuario(Usuario usuario){
        super.actualizar(usuario);
    }
    
    public void borrarUsuario(Usuario usuario) {
        super.borrar(usuario);
    }
    
    public Usuario buscarUsuarioPorEmail(String email){
        conectar();
        Usuario usuario = em.find(Usuario.class, email);
//        Usuario usuario = (Usuario) em.createQuery("SELECT u FROM Usuario u WHERE u.email LIKE :email")
//                .setParameter("email", email).getSingleResult();    // OTRA FORMA
        desconectar();
        return usuario;
    }
    
    public List<Usuario> buscarUsuarioPorRangoEdad(int edadMenor, int edadMayor){
        conectar();
        List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u WHERE u.edad BETWEEN :edad1 AND :edad2")
                .setParameter("edad1", edadMenor).setParameter("edad2", edadMayor).getResultList();
        desconectar();
        return usuarios;
    }
    
    public List<Usuario> imprimirTodosLosUsuarios(){
        conectar();
        List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u").getResultList();
        desconectar();
        return usuarios;
    }
}
