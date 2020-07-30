package jp.trans_it.mark5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import jp.trans_it.mark5.model.entity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>,
												QuerydslPredicateExecutor<Organization>{

}
