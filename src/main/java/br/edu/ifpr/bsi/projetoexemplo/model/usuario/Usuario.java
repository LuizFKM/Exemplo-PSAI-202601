package br.edu.ifpr.bsi.projetoexemplo.model.usuario;

import br.edu.ifpr.bsi.projetoexemplo.enums.Role;
import br.edu.ifpr.bsi.projetoexemplo.model.GenericModel;
import br.edu.ifpr.bsi.projetoexemplo.model.contato.Contato;
import br.edu.ifpr.bsi.projetoexemplo.model.endereco.Endereco;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="role", discriminatorType = DiscriminatorType.STRING)
public abstract class Usuario extends GenericModel {

    @Column(name="username", unique = true)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name = "url_foto_perfil")
    private String urlFotoPerfil;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", insertable = false, updatable = false)
    private Role role;

    // Um usuário tem só um endereço
    // CascadeType.ALL faz com que as operações em Usuario sejam propagadas para Endereco
    // FetchType.EAGER indica que o endereço deve ser carregado imediatamente junto com o usuário
    // CUIDADO com o EAGER em relacionamentos @OneToMany, pois pode causar problemas de desempenho se houver muitos contatos para um usuário
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    // Um usuario pode ter vários contatos
    // MappedBy indica que o relacionamento é bidirecional e que a entidade Contato é a dona do relacionamento (ou seja, a tabela de contatos terá uma coluna usuario_id)
    // CascadeType.ALL faz com que as operações em Usuario sejam propagadas para Contato
    // FetchType.LAZY indica que os contatos devem ser carregados somente quando forem acessados, o que pode melhorar o desempenho se o endereço não for sempre necessário
    // OrphanRemoval = true garante que, se um contato for removido da lista de contatos do usuario, ele também será removido do banco de dados
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contato> contatos = new ArrayList<>();


    public void adicionarContato(Contato contato) {
        contato.setUsuario(this);
        this.contatos.add(contato);
    }

    public void removerContato(Contato contato) {
        contato.setUsuario(null);
        this.contatos.remove(contato);
    }

}
