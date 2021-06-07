package com.unla.proyectosoftware.security;

import java.util.ArrayList;
import java.util.List;

import com.unla.proyectosoftware.entities.Usuario;
import com.unla.proyectosoftware.repository.IUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImp implements UserDetailsService {
	
	@Autowired
    private IUsuarioRepository userRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username)  throws UsernameNotFoundException  {
		//Buscar el usuario con el repositorio y si no existe lanzar una exepcion
		Usuario user = userRepository.findByUsernameAndFetchPerfilEagerly(username);

	    //Mapear nuestra lista de Authority  de spring security 
	    List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();  //se puede hacer tmb List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();???? ACA SOLO CREA UNA LISTA
	    // Obtener una authority para autorizar/controlar un acceso. CLASE DE SPRINGBOOT
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getPerfil().getNombreRol());
        grantList.add(grantedAuthority); 
        //Crear El objeto UserDetails que va a ir en sesion y retornarlo. NEW USER UNA CLASE DE USERDETAILS
		UserDetails usuario = (UserDetails) new User (user.getUsername(), user.getPassword(), grantList);
	         return usuario;
		
	}
	
	

}
