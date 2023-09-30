package uniandes.edu.co.hotelAndes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.hotelAndes.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT * FROM USUARIOS", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query(value = "SELECT * FROM USUARIOS WHERE id = :id", nativeQuery = true)
    Usuario darUsuario(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios (id, nombre, tipo_documento, numero_documento, rol, correo) VALUES ( hotel_andes_sequence.nextval, :nombre, :tipoDocumento, :numeroDocumento, :rol, :correo)", nativeQuery = true)
    void insertarUsuario(@Param("nombre") String nombre, @Param("tipoDocumento") String tipoDocumento,
                        @Param("numeroDocumento") long numeroDocumento, @Param("rol") String rol, @Param("correo") String correo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE USUARIOS SET nombre = :nombre, tipo_Documento = :tipo_Documento, numero_Documento = :numero_Documento, rol = :rol, correo = :correo WHERE id = :id", nativeQuery = true)
    void actualizarUsuario(@Param("id") long id, @Param("nombre") String nombre, @Param("tipo_Documento") String tipo_Documento,
                           @Param("numero_Documento") long numero_Documento, @Param("rol") String rol, @Param("correo") String correo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM USUARIOS WHERE id = :id", nativeQuery = true)
    void eliminarUsuario(@Param("id") long id);


}