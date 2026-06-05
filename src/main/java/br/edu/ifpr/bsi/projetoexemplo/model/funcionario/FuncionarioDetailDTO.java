package br.edu.ifpr.bsi.projetoexemplo.model.funcionario;

import br.edu.ifpr.bsi.projetoexemplo.model.usuario.UsuarioDetailDTO;

public record FuncionarioDetailDTO (
        Long codigo,
        String matricula,
        String urlFotoPerfil,
        String username,
        String role
) implements UsuarioDetailDTO {
}
