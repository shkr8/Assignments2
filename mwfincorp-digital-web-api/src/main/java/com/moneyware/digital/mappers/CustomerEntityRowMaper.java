package com.moneyware.digital.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.moneyware.digital.enums.Status;
import com.moneyware.digital.models.Customer;
import com.moneyware.digital.models.Document;


public class CustomerEntityRowMaper implements RowMapper<Customer> {


    @Override
    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
        Customer cust = new Customer();
        cust.setId(resultSet.getLong("CUST_ID"));
        cust.setFirstName(resultSet.getString("FIRST_NAME"));
        cust.setLastName(resultSet.getString("LAST_NAME"));
        cust.setEmail(resultSet.getString("EMAIL"));
        cust.setDocument(resultSet.getObject("DOC_ID_FK", Document.class));
        cust.setStatus(Status.valueOf(resultSet.getString("STATUS")));
        return cust;
    }
}