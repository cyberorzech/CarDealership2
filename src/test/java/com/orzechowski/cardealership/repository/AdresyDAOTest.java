package com.orzechowski.cardealership.repository;

import com.orzechowski.cardealership.models.Adresy;
import com.orzechowski.cardealership.models.Poczty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdresyDAOTest {
    private AdresyDAO dao;

    @BeforeEach
    void setUp() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();         // initialize db connection
        datasource.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL1");
        datasource.setUsername("natan");
        datasource.setPassword("toor");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");
        // Import jdbc template
        dao = new AdresyDAO(new JdbcTemplate(datasource));
    }

    @Test
    void list() {
        List<Adresy> listAdresy = dao.list();
        assertTrue(listAdresy.isEmpty());
    }

    @Test
    void save() {
        Adresy adresy = new Adresy("Warszawa", "Kwiatkowa", "23", 51);
        dao.save(adresy);
    }

    @Test
    void get() {
        int id = 2;
        Adresy adresy = dao.get(id);
        assertNotNull(adresy);
    }

    @Test
    public void update() {
        Adresy adresy = new Adresy();
        adresy.setNr_adresu(7);
        adresy.setMiasto("Testowo");
        adresy.setUlica("Testowa");
        adresy.setNr_lokalu("5");
        adresy.setNr_poczty(51);
        dao.update(adresy);
    }

    @Test
    void delete() {
        int nr_adresu = 6;
        dao.delete(nr_adresu);
    }
}