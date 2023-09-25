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

    @Query(value = "SELECT * FROM USUARIOS WHERE numero_documento = :id", nativeQuery = true)
    Usuario darUsuario(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios (nombre, tipo_documento, numero_documento, rol, correo) VALUES ( :nombre, :tipo_documento, :numero_documento, :rol, :correo)", nativeQuery = true)
    void insertarUsuario(@Param("nombre") String nombre, @Param("tipo_documento") String tipoDocumento,
                         @Param("numero_documento") String numeroDocumento, @Param("rol") String rol, @Param("correo") String correo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE USUARIOS SET nombre = :nombre, tipo_Documento = :tipoDocumento, numero_Documento = :numeroDocumento, rol = :rol, correo = :correo WHERE numero_Documento = :numeroDocumento", nativeQuery = true)
    void actualizarUsuario(@Param("nombre") String nombre, @Param("tipoDocumento") String tipoDocumento,
                           @Param("numeroDocumento") String numeroDocumento, @Param("rol") String rol, @Param("correo") String correo);

}