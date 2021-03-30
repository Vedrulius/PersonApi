package com.mihey.personapi.mapper

import com.mihey.personapi.model.Person
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class PersonMapper : RowMapper<Person> {

    override fun mapRow(rs: ResultSet, rowNum: Int): Person? {
        return Person(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("last_name")
        )
    }
}