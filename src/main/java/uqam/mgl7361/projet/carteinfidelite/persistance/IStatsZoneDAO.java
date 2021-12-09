package uqam.mgl7361.projet.carteinfidelite.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uqam.mgl7361.projet.carteinfidelite.entites.*;

import java.util.List;

@Repository
public interface IStatsZoneDAO extends JpaRepository<Zone,Long> {

    @Query(value = "select * from cadeau\n" +
            "where cadeau.id in (select cadeau.id from cadeau , zone where zone.id = :zoneId)\n" +
            "ORDER BY NOMBRE_ACHAT DESC\n" +
            "LIMIT 3", nativeQuery = true)
    List rechercherCadeauxPopulairex(@Param("zoneId") Long id);

    @Query(value = "SELECT * TRANSACTION FROM ZONE,MAGAZIN  WHERE ZONE.ID = 9 AND ", nativeQuery = true)
    List<Transaction> listerCredit(long carteId);

    @Query(value = "SELECT * TRANSACTION FROM ZONE,MAGAZIN  WHERE ZONE.ID = 9 AND ", nativeQuery = true)
    List<Transaction> listerDebit(long carteId);
        /* "SELECT CADEAU.ID , COUNT(CADEAU.ID) AS PRODUCTS_SOLD"+
                "FROM     cs_items"+
                "GROUP BY codigo_orden"+
                "ORDER BY 2 DESC"+
                "FETCH FIRST 10 ROWS ONLY" */
}
