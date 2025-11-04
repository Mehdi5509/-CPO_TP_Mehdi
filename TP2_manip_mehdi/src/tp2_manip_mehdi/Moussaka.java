package tp2_manip_mehdi;

public class Moussaka {
    int nbCalories;

    public Moussaka(int nbCalories) {
        this.nbCalories = nbCalories;
    }

    @Override
    public String toString() {
        return "Moussaka : " + nbCalories + " calories";
    }
}
