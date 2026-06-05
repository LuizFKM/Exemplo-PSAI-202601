package br.edu.ifpr.bsi.projetoexemplo.model.cliente;

import br.edu.ifpr.bsi.projetoexemplo.model.pedido.Pedido;
import br.edu.ifpr.bsi.projetoexemplo.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_cliente")
@DiscriminatorValue("CLIENTE")
public class Cliente extends Usuario {

    @Column(name = "nome_cliente")
    private String nome;

    @Column(name = "cpf_cliente")
    private String cpf;

    @Column(name = "email_cliente")
    private String email;

    // Um cliente pode ter vários pedidos
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

}
