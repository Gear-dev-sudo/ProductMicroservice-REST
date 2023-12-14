package com.Zyfi.ProductMicroservice.DAO;

import com.Zyfi.ProductMicroservice.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class OrderDAOImpl implements OrderDAO {

    private final EntityManager entityManager;

    @Autowired
    public OrderDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public Order findById(int theId){
        Order theOrder=entityManager.find(Order.class,theId);
        return theOrder;
    }



    @Override
    public <S extends Order> S save(S entity) {
        S dbOrder=entityManager.merge(entity);
        return dbOrder;
    }



    @Override
    public <S extends Order> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Order> findById(Long aLong) {

        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Order> findAll() {
        return findAllWithPagination(PageRequest.of(0, Integer.MAX_VALUE)).getContent();
    }

    @Override
    public List<Order> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long theId) {
            Order theOrder=entityManager.find(Order.class,theId);
            entityManager.remove(theOrder);
    }

    @Override
    public void deleteById(int  theId) {
        Order theOrder=entityManager.find(Order.class,theId);
        entityManager.remove(theOrder);
    }

    @Override
    public void delete(Order entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Order> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Page<Order> findAllWithPagination(PageRequest pageRequest) {
        TypedQuery<Order> query = entityManager.createQuery("from Order", Order.class);
        query.setFirstResult((int) pageRequest.getOffset());
        query.setMaxResults(pageRequest.getPageSize());

        List<Order> orders = query.getResultList();
        long total = countTotalOrders();

        return new PageImpl<>(orders, pageRequest, total);
    }

    private long countTotalOrders() {
        return entityManager.createQuery("select count(o) from Order o", Long.class).getSingleResult();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Order> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Order> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Order> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Order getOne(Long aLong) {
        return null;
    }

    @Override
    public Order getById(Long aLong) {
        return null;
    }

    @Override
    public Order getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Order> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Order> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Order> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Order> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Order> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Order> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Order, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Order> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        TypedQuery<Order> query = entityManager.createQuery("FROM Order", Order.class);
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        List<Order> resultList = query.getResultList();

        // Count total results for pagination
        long total = countTotalOrders();

        return new PageImpl<>(resultList, pageable, total);
    }
}
