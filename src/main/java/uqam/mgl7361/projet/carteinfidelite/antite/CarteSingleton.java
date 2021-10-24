package uqam.mgl7361.projet.carteinfidelite.antite;
public class CarteSingleton {

	@SuppressWarnings("unused")
	private int points;
	private static CarteSingleton instance;
	
	private CarteSingleton(){}

	public static synchronized CarteSingleton getInstance(){
        if(instance == null){
            instance = new CarteSingleton();
        }
        return instance;
    }

}