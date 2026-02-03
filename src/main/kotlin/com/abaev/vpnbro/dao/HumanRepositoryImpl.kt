package com.abaev.vpnbro.dao

import com.abaev.vpnbro.model.HumanData
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

/**
 * @author Abaev Evgeniy
 */
@Repository
class HumanRepositoryImpl(
    final val jdbcTemplate: JdbcTemplate
) {

    fun getHumanById(id: Long): HumanData {
        return jdbcTemplate.queryForObject(
            "SELECT id, name, lastName, age FROM humans WHERE id = ?",
            GetHumanMapper(),
            id
        ) ?: throw RuntimeException("Human not found with id: $id")
    }

}