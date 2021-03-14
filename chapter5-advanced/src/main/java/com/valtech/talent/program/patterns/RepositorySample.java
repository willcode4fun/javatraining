package com.valtech.talent.program.patterns;

import com.valtech.talent.program.patterns.model.Dinosaur;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class RepositorySample {

    public class DinosaurRepository implements CrudRepository<Dinosaur, Long> {

        @Override
        public Dinosaur save(Dinosaur o) {
            return null;
        }

        @Override
        public Iterable saveAll(Iterable iterable) {
            return null;
        }

        @Override
        public Optional<Dinosaur> findById(Long o) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long o) {
            return false;
        }

        @Override
        public Iterable<Dinosaur> findAll() {
            return null;
        }

        @Override
        public Iterable<Dinosaur> findAllById(Iterable iterable) {
            return null;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long o) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public void deleteAll(Iterable iterable) {

        }

        @Override
        public void delete(Dinosaur o) {

        }
    }

}
