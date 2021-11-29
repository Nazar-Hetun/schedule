package elinext.schedule.mapper;

public interface ResponseDtoMapper<T, R> {
    T mapToDto(R r);
}
