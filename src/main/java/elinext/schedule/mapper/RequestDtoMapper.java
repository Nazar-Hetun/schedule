package elinext.schedule.mapper;

public interface RequestDtoMapper<T, R> {
    R mapToModel(T dto);
}
