package exercise.repository;

import exercise.model.QUser;
import exercise.model.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
// Зависимости для дополнительного задания
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import com.querydsl.core.types.dsl.StringPath;


import org.springframework.stereotype.Repository;

@Repository
// Репозиторий для основной задачи
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}

// Дополнительная задача
// Если решите сделать дополнительную задачу, измените существующий репозиторий для работы с Querydsl предикатами
// BEGIN
//public interface UserRepository extends
//        JpaRepository<User, Long>,
//        QuerydslPredicateExecutor<User>,
//        QuerydslBinderCustomizer<QUser> {
//
//    default void customize(QuerydslBindings bindings, QUser user) {
//        bindings.bind(user.firstName).first((path, value) -> path.containsIgnoreCase(value));
//        bindings.bind(user.lastName).first((path, value) -> path.containsIgnoreCase(value));
//        bindings.bind(user.email).first((path, value) -> path.containsIgnoreCase(value));
//        bindings.bind(user.profession).first((path, value) -> path.containsIgnoreCase(value));
//        bindings.bind(user.gender).first((path, value) -> path.eq(value));
//    }
//}
// END
