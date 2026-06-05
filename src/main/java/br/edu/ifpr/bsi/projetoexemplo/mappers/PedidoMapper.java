package br.edu.ifpr.bsi.projetoexemplo.mappers;

import br.edu.ifpr.bsi.projetoexemplo.model.pedido.Pedido;
import br.edu.ifpr.bsi.projetoexemplo.model.pedido.PedidoDetailDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.pedido.PedidoRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.pedido.PedidoSummaryDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class})
public interface PedidoMapper {

    Pedido requestDTOToEntity(PedidoRequestDTO pedidoRequestDTO);

    PedidoDetailDTO entityToDetailDTO(Pedido pedido);

    @Mapping(source = "cliente.codigo", target = "clienteId")
    PedidoSummaryDTO entityToSummaryDTO(Pedido pedido);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(PedidoRequestDTO dto, @MappingTarget Pedido entity);

}
