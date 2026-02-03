package com.abaev.vpnbro.dao

import com.abaev.vpnbro.model.HumanData
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

/**
 * @author Abaev Evgeniy
 */
class GetHumanMapper : RowMapper<HumanData> {
    override fun mapRow(rs: ResultSet, rowNum: Int): HumanData {
        return HumanData(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("lastname"),
            rs.getInt("age"),
        )
    }
}