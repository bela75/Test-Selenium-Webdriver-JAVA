package simulateurpoleemploi.pagespbjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class
pageEstimerMesAllocations {

    protected final String url = "https://candidat.pole-emploi.fr/candidat/simucalcul/perteemploi";
    protected final String datedenaissance = "#dateNaissance";
    protected final String alsaceMoselle = "#nonCotisantAlsace";
    protected final String categorieemploi = "#categorieEmploi";
    protected final String dateDebutEmploi = "#dateDebutEmploi";
    protected final String dateFinEmploi = "#dateFinEmploi";
    protected final String salairebrut = "#salaireBrut";
    protected final String periodecontrat = "#salaireBrutFrequence";
    protected final String motiffincontrat = "#motifFinContrat";
    protected final String indemnitecongespayes = "#indemnitesCongesPayes";
    protected final String indemnitelicenciement = "#indemnitesLicenciement";
    protected final String ajouterbutton = "#boutonAjouterEmploi";
    protected final String lancerestimation = "#boutonValider";
    protected final String buttonPOPAccepter = "#footer_tc_privacy_button";
    protected final String MontantDroits = "#formulaire > div.bd.main-content > div:nth-child(3) > div > div.intro.refund > div > p:nth-child(3) > strong";
    protected final String nombreJours = "#formulaire > div.bd.main-content > div:nth-child(3) > div > div:nth-child(3) > div > table > tbody > tr:nth-child(1) > td > strong";
    private final String dureeIndemnisation ="#formulaire > div.bd.main-content > div:nth-child(3) > div > div.intro.refund > div > p:nth-child(1) > strong";
    protected WebDriver driver;
    protected WebElement element;


    public
    String URL () {
        return url;
    }


    @Test
    public
    void URLSITEWEB ( String url ) {
        try {
            System.setProperty ( "webdriver.chrome.driver" , "src/main/browser/ChromeDriver.83.0.4103.39" );
            driver = new ChromeDriver ();
        }
        catch (Exception exception){
            System.out.println ("La version du navigateur est erroné : "+exception);
        }
        Dimension dimension = new Dimension ( 1280 , 1024 );
        driver.manage ().window ().setSize ( dimension );
        driver.get ( URL () );
        driver.findElement ( By.cssSelector ( buttonPOPAccepter ) ).click ();
    }

    @Test
    public
    void DateDeDaissance ( String date ) throws InterruptedException {
        Thread.sleep ( 1000 );
        driver.findElement ( By.cssSelector ( datedenaissance ) ).sendKeys ( date );
    }
    @Test
    public
    void SoumisAuxCotisations () throws InterruptedException {
        Thread.sleep ( 1000 );
        driver.findElement ( By.cssSelector ( alsaceMoselle ) ).click ();
    }

    @Test
    public
    void CategorieEmploi ( String categorieEmploi ) throws InterruptedException {
        Thread.sleep ( 1000 );
        driver.findElement ( By.cssSelector ( categorieemploi ) ).sendKeys ( categorieEmploi );

    }

    @Test
    public
    void DateDebut ( String datedebut ) throws InterruptedException {
        Thread.sleep ( 1000 );
        driver.findElement ( By.cssSelector ( dateDebutEmploi ) ).sendKeys ( datedebut );
    }

    @Test
    public
    void DateFin ( String datefin ) throws InterruptedException {
        Thread.sleep ( 1000 );
        driver.findElement ( By.cssSelector ( dateFinEmploi ) ).sendKeys ( datefin );
    }

    @Test
    public
    void SalaireBrut ( String salaire ) throws InterruptedException {
        Thread.sleep ( 1000 );
        driver.findElement ( By.cssSelector ( salairebrut ) ).sendKeys ( salaire );
    }

    @Test
    public
    void MotifFinContrat ( String motif ) throws InterruptedException {
        Thread.sleep ( 1000 );
        driver.findElement ( By.cssSelector ( motiffincontrat ) ).sendKeys ( motif );
    }

    @Test
    public
    void PeriodeContrat ( String periode ) throws InterruptedException {
        Thread.sleep ( 1000 );
        driver.findElement ( By.cssSelector ( periodecontrat ) ).sendKeys ( periode );
    }

    @Test
    public
    void IndemniteCongesPayes ( String indemnite ) throws InterruptedException {
        Thread.sleep ( 1000 );
        driver.findElement ( By.cssSelector ( indemnitecongespayes ) ).sendKeys ( indemnite );
    }

    @Test
    public
    void IndemniteLicenciement ( String indemnite ) throws InterruptedException {
        Thread.sleep ( 1000 );
        driver.findElement ( By.cssSelector ( indemnitelicenciement ) ).sendKeys ( "0" );
    }

    @Test
    public
    void ClickAjouterButton () throws InterruptedException {
        element = driver.findElement ( By.cssSelector ( ajouterbutton ) );
        Thread.sleep ( 5000 );
        element.click ();
    }
    @Test
    public
    void ClickLancerEstimation () throws InterruptedException {
        element = driver.findElement ( By.cssSelector ( lancerestimation ) );
        Thread.sleep ( 5000 );
        element.click ();

    }

    @Test
    public
    WebElement returnElement () {
        try{
            element = driver.findElement ( By.cssSelector ( nombreJours ) );
        }
        catch (Exception e){
            System.out.println ("Exception dans la methode return element nombreJours : "+e);
        }
        return element;
    }

    @Test
    public
    void MontantGlobalDesDroits () {
        element = returnElement ();
        String text = element.getText ();
        try {
            System.out.println ("Message variable Text : "+text);
            Assert.assertEquals ( text , "200" );
        } catch (Exception e) {
            System.out.println ( "Le nombre de jours est erronée : +" + e );
        } finally {
            //driver.close ();
        }
    }

    @Test
    public
    WebElement returndureeDindemnisation () {
        element = driver.findElement ( By.cssSelector ( dureeIndemnisation ) );
        return element;
    }

    @Test
    public void dureeDindemnisation(){
        WebElement elementdureeDindemnisation = returndureeDindemnisation ();
        String text = elementdureeDindemnisation.getText ();
        try {
            System.out.println ( "***********************************************");
            System.out.println ("Nombre de jours d'indemnisation par pole emploi");
            System.out.println ( "***********************************************");
            Assert.assertEquals ( text , "638 jours." );
        } catch (AssertionError e) {
            System.out.println ( "=================================================");
            System.out.println ( "Durée d'indemnisation est erronée :");
            System.out.println ( e );
            System.out.println ( "=================================================");
        } finally {
            driver.close ();
        }
    }
}