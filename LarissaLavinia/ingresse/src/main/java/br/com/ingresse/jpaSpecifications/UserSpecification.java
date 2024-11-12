package br.com.ingresse.jpaSpecifications;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

import br.com.ingresse.entities.User;

public class UserSpecification {

	public static Specification<User> nameContain(String name) {
		return (root, query, criteriaBuilder) -> name == null ? null
				: criteriaBuilder.like(root.get("name"), "%" + name + "%");
	}

	public static Specification<User> createDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
		return (root, query, criteriaBuilder) -> {
			if (startDate != null && endDate != null) {
				return criteriaBuilder.between(root.get("createdDate"), startDate, endDate);
			}
			if (startDate != null) {
				return criteriaBuilder.greaterThanOrEqualTo(root.get("createdDate"), startDate);
			}
			return (endDate != null) ? criteriaBuilder.lessThanOrEqualTo(root.get("createdDate"), endDate) : null;

		};
	}
}
