package simulateurpoleemploi.Tests;


import simulateurpoleemploi.pagespbjects.pageEstimerMesAllocations;

public
class EstimationMonAllocationChomage {
    public static
    void main ( String[] args ) throws InterruptedException {
        pageEstimerMesAllocations browser = new pageEstimerMesAllocations ();

        browser.URLSITEWEB ( browser.URL () );
        browser.DateDeDaissance ( "23/07/1979" );
        browser.SoumisAuxCotisations ();
        browser.CategorieEmploi ( "Régime général" );
        browser.DateDebut ( "03/09/2018" );
        browser.DateFin ( "30/05/2020" );
        browser.SalaireBrut ( "3100" );
        browser.PeriodeContrat ( "Mensuel" );
        browser.MotifFinContrat ( "Fin de contrat à durée déterminée" );
        browser.IndemniteCongesPayes ( "0" );
        browser.ClickAjouterButton ();
        browser.ClickLancerEstimation ();
        browser.dureeDindemnisation();
    }
}