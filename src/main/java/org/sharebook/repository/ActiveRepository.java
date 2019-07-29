package org.sharebook.repository;

import org.sharebook.model.Active;

public interface ActiveRepository extends CurdRepository<Active, Long> {

    Active findByUserId(Long id);
}
