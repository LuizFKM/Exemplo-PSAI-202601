package br.edu.ifpr.bsi.projetoexemplo.mappers;

import br.edu.ifpr.bsi.projetoexemplo.model.endereco.Endereco;
import br.edu.ifpr.bsi.projetoexemplo.model.endereco.EnderecoRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.endereco.EnderecoResponseDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    Endereco requestDTOToEntity(EnderecoRequestDTO enderecoRequestDTO);

    EnderecoResponseDTO entityToSummaryDTO(Endereco endereco);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(EnderecoRequestDTO dto, @MappingTarget Endereco entity);

}
