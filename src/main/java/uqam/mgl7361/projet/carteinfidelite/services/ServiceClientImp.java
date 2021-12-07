package uqam.mgl7361.projet.carteinfidelite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uqam.mgl7361.projet.carteinfidelite.entites.Client;
import uqam.mgl7361.projet.carteinfidelite.entites.ClientStatut;
import uqam.mgl7361.projet.carteinfidelite.persistance.IClientDAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Optional;


@Service
public class ServiceClientImp implements ServiceClient {

    @Autowired
    private IClientDAO clientDao;
    @Autowired
    private EntityManager entityManager;


    /**
     * Attribuer le statut VUP a un client
     *
     * @param clientId
     * @return Client
     */

    @Override
    public Optional<Client> attribuerStatutVUP(Long clientId) {
        Optional<Client> client = clientDao.findById(clientId);
        int nombrePointDepuisSemaine = calculerPointsGagneCetteSemaine(clientId);
        if (client.isPresent() && nombrePointDepuisSemaine > 100) {
            client.get().setStatut(ClientStatut.VUP);
            Client clientModifie = clientDao.save(client.get());
            return Optional.of(clientModifie);
        } else {
            return null;
        }
    }

    /**
     * Verifier si un client a le statut VUP
     *
     * @param clientId
     * @return Client
     */

    @Override
    public Boolean verifierStatutVUP(Long clientId) {
        Optional<Client> client = clientDao.findById(clientId);

        if (client.isPresent() && ClientStatut.VUP.toString().equalsIgnoreCase(client.get().getStatut().toString())) {
            return true;
        } else {
            return false;
        }
    }

    public int calculerPointsGagneCetteSemaine(Long clientId) {

      int count = 0;

       /* "SELECT from TRANSACTION,CARTE" +
                "WHERE CARTE.FK_CLIENT :clientId"+
                "AND datetransaction >= dateadd(day, 1-datepart(dw, getdate()), CONVERT(date,getdate()))" +
                "AND datetransaction <  dateadd(day, 8-datepart(dw, getdate()), CONVERT(date,getdate()))"
          */
        Query query = entityManager.createNativeQuery(
                "SET DATEFIRST 1" +
                        "select * from TRANSACTION");
        query.setParameter("clientId", clientId);

        return count;
    }
}