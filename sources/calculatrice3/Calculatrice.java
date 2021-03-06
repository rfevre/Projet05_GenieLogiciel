package calculatrice3;
import java.util.Stack;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Calculatrice {
    Stack<Double> resultat;
    HashMap<String,Operation> operations;

    public Calculatrice () {
	resultat = new Stack<Double>();
	operations = new HashMap<String,Operation>();
	for (Operation o: Operation.values())
	    operations.put(o.toString(),o);
    }

    public double calculer(String s) {
	StringTokenizer st = new StringTokenizer(s);
        String token;

	//On découpe la chaîne en Token
	while (st.hasMoreTokens()) {
	    token = st.nextToken();
	    //Si c'est une opération
	    if (operations.containsKey(token)) {
		//On fait le calcul
		for (Operation o: Operation.values()) {
		    if (o.toString().equals(token)) {
		        o.execute(resultat);
		    }
		}
	    }
	    //Sinon on enregistre le nombre dans la pile
	    else
		resultat.push(Double.parseDouble(token));
	}

	//On renvoie le haut de la pile
	return resultat.pop();
    }
}
