package KavosAparatas3.src.lt.vcs.kavosaparatai.aparatai;

import KavosAparatas3.src.lt.vcs.kavosaparatai.puodeliai.KavosPuodelis;
import KavosAparatas3.src.lt.vcs.kavosaparatai.puodeliai.kavos.*;
import KavosAparatas3.src.lt.vcs.kavosaparatai.resursai.Produktai;;


public class KavosAparatas {

  
    private static final int PANAUDOJIMU_SKAICIUS_KADA_PLAUTI = 100;
    private static final int DEFAULT_PRODUCT_VALUE = 50;

   
    public Produktai produktai = null;

    private int panaudojimuSkaicius = 0;

   
    public KavosAparatas(int vandensKiekis, int cukrausKiekis, int pupeliuKiekis) {
     
        produktai = new Produktai(vandensKiekis, cukrausKiekis, pupeliuKiekis);
    }

    public KavosAparatas(int vandensKiekis) {
        this(vandensKiekis, DEFAULT_PRODUCT_VALUE, DEFAULT_PRODUCT_VALUE);
    }

    public KavosAparatas(int vandensKiekis, int pupeliuKiekis) {
        this(vandensKiekis, pupeliuKiekis, DEFAULT_PRODUCT_VALUE);
    }

    public KavosAparatas() {
       
        this(DEFAULT_PRODUCT_VALUE, DEFAULT_PRODUCT_VALUE, DEFAULT_PRODUCT_VALUE);
    }

    public enum KavosPuodeliai{
		Cukrine(new Cukrine()), Dviguba(new Dviguba()), Normali(new Cukrine());

    	private KavosPuodelis puodelis;
    	
    	private KavosPuodeliai(KavosPuodelis puodelis){
    	
    		this.puodelis=puodelis;
    			
    		
    	}
    	
    	
    	public KavosPuodelis getPuodelis(){
    		return puodelis;
    		
    	}
	}
    
   
    
    
    
    public KavosPuodelis gaminkKava(String kavosTipas) {

    	

    	
        KavosPuodelis puodelis = KavosPuodeliai.valueOf(kavosTipas).getPuodelis();
   
        if (puodelis != null)
            gaminkKava(puodelis);
        
        return puodelis; 
    }

    private void gaminkKava(KavosPuodelis puodelis) {
        Produktai produktai = puodelis.getProduktai();
        gaminkKava(produktai.getVandensKiekis(), produktai.getCukrausKiekis(), produktai.getPupeliuKiekis());
        puodelis.setKavaPagaminta(true);
    }

    
    private void gaminkKava(int vandensKiekis, int cukrausKiekis, int pupeliuKiekis) {
       
        if (arUzteksProduktu(vandensKiekis, cukrausKiekis, pupeliuKiekis) && !arReikiaPlovimo()) {
            produktai.setVandensKiekis(produktai.getVandensKiekis() - vandensKiekis);
            produktai.setCukrausKiekis(produktai.getCukrausKiekis() - cukrausKiekis);
            produktai.setPupeliuKiekis(produktai.getPupeliuKiekis() - pupeliuKiekis);

            this.panaudojimuSkaicius++;

            System.out.println("Skanios kavos!");
        }
    }

   
    public void ismurzinkAparata() {
        this.panaudojimuSkaicius = PANAUDOJIMU_SKAICIUS_KADA_PLAUTI;
        System.out.println("DEMSIO DEMESIO DEMESIO - APARATUI DIRBTINAI PADIDINTAS PANAUDOJIMU SKAICIUS");
    }

    public void atlikPlovima() {
        if (this.panaudojimuSkaicius == 0) {
            System.out.println("Aparatas jau isplautas");
        } else {
            this.panaudojimuSkaicius = 0;
            System.out.println("Aparatas sekmingai isplautas");
        }
    }

    public void sakykProduktuBusena() {
        System.out.println("Liko cukraus: " + produktai.getCukrausKiekis());
        System.out.println("Liko vandens: " + produktai.getVandensKiekis());
        System.out.println("Liko pupeliu: " + produktai.getPupeliuKiekis());
    }

    public void sakykAparatoBusena() {
        System.out.println("Liko iki plovimo: " + (PANAUDOJIMU_SKAICIUS_KADA_PLAUTI - panaudojimuSkaicius));
        sakykProduktuBusena();
    }

    public boolean arAparatasPasiruoses() {
        
        boolean pasiruoses = !arReikiaPlovimo() && arUzteksProduktu(1, 1, 1);
        if (pasiruoses) {
            System.out.println("Aparatas pasiruoses!");
        } else {
            System.out.println("Aparatas nepasiruoses!");
        }
        return pasiruoses;
    }

    public void isvalykProduktus() {
        produktai.setCukrausKiekis(0);
        produktai.setPupeliuKiekis(0);
        produktai.setVandensKiekis(0);
    }

    private boolean arReikiaPlovimo() {
        if (panaudojimuSkaicius >= PANAUDOJIMU_SKAICIUS_KADA_PLAUTI) {
            System.out.println("Reikalingas plovimas!");
            return true;
        } else {
            return false;
        }
    }

   
    private boolean arUzteksProduktu(int vandensKiekis, int cukrausKiekis, int pupeliuKiekis) {
        boolean uztenka = true;
        if (produktai.getVandensKiekis() - vandensKiekis < 0) {
            uztenka = false;
            System.out.println("Neuztenka vandens");
        }
        if (produktai.getCukrausKiekis() - cukrausKiekis < 0) {
            uztenka = false;
            System.out.println("Neuztenka cukraus");
        }
        if (produktai.getPupeliuKiekis() - pupeliuKiekis < 0) {
            uztenka = false;
            System.out.println("Neuztenka pupeliu");
        }
        return uztenka;
    }

    public void setProduktai(Produktai produktai) {
        this.produktai = produktai;
    }

    public Produktai getProduktai() {
        return this.produktai;
    }

    public Produktai getProduktaiKopija() {
        return this.produktai.gaukKopija();
    }

    
    public void papildykPupeliu(int pupeliuKiekis) {
        produktai.setPupeliuKiekis(produktai.getPupeliuKiekis() + pupeliuKiekis);
    }

    public void papildykCukraus(int cukrausKiekis) {
        produktai.setCukrausKiekis(produktai.getCukrausKiekis() + cukrausKiekis);
    }

    public void papildykVandens(int vandensKiekis) {
        produktai.setVandensKiekis(produktai.getVandensKiekis() + vandensKiekis);
    }

}
