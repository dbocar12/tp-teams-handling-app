package fr.sorbonne.paris.nord.university.api.factory;

public interface EntityFactory <E,D> {
    D toDTO(E entity);
    E toEntity(D dto);
}
