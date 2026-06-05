package br.edu.ifpr.bsi.projetoexemplo.mappers;

import br.edu.ifpr.bsi.projetoexemplo.model.produto.Produto;
import br.edu.ifpr.bsi.projetoexemplo.model.produto.ProdutoDetailDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.produto.ProdutoRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.produto.ProdutoSummaryDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {PedidoMapper.class})
public interface ProdutoMapper {

    Produto requestDTOToEntity(ProdutoRequestDTO produtoRequestDTO);

    ProdutoDetailDTO entityToDetailDTO(Produto produto);

    ProdutoSummaryDTO entityToSummaryDTO(Produto produto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(ProdutoRequestDTO dto, @MappingTarget Produto entity);


}
